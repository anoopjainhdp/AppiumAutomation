/**
 * 
 */
package com.anoop.mobile.automation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.anoop.mobile.testcasejson.Element;
import com.anoop.mobile.testcasejson.Step;
import com.anoop.mobile.testcasejson.TestCase;
import com.anoop.mobile.testcasejson.TestCase_;
import com.anoop.mobile.utils.ConfigEnum;
import com.anoop.mobile.utils.ConfigManager;
import com.google.gson.Gson;

/**
 * @author ajain
 *
 */
public class TestClassGenerator {

	/**
	 * 
	 */
	public TestClassGenerator() {
	}

	/**
	 * Generate test class
	 */
	public void generateTestClass() {
		Gson gson = new Gson();
		String testCaseJson;
		try {
			String testFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
					+ File.separator + "resources" + File.separator + "testcases" + File.separator + "testcase.json";
			testCaseJson = FileUtils.readFileToString(new File(testFilePath));
			TestCase tc = gson.fromJson(testCaseJson, TestCase.class);
			
			createTestClass(tc.getTestFileName(),tc.getExtends(),tc.getTestCases());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void createTestClass(String testFileName, String extends1, List<TestCase_> testCases) {
		String retValue ="package tests;\nimport org.openqa.selenium.By;\nimport org.openqa.selenium.WebElement;\nimport org.testng.annotations.Test;";
		retValue += "\npublic class "+testFileName+" extends "+extends1+"{";
		
		List<String> testMethodCode = new ArrayList<String>();
		
		for(TestCase_ tc : testCases)
			testMethodCode.add(createTestMethodCode(tc));
		
		for(String tm : testMethodCode)
			retValue += tm;
		
		retValue += "}";
		
		String projectHome = ConfigManager.getConfigValue(ConfigEnum.PROJECT_HOME);
		String projectFolderName = ConfigManager.getConfigValue(ConfigEnum.MAVEN_ARTIFACTID);
		String fileName = projectHome+File.separator+projectFolderName+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"tests"+File.separator+testFileName+".java";
		try {
			FileUtils.writeStringToFile(new File(fileName), retValue);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String createTestMethodCode(TestCase_ tc) {
		String testMethod = tc.getTestMethod();
		String retValue = "";
		
		retValue = "\n@Test\npublic void "+testMethod+"(){\n";
		retValue += createElementCode(tc.getElements());
		retValue += createTestMethodCode(tc.getSteps());
		retValue += "}";
		return retValue;
	}

	private String createTestMethodCode(List<Step> steps) {
		String retValue = "";
		
		for(Step step : steps){
			retValue += step.getElement();
			retValue +=".";
			retValue += step.getAction();
			retValue +="(";
			if(step.getValue() != null)
				retValue += "\""+step.getValue()+"\"";
			retValue +=");\n";
		}
		
		return retValue;
	}

	private String createElementCode(List<Element> elements) {
		String retValue = "";
		
		for(Element elem : elements){
			String var = elem.getVar();
			String type = elem.getSelectorType();
			String selector = elem.getSelector();
			
			retValue += "WebElement  "+var+"= driver.findElement(By.";
			if(type.equals("id"))
				retValue += "id(";
			
			retValue += "\""+selector+"\"));\n";
		}
		
		return retValue;
	}



}

/**
 * 
 */
package com.anoop.test;

import java.io.File;

import org.testng.annotations.Test;

import com.anoop.mobile.automation.MobileTestProject;
import com.anoop.mobile.automation.TestClassGenerator;
import com.anoop.mobile.utils.ConfigEnum;
import com.anoop.mobile.utils.ConfigManager;
import com.anoop.mobile.utils.TemplateEngine;

/**
 * @author ajain
 *
 */
public class AppiumTest {

	/**
	 * 
	 */
	public AppiumTest() {
	}
		
		@Test
		public void testCreateProject(){
			MobileTestProject p = new MobileTestProject();
			String newProjectPath = ConfigManager.getConfigValue(ConfigEnum.PROJECT_HOME)+File.separator+ConfigManager.getConfigValue(ConfigEnum.MAVEN_ARTIFACTID);
			TemplateEngine.addFile("pom.xml.template", newProjectPath,"pom.xml");
			TemplateEngine.addFile("AndroidSetup.java.template", newProjectPath+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"tests","AndroidSetup.java");
			TemplateEngine.addFile("AppiumTest.java.template", newProjectPath+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"tests","AppiumTest.java");
			TestClassGenerator tcGen = new TestClassGenerator();
			tcGen.generateTestClass();
			p.runTests();
		}
		
	

}

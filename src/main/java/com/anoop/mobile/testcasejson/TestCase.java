package com.anoop.mobile.testcasejson;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class TestCase {

	@SerializedName("TestFileName")
	@Expose
	private String testFileName;
	@SerializedName("Extends")
	@Expose
	private String _extends;
	@SerializedName("TestCases")
	@Expose
	private List<TestCase_> testCases = new ArrayList<TestCase_>();

	/**
	 * 
	 * @return The testFileName
	 */
	public String getTestFileName() {
		return testFileName;
	}

	/**
	 * 
	 * @param testFileName
	 *            The TestFileName
	 */
	public void setTestFileName(String testFileName) {
		this.testFileName = testFileName;
	}

	/**
	 * 
	 * @return The _extends
	 */
	public String getExtends() {
		return _extends;
	}

	/**
	 * 
	 * @param _extends
	 *            The Extends
	 */
	public void setExtends(String _extends) {
		this._extends = _extends;
	}

	/**
	 * 
	 * @return The testCases
	 */
	public List<TestCase_> getTestCases() {
		return testCases;
	}

	/**
	 * 
	 * @param testCases
	 *            The TestCases
	 */
	public void setTestCases(List<TestCase_> testCases) {
		this.testCases = testCases;
	}

}
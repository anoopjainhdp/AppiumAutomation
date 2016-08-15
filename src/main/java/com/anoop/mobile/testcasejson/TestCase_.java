package com.anoop.mobile.testcasejson;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class TestCase_ {

	@SerializedName("Name")
	@Expose
	private String name;
	@SerializedName("Description")
	@Expose
	private String description;
	@SerializedName("TestMethod")
	@Expose
	private String testMethod;
	@SerializedName("Elements")
	@Expose
	private List<Element> elements = new ArrayList<Element>();
	@SerializedName("Steps")
	@Expose
	private List<Step> steps = new ArrayList<Step>();

	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 *            The Description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return The testMethod
	 */
	public String getTestMethod() {
		return testMethod;
	}

	/**
	 * 
	 * @param testMethod
	 *            The TestMethod
	 */
	public void setTestMethod(String testMethod) {
		this.testMethod = testMethod;
	}

	/**
	 * 
	 * @return The elements
	 */
	public List<Element> getElements() {
		return elements;
	}

	/**
	 * 
	 * @param elements
	 *            The Elements
	 */
	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

	/**
	 * 
	 * @return The steps
	 */
	public List<Step> getSteps() {
		return steps;
	}

	/**
	 * 
	 * @param steps
	 *            The Steps
	 */
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

}
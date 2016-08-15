package com.anoop.mobile.testcasejson;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Element {

	@SerializedName("var")
	@Expose
	private String var;
	@SerializedName("selectorType")
	@Expose
	private String selectorType;
	@SerializedName("selector")
	@Expose
	private String selector;

	/**
	 * 
	 * @return The var
	 */
	public String getVar() {
		return var;
	}

	/**
	 * 
	 * @param var
	 *            The var
	 */
	public void setVar(String var) {
		this.var = var;
	}

	/**
	 * 
	 * @return The selectorType
	 */
	public String getSelectorType() {
		return selectorType;
	}

	/**
	 * 
	 * @param selectorType
	 *            The selectorType
	 */
	public void setSelectorType(String selectorType) {
		this.selectorType = selectorType;
	}

	/**
	 * 
	 * @return The selector
	 */
	public String getSelector() {
		return selector;
	}

	/**
	 * 
	 * @param selector
	 *            The selector
	 */
	public void setSelector(String selector) {
		this.selector = selector;
	}

}
package com.anoop.mobile.testcasejson;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Step {

	@SerializedName("order")
	@Expose
	private Integer order;
	@SerializedName("element")
	@Expose
	private String element;
	@SerializedName("action")
	@Expose
	private String action;
	@SerializedName("value")
	@Expose
	private String value;

	/**
	 * 
	 * @return The order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * 
	 * @param order
	 *            The order
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	 * 
	 * @return The element
	 */
	public String getElement() {
		return element;
	}

	/**
	 * 
	 * @param element
	 *            The element
	 */
	public void setElement(String element) {
		this.element = element;
	}

	/**
	 * 
	 * @return The action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * 
	 * @param action
	 *            The action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * 
	 * @return The value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 
	 * @param value
	 *            The value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
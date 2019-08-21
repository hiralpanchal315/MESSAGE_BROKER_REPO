package com.example.demo;

import java.io.Serializable;

public class TopicVO implements Serializable {

	private String name;
	private String description;
	private String remarks;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Override
	public String toString() {
		return "TopicVO [name=" + name + ", description=" + description + ", remarks=" + remarks + "]";
	}
	
	
}

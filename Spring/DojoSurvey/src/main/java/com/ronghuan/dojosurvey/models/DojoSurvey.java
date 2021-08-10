package com.ronghuan.dojosurvey.models;

public class DojoSurvey {
	private String name;
	private String location;
	private String language;
	private String comment;
	
	
	// CONSTRUCTOR
	public DojoSurvey(String name, String location, String language, String comment) {
		this.name = name;
		this.location = location;
		this.language = language;
		this.comment = comment;
	}

	
	// GETTER/SETTER
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}

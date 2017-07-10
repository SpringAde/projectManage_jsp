package com.dgit.project.model;

import java.util.Date;

public class Project {
	private int id;
	private String title;
	private String content;
	private Date startDate;
	private Date endDate;
	private String state;
	
	public Project() {	}
	
	

	public Project(int id, String title, String content, Date startDate, Date endDate, String state) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.state = state;
	}



	public Project(String title, String content, Date startDate, Date endDate, String state) {
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.state = state;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}

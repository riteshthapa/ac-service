package com.aircraft.acservice.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;


public class Aircraft  {

	@NotNull(message="Id should be specified")
	private String id;
	
	@NotNull(message="type should be specified")
	private String type;
	
	@NotNull(message="size should be specified")
	private String size;
	
	private int priority;
	
//	private static final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	private String doe;
	
	public String getDoe() {
		return doe;
	}

	public void setDoe(String doe) {
		this.doe = doe;
	}

	public String getId() {
		return id;
	}
	
	public Aircraft() {
		
	}
	
	public Aircraft(String id , String type, String size) {
		this.id = id;
		this.type = type;
		this.size = size;
		
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
		
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	public void setPriority(int p) {
		this.priority = p;
	}
	
	public int getPriority() {
	  return priority;
	}

	@Override
	public String toString() {
		return "Aircraft [id=" + id + ", type=" + type + ", size=" + size + ", priority=" + priority + ", doe=" + doe
				+ "]";
	}
	
//	public Timestamp getStamp() {
//		return timestamp;
//	}
	
//	
//
//	public String toString(){
//        return "type: "+this.type+"-- size: "+this.size + "time:"+timestamp + " --Priority:"+priority;
//    }

//	public Timestamp getDoe() {
//		return doe;
//	}
//
//	public void setDoe(Timestamp doe) {
//		this.doe = doe;
//	}


	
}

package com.studentmanagement.models;

public class Course {

	private int cid;
	private String cname;
	private double cfees;
	private String duration;
	private int totalSeat;
	private int remainingSeat;
	
	public Course() {
		super();
		
	}

	public Course(int cid, String cname, double cfees, String duration, int totalSeat, int remainingSeat) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cfees = cfees;
		this.duration = duration;
		this.totalSeat = totalSeat;
		this.remainingSeat = remainingSeat;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public double getCfees() {
		return cfees;
	}

	public void setCfees(double cfees) {
		this.cfees = cfees;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public int getRemainingSeat() {
		return remainingSeat;
	}

	public void setRemainingSeat(int remainingSeat) {
		this.remainingSeat = remainingSeat;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", cfees=" + cfees + ", duration=" + duration
				+ ", totalSeat=" + totalSeat + ", remainingSeat=" + remainingSeat + "]";
	}
	
	

}

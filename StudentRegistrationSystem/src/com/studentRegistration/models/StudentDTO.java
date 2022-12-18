package com.studentRegistration.models;

public class StudentDTO {
	private int roll;
	private String sname;
	private int cid;
	private String cname;
	private int bid;
	private String bname;
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
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
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public StudentDTO(int roll, String sname, int cid, String cname, int bid, String bname) {
		super();
		this.roll = roll;
		this.sname = sname;
		this.cid = cid;
		this.cname = cname;
		this.bid = bid;
		this.bname = bname;
	}
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StudentDTO [roll=" + roll + ", sname=" + sname + ", cid=" + cid + ", cname=" + cname + ", bid=" + bid
				+ ", bname=" + bname + "]";
	}
	
}

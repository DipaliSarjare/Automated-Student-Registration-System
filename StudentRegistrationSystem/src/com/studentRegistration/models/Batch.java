package com.studentRegistration.models;

public class Batch {
	private int bid;
	private String bname;
	private String duration;
	private int cid;
	private int seats;
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Batch(int bid, String bname, String duration, int cid, int seats) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.duration = duration;
		this.cid = cid;
		this.seats = seats;
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
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", bname=" + bname + ", duration=" + duration + ", cid=" + cid + ", seats=" + seats
				+ "]";
	}
	
	
}

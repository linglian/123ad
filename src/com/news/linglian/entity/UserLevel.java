package com.news.linglian.entity;

public class UserLevel {
	private String lid;
	private String lname;
	private String minscore;
	private String maxscore;

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMinscore() {
		return minscore;
	}

	public void setMinscore(String minscore) {
		this.minscore = minscore;
	}

	public String getMaxscore() {
		return maxscore;
	}

	public void setMaxscore(String maxscore) {
		this.maxscore = maxscore;
	}

	@Override
	public String toString() {
		return "UserLevel [lid=" + lid + ", lname=" + lname + ", minscore="
				+ minscore + ", maxscore=" + maxscore + "]";
	}

}

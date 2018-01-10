package com.news.linglian.entity;

public class Log {
	private String logid;
	private String log;
	private String logdate;
	private String adminid;

	public String getLogid() {
		return logid;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getLogdate() {
		return logdate;
	}

	public void setLogdate(String logdate) {
		this.logdate = logdate;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	@Override
	public String toString() {
		return "Log [logid=" + logid + ", log=" + log + ", logdate=" + logdate
				+ ", adminid=" + adminid + "]";
	}
}

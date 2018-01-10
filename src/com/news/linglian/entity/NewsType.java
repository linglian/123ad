package com.news.linglian.entity;

public class NewsType {
	private String typeid;
	private String typename;

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@Override
	public String toString() {
		return "NewsType [typeid=" + typeid + ", typename=" + typename + "]";
	}

}

package com.koreait.integration1.domain;

public class Query {
	private String query;
	private String column;
	
	public Query() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Query(String query, String column) {
		super();
		this.query = query;
		this.column = column;
	}



	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = "%"+column+"%";
	}
	
	
	
}

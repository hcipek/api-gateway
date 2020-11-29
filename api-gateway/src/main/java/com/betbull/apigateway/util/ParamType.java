package com.betbull.apigateway.util;

public enum ParamType {

	ID("byid"),
	NAME("byname"),
	ID_PARAM("byid?id="),
	NAME_PARAM("byname?name=");
	
	public final String label;
	 
    private ParamType(String label) {
        this.label = label;
    }

}

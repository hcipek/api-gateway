package com.betbull.apigateway.util;

public enum ActionType {
	
	GET("get"),
	ALL("all"),
	CREATE("create"),
	DELETE("delete"),
	ACTIVE("active"),
	PASSIVE("passive"),
	RETIRE("retire"),
	RETIRED("retired"),
	UNASSIGN("unassign"),
	WITHOUTTEAM("withoutteam"),
	BASIC("basic"),
	CONTRACT_FEE("contractfeeof");
	
	
	public final String label;
	 
    private ActionType(String label) {
        this.label = label;
    }

}

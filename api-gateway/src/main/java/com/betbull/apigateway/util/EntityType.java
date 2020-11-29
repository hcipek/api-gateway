package com.betbull.apigateway.util;

public enum EntityType {
	
	PLAYER("player"),
	TEAM("team"),
	PLAYERMARKET("playermarket");
	
	public final String label;
	 
    private EntityType(String label) {
        this.label = label;
    }

}

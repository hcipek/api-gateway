package com.betbull.apigateway.util;

public class UriUtils {

	private static final String TEAM_SERVICE_BASE_URI = "http://localhost:8081/api/team";
	private static final String PLAYER_SERVICE_BASE_URI = "http://localhost:8082/api/player";
	private static final String PLAYER_MARKET_SERVICE_BASE_URI = "http://localhost:8083/api/playermarket";
	
	public static String getRequestURI(EntityType entityType, ActionType... actionTypes) {
		return getRequestURI(entityType, null, actionTypes);
	}
	
	public static String getRequestURI(EntityType entityType, ParamType paramType, ActionType... actionTypes) {
		String base = getBaseUri(entityType).concat("/");
		Boolean multipleResultRequest = Boolean.FALSE;
		for(ActionType action : actionTypes) {
			base+=action.label;
			multipleResultRequest = ActionType.ALL.equals(action) ? Boolean.TRUE : Boolean.FALSE;
		}
		base+=entityType.label;
		base = paramType != null ? base.concat(paramType.label) : base;
		return multipleResultRequest ? base.concat("s") : base;
	}
	
	private static String getBaseUri(EntityType entityType) {
		switch (entityType) {
			case PLAYER : 
				return PLAYER_SERVICE_BASE_URI;
			case TEAM :
				return TEAM_SERVICE_BASE_URI;
			case PLAYERMARKET :
				return PLAYER_MARKET_SERVICE_BASE_URI;
			default :
				return "";
		}
	}

}

package com.betbull.apigateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.betbull.apigateway.model.request.PlayerParamRequest;
import com.betbull.apigateway.model.request.PlayerRequest;
import com.betbull.apigateway.model.request.TeamRequest;
import com.betbull.apigateway.model.response.MultiPlayerResponse;
import com.betbull.apigateway.model.response.MultiTeamResponse;
import com.betbull.apigateway.model.response.PlayerMarketResponse;
import com.betbull.apigateway.model.response.PlayerMarketViewResponse;
import com.betbull.apigateway.model.response.PlayerResponse;
import com.betbull.apigateway.model.response.TeamResponse;
import com.betbull.apigateway.util.ActionType;
import com.betbull.apigateway.util.EntityType;
import com.betbull.apigateway.util.ParamType;
import com.betbull.apigateway.util.UriUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApiGatewayService {

	@Autowired
	private RestTemplate restTemplate;
	
	public PlayerResponse createPlayer(PlayerRequest request) {
		log.info("createPlayer started...");
		String playerApiUri = UriUtils.getRequestURI(EntityType.PLAYER, ActionType.CREATE);
		PlayerResponse response = restTemplate.postForObject(playerApiUri, request, PlayerResponse.class);
		return response;
	}
	
	public TeamResponse createTeam(TeamRequest request) {
		log.info("createTeam started...");
		String teamApiUri = UriUtils.getRequestURI(EntityType.TEAM, ActionType.CREATE);
		TeamResponse response = restTemplate.postForObject(teamApiUri, request, TeamResponse.class);
		return response;
	}
	
	public PlayerMarketResponse getPlayerMarket() {
		log.info("getPlayerMarket started...");
		String playerMarketApiUri = UriUtils.getRequestURI(EntityType.PLAYERMARKET, ActionType.GET);
		PlayerMarketResponse response = restTemplate.getForObject(playerMarketApiUri, PlayerMarketResponse.class);
		return response;
	}
	
	public PlayerMarketViewResponse getPlayerMarketForView() {
		log.info("getPlayerMarketForView started...");
		String playerMarketApiUri = UriUtils.getRequestURI(EntityType.PLAYERMARKET, ActionType.GET, ActionType.BASIC);
		PlayerMarketViewResponse response = restTemplate.getForObject(playerMarketApiUri, PlayerMarketViewResponse.class);
		return response;
	}
	
	public MultiPlayerResponse getAllPlayers() {
		log.info("getAllPlayers started...");
		String playerApiUri = UriUtils.getRequestURI(EntityType.PLAYER, ActionType.GET, ActionType.ALL);
		MultiPlayerResponse response = restTemplate.getForObject(playerApiUri, MultiPlayerResponse.class);
		return response;
	}
	
	public MultiTeamResponse getAllTeams() {
		log.info("getAllTeams started...");
		String teamApiUri = UriUtils.getRequestURI(EntityType.TEAM, ActionType.GET, ActionType.ALL);
		MultiTeamResponse response = restTemplate.getForObject(teamApiUri, MultiTeamResponse.class);
		return response;
	}
	
	public PlayerResponse deletePlayerById(Long id) {
		log.info("Deleting player with id : {} started...", id);
		PlayerResponse response = new PlayerResponse();
		String playerApiUri = UriUtils.getRequestURI(EntityType.PLAYER, ParamType.ID_PARAM, ActionType.DELETE);
		try{
			restTemplate.delete(playerApiUri+id);
			response.setDescription("SUCCESS");
			response.setResultCode(0);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			response.setDescription("COMMON_UNKNOWN_ERROR");
			response.setResultCode(900);
		}
		return response;
	}
	
	public TeamResponse deleteTeamById(Long id) {
		log.info("Deleting player with id : {} started...", id);
		TeamResponse response = new TeamResponse();
		String teamApiUri = UriUtils.getRequestURI(EntityType.TEAM, ParamType.ID_PARAM, ActionType.DELETE);
		try{
			restTemplate.delete(teamApiUri+id);
			response.setDescription("SUCCESS");
			response.setResultCode(0);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			response.setDescription("COMMON_UNKNOWN_ERROR");
			response.setResultCode(900);
		}
		return response;
	}
	
	public PlayerMarketViewResponse getPlayerSalaryById(Long id) {
		log.info("getPlayerSalaryById : {} started...", id);
		String playerMarketApiUri = UriUtils.getRequestURI(EntityType.PLAYERMARKET, ParamType.ID, ActionType.GET, ActionType.CONTRACT_FEE);
		PlayerMarketViewResponse response = new PlayerMarketViewResponse();
		PlayerParamRequest request = new PlayerParamRequest(id);
		try{
			response = restTemplate.postForObject(playerMarketApiUri, request, PlayerMarketViewResponse.class);
			return response;
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			response.setDescription("COMMON_UNKNOWN_ERROR");
			response.setResultCode(900);
			return response;
		}
	}


}

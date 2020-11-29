package com.betbull.apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betbull.apigateway.model.request.PlayerRequest;
import com.betbull.apigateway.model.request.TeamRequest;
import com.betbull.apigateway.model.response.MultiPlayerResponse;
import com.betbull.apigateway.model.response.MultiTeamResponse;
import com.betbull.apigateway.model.response.PlayerMarketResponse;
import com.betbull.apigateway.model.response.PlayerMarketViewResponse;
import com.betbull.apigateway.model.response.PlayerResponse;
import com.betbull.apigateway.model.response.TeamResponse;
import com.betbull.apigateway.service.ApiGatewayService;

@RestController
@RequestMapping("/api/gateway")
public class ApiGatewayController {
	
	@Autowired
	private ApiGatewayService apiGatewayService;
	
	@PostMapping("/createplayer")
	public PlayerResponse createPlayer(@RequestBody PlayerRequest request) {
		return apiGatewayService.createPlayer(request);
	}
	
	@PostMapping("/createteam")
	public TeamResponse createTeam(@RequestBody TeamRequest request) {
		return apiGatewayService.createTeam(request);
	}
	
	@GetMapping("/getdetailedplayermarket")
	public PlayerMarketResponse getDetailedPlayerMarket() {
		return apiGatewayService.getPlayerMarket();
	}

	@GetMapping("/getplayermarketforview")
	public PlayerMarketViewResponse getPlayerMarketForView() {
		return apiGatewayService.getPlayerMarketForView();
	}

	@GetMapping("/getallplayers")
	public MultiPlayerResponse getAllPlayers() {
		return apiGatewayService.getAllPlayers();
	}

	@GetMapping("/getallteams")
	public MultiTeamResponse getAllTeams() {
		return apiGatewayService.getAllTeams();
	}

	@DeleteMapping("/deleteplayerbyid")
	public PlayerResponse deletePlayerById(@RequestParam Long id) {
		return apiGatewayService.deletePlayerById(id);
	}

	@DeleteMapping("/deleteteambyid")
	public TeamResponse deleteTeamById(@RequestParam Long id) {
		return apiGatewayService.deleteTeamById(id);
	}

	@GetMapping("/getplayersalarybyid")
	public PlayerMarketViewResponse getPlayerSalaryById(@RequestParam Long id) {
		return apiGatewayService.getPlayerSalaryById(id);
	}

}

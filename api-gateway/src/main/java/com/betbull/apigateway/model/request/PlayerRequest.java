package com.betbull.apigateway.model.request;

import java.util.List;

import com.betbull.apigateway.model.dto.PlayerRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PlayerRequest {
	
	List<PlayerRequestDto> playerList;
	
	public PlayerRequest() {
		
	}

}

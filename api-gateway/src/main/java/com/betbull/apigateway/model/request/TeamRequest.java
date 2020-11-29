package com.betbull.apigateway.model.request;

import java.util.List;

import com.betbull.apigateway.model.dto.TeamRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class TeamRequest {
	
	List<TeamRequestDto> teamList;
	
	public TeamRequest() {
		
	}

}

package com.betbull.apigateway.model.response;

import java.util.List;

import com.betbull.apigateway.model.base.BaseResponse;
import com.betbull.apigateway.model.dto.TeamResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class MultiTeamResponse extends BaseResponse {

	private List<TeamResponseDto> teamList;
	
	public MultiTeamResponse() {
		super();
	}
}

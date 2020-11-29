package com.betbull.apigateway.model.response;

import java.util.List;

import com.betbull.apigateway.model.base.BaseResponse;
import com.betbull.apigateway.model.dto.PlayerResponseDto;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @Setter
@AllArgsConstructor
public class MultiPlayerResponse extends BaseResponse {
	
	List<PlayerResponseDto> playerList;
	
	public MultiPlayerResponse() {
		super();
	}

}

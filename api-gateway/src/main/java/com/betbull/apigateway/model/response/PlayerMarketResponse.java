package com.betbull.apigateway.model.response;

import java.util.List;

import com.betbull.apigateway.model.base.BaseResponse;
import com.betbull.apigateway.model.dto.PlayerMarketResponseDto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlayerMarketResponse extends BaseResponse {
	
	List<PlayerMarketResponseDto> playerMarketList;

	public PlayerMarketResponse( ) {
		
	}
}

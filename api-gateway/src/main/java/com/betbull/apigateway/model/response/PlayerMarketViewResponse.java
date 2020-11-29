package com.betbull.apigateway.model.response;
import java.util.List;

import com.betbull.apigateway.model.base.BaseResponse;
import com.betbull.apigateway.model.dto.PlayerMarketViewDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PlayerMarketViewResponse extends BaseResponse{
	
	List<PlayerMarketViewDto> playerMarketList;
	
	public PlayerMarketViewResponse() {
		super();
	}
	
}

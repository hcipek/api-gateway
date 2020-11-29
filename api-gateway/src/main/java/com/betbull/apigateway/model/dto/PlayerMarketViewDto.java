package com.betbull.apigateway.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PlayerMarketViewDto {
	private String playerName;
	private String teamName;
	private String position;
	private String overallPower;
	private String contractFee;

	public PlayerMarketViewDto() {
		
	}
}

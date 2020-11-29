package com.betbull.apigateway.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PlayerMarketResponseDto {
	
	private PlayerResponseDto player;
	private TeamResponseDto team;
	private BigDecimal contractFee;
	private String currencyCode;
	
	public PlayerMarketResponseDto() {
		
	}

}

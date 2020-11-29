package com.betbull.apigateway.model.dto;

import com.betbull.apigateway.model.base.BaseModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class TeamResponseDto extends BaseModel{
	
	private CurrencyDto currency;

	public TeamResponseDto() {
		super();
	}
}

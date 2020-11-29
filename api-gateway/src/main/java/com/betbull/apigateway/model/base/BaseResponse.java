package com.betbull.apigateway.model.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class BaseResponse {

	private int resultCode;
	private String description;
	
	public BaseResponse() {
		
	}
}

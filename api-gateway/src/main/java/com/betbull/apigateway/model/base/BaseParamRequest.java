package com.betbull.apigateway.model.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public abstract class BaseParamRequest {
	
	private Long id;
	private String name;
	
	public BaseParamRequest() {
		
	}

	public BaseParamRequest(Long id) {
		this.id = id;
	}
	
	public BaseParamRequest(String name) {
		this.name = name;
	}
}

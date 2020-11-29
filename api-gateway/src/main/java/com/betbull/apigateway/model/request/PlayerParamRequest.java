package com.betbull.apigateway.model.request;

import com.betbull.apigateway.model.base.BaseParamRequest;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlayerParamRequest extends BaseParamRequest {
	
	public PlayerParamRequest() {
		// TODO Auto-generated constructor stub
	}

	public PlayerParamRequest(Long id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	public PlayerParamRequest(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public PlayerParamRequest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}

package com.betbull.apigateway.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class TeamRequestDto {

	private String name;
	private Integer establishedYear;
	private String nation;

}

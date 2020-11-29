package com.betbull.apigateway.model.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PlayerRequestDto {
	
	private String name;
	private String teamName;
	private String contractBeginDate;
	private String contractEndDate;
	private String position;
	private String birthDate;
	private String careerBeginDate;
	private String nation;
	@JsonFormat(shape=JsonFormat.Shape.NUMBER)
	private BigDecimal attackPower;
	@JsonFormat(shape=JsonFormat.Shape.NUMBER)
	private BigDecimal defencePower;
	@JsonFormat(shape=JsonFormat.Shape.NUMBER)
	private BigDecimal physicalPower;
	private Long citizenshipNumber;
	
	public PlayerRequestDto() {
		
	}
	
}

package com.betbull.apigateway.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.betbull.apigateway.model.base.BaseModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PlayerResponseDto extends BaseModel {

	private String teamName;
	private Date careerBeginDate;
	private Date birthDate;
	private BigDecimal attackPower;
	private BigDecimal defencePower;
	private BigDecimal physicalPower;
	private BigDecimal overallPower;
	private String position;
	
	public PlayerResponseDto() {
		super();
	}
}

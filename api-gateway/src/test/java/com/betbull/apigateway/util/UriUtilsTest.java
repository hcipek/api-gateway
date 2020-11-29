package com.betbull.apigateway.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UriUtilsTest {

	@Test
	public void getBaseUriWithNoneEntityTest() {
		String uri = UriUtils.getRequestURI(EntityType.NONE, ActionType.ALL);
		assertEquals("/alls", uri);
	}
}

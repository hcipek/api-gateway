package com.betbull.apigateway.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.betbull.apigateway.model.dto.PlayerRequestDto;
import com.betbull.apigateway.model.dto.PlayerResponseDto;
import com.betbull.apigateway.model.dto.TeamRequestDto;
import com.betbull.apigateway.model.dto.TeamResponseDto;
import com.betbull.apigateway.model.request.PlayerRequest;
import com.betbull.apigateway.model.request.TeamRequest;
import com.betbull.apigateway.model.response.MultiPlayerResponse;
import com.betbull.apigateway.model.response.MultiTeamResponse;
import com.betbull.apigateway.model.response.PlayerMarketResponse;
import com.betbull.apigateway.model.response.PlayerMarketViewResponse;
import com.betbull.apigateway.model.response.PlayerResponse;
import com.betbull.apigateway.model.response.TeamResponse;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ApiGatewayControllerTest {
	
	@Autowired
	private ApiGatewayController apiGatewayController;
	
	private static String country = "MOZ";
	private static Long citizenshipNo = new Random().nextLong();
	private static String teamName = randomNameGenerator();
	
	@Test
	@Order(1)
	public void createNewPlayerTest() {
		PlayerRequest request = new PlayerRequest();
		request.setPlayerList(Collections.singletonList(createPlayer()));
		PlayerResponse response = apiGatewayController.createPlayer(request);
		assertEquals(0, response.getResultCode());
		assertEquals("SUCCESS", response.getDescription());
		
	}
	
	@Test
	@Order(2)
	public void createExistingPlayerTest() {
		PlayerRequest request = new PlayerRequest();
		request.setPlayerList(Collections.singletonList(createPlayer()));
		PlayerResponse response = apiGatewayController.createPlayer(request);
		assertEquals(700, response.getResultCode());
		assertEquals("PLAYER_ALREADY_EXISTS", response.getDescription());
	}
	
	@Test
	@Order(3)
	public void createNewTeamTest() {
		TeamRequest request = new TeamRequest();
		request.setTeamList(Collections.singletonList(new TeamRequestDto(teamName, 1900, "TANZANIA")));
		TeamResponse response = apiGatewayController.createTeam(request);
		assertEquals(0, response.getResultCode());
		assertEquals("SUCCESS", response.getDescription());
	}
	
	@Test
	@Order(4)
	public void createExistingTeamTest() {
		TeamRequest request = new TeamRequest();
		request.setTeamList(Collections.singletonList(new TeamRequestDto(teamName, 1900, "TANZANIA")));
		TeamResponse response = apiGatewayController.createTeam(request);
		assertEquals(800, response.getResultCode());
		assertEquals("TEAM_ALREADY_EXISTS", response.getDescription());
	}
	
	@Test
	@Order(5)
	public void getDetailedPlayerMarketTest() {
		PlayerMarketResponse response = apiGatewayController.getDetailedPlayerMarket();
		assertEquals(0, response.getResultCode());
		assertEquals("SUCCESS", response.getDescription());
		assertNotNull(response.getPlayerMarketList());
	}
	
	@Test
	@Order(6)
	public void getPlayerMarketForViewTest() {
		PlayerMarketViewResponse response = apiGatewayController.getPlayerMarketForView();
		assertEquals(0, response.getResultCode());
		assertEquals("SUCCESS", response.getDescription());
		assertNotNull(response.getPlayerMarketList());
	}
	
	@Test
	@Order(7)
	public void getExistPlayerSalaryByIdTest() {
		MultiPlayerResponse allPlayerResponse = apiGatewayController.getAllPlayers();
		PlayerMarketViewResponse response = apiGatewayController.getPlayerSalaryById(allPlayerResponse.getPlayerList().stream().findFirst().get().getId());
		assertEquals(0, response.getResultCode());
		assertEquals("SUCCESS", response.getDescription());
		assertNotNull(response.getPlayerMarketList());
	}
	
	@Test
	@Order(8)
	public void getNotExistPlayerSalaryByIdTest() {
		MultiPlayerResponse allPlayerResponse = apiGatewayController.getAllPlayers();
		List<Long> existingIdList = allPlayerResponse.getPlayerList().stream().map(PlayerResponseDto::getId).collect(Collectors.toList());
		Long notExistingId = existingIdList.stream().findFirst().get();
		while(existingIdList.contains(notExistingId)){
			notExistingId = new Random().nextLong();
		}
		PlayerMarketViewResponse response = apiGatewayController.getPlayerSalaryById(notExistingId);
		assertEquals(703, response.getResultCode());
		assertEquals("PLAYER_NOT_EXISTS", response.getDescription());
		assertEquals(CollectionUtils.isEmpty(response.getPlayerMarketList()), true);
	}
	
	@Test
	@Order(9)
	public void getAllTeamsTest() {
		MultiTeamResponse response = apiGatewayController.getAllTeams();
		assertEquals(0, response.getResultCode());
		assertEquals("SUCCESS", response.getDescription());
		assertNotNull(response.getTeamList());
	}
	
	@Test
	@Order(10)
	public void getAllPlayersTest() {
		MultiPlayerResponse response = apiGatewayController.getAllPlayers();
		assertEquals(0, response.getResultCode());
		assertEquals("SUCCESS", response.getDescription());
		assertNotNull(response.getPlayerList());
	}
	
	@Test
	@Order(11)
	public void deletePlayerByIdTest() {
		MultiPlayerResponse allPlayerResponse = apiGatewayController.getAllPlayers();
		Long id = allPlayerResponse.getPlayerList()
					.stream()
					.sorted(Comparator.comparing(PlayerResponseDto::getId).reversed())
					.map(PlayerResponseDto::getId)
					.findFirst()
					.get();
		PlayerResponse response = apiGatewayController.deletePlayerById(id);
		assertEquals(0, response.getResultCode());
		assertEquals("SUCCESS", response.getDescription());
	}
	
	@Test
	@Order(12)
	public void deleteTeamByIdTest() {
		MultiTeamResponse allTeamResponse = apiGatewayController.getAllTeams();
		Long id = allTeamResponse.getTeamList()
				.stream()
				.sorted(Comparator.comparing(TeamResponseDto::getId).reversed())
				.map(TeamResponseDto::getId)
				.findFirst()
				.get();
		TeamResponse response = apiGatewayController.deleteTeamById(id);
		assertEquals(0, response.getResultCode());
		assertEquals("SUCCESS", response.getDescription());
	}
	
	@Test
	@Order(13)
	public void deletePlayerByNullId() {
		PlayerResponse response = apiGatewayController.deletePlayerById(null);
		assertEquals(900, response.getResultCode());
		assertEquals("COMMON_UNKNOWN_ERROR", response.getDescription());
	}
	
	@Test
	@Order(14)
	public void deleteTeamByNullId() {
		TeamResponse response = apiGatewayController.deleteTeamById(null);
		assertEquals(900, response.getResultCode());
		assertEquals("COMMON_UNKNOWN_ERROR", response.getDescription());
	}
	
	@Test
	@Order(15)
	public void getPlayerSalaryByNullIdTest() {
		PlayerMarketViewResponse response = apiGatewayController.getPlayerSalaryById(null);
		assertEquals(900, response.getResultCode());
		assertEquals("COMMON_UNKNOWN_ERROR", response.getDescription());
		assertNotNull(response.getPlayerMarketList());
	}
	
	private static PlayerRequestDto createPlayer() {
		PlayerRequestDto player = new PlayerRequestDto();
		player.setAttackPower(BigDecimal.TEN);
		player.setBirthDate("01-01-1985");
		player.setCareerBeginDate("01-01-2000");
		player.setCitizenshipNumber(citizenshipNo);
		player.setContractBeginDate("01-01-2020");
		player.setContractEndDate("01-01-2024");
		player.setDefencePower(BigDecimal.TEN);
		player.setName(randomNameGenerator());
		player.setNation(country);
		player.setPhysicalPower(BigDecimal.TEN);
		player.setPosition("MF");
		player.setTeamName(null);
		return player;
	}
	
	private static String randomNameGenerator() {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    return generatedString;
	}

}

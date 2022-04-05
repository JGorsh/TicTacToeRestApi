package com.alex.restapi.tictactoe.controller;

import com.alex.restapi.tictactoe.entity.GamePlay;
import com.alex.restapi.tictactoe.entity.GameResult;
import com.alex.restapi.tictactoe.entity.Player;
import com.alex.restapi.tictactoe.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class RestApiControllerTest {

    @Mock
    PlayerService playerService;
    @Mock
    StepService stepService;
    @Mock
    GameResultService gameResultService;
    @Mock
    GameService gameService;
    @Mock
    GamePlayService gamePlayService;
    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    RestApiController restApiController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(restApiController).build();
    }

    @Test
    void getGameplay() throws Exception {

        mockMvc.perform(post("/gameplay")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getGameplayById() throws Exception {

        GamePlay gamePlay = new GamePlay();
        when(gamePlayService.getGamePlayById(1L)).thenReturn(gamePlay);

        HttpServletResponse response = mockMvc.perform(get("/gameplay/{id}",1L)).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void savePlayers() throws Exception {
//
//        Player player = new Player("1",'1');
//        GamePlay gamePlay = new GamePlay();
//        player.setGamePlay(gamePlay);
//        when(playerService.savePlayer(player)).thenReturn(player);
//
//        HttpServletResponse response = mockMvc.perform(get("/gameplay/player/{playerName}","1")).andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn().getResponse();
//
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void getPlayer() throws Exception {

        Player player = new Player();
        when(playerService.getPlayer(1L)).thenReturn(player);

        HttpServletResponse response = mockMvc.perform(get("/gameplay/players/{id}",1L)).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void getAllPlayers() throws Exception {

        List<Player> players = new ArrayList<>();
        when(playerService.getAllPlayers()).thenReturn(players);

        HttpServletResponse response = mockMvc.perform(get("/gameplay/players")).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void getGame() {

    }

    @Test
    void getGamePosition() {
    }

    @Test
    void initGame() {
    }

    @Test
    void getGameplayByIdAndContinue() {
    }

    @Test
    void getOnePlayer() {
    }
}
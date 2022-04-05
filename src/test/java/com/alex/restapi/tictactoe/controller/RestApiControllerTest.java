package com.alex.restapi.tictactoe.controller;

import com.alex.restapi.tictactoe.entity.GamePlay;
import com.alex.restapi.tictactoe.entity.GameResult;
import com.alex.restapi.tictactoe.entity.Player;
import com.alex.restapi.tictactoe.service.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

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
class RestApiControllerTest {

    @MockBean
    PlayerService playerService;
    @MockBean
    StepService stepService;
    @MockBean
    GameResultService gameResultService;
    @MockBean
    GameService gameService;
    @MockBean
    GamePlayService gamePlayService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GamePlay gamePlay;

    @MockBean
    List<Player> players;

    @Test
    void getGameplay() throws Exception {

        this.mockMvc.perform(post("/gameplay")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    void getGameplayById() throws Exception {
//
//        given(gamePlayService.getGamePlayById(1L)).willReturn(gamePlay);
//
////       MockHttpServletResponse response = mockMvc.perform(get("/gameplay/1")
////                        .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
////
////        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//
//        this.mockMvc.perform(get("/gameplay/{id}",1L)).andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void savePlayers() throws Exception {
    }

    @Test
    void getPlayer() {
    }

    @Test
    void getAllPlayers() throws Exception {
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
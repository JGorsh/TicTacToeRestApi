package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.entity.Game;
import com.alex.restapi.tictactoe.entity.GamePlay;
import com.alex.restapi.tictactoe.repository.GameRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameServiceImpTest {

    @Mock
    GameRepository gameRepository;

    @Mock
    Game game;

    @InjectMocks
    GameServiceImp gameServiceImp;

    @Test
    void saveGame() {
        when(gameServiceImp.saveGame(game)).thenReturn((game));
        Game game1 = gameRepository.save(game);
        Assert.assertEquals(game, game1);
    }
}
package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.entity.GamePlay;
import com.alex.restapi.tictactoe.entity.GameResult;
import com.alex.restapi.tictactoe.entity.Player;
import com.alex.restapi.tictactoe.repository.GameResultRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameResultServiceImpTest {

    @Mock
    GameResultRepository gameResultRepository;

    @Mock
    GameResult gameResult;

    @Mock
    Player player;

    @InjectMocks
    GameResultServiceImp gameResultServiceImp;

    @Test
    void save() {
        when(gameResultServiceImp.save(gameResult)).thenReturn((gameResult));
        GameResult gameResult1 = gameResultRepository.save(gameResult);
        Assert.assertEquals(gameResult, gameResult1);
    }

//    @Test
//    void create() {
//        Player player = new Player("1",'1');
//        GameResult gameResult = new GameResult();
//        when(gameResultServiceImp.create(player)).thenReturn((gameResult));
//        Assert.assertEquals(gameResult.getWinner(),player);
//    }

    @Test
    void getGameResult() {
        when(Optional.ofNullable(gameResultServiceImp.getGameResult(Mockito.anyLong()))).thenReturn(Optional.ofNullable(gameResult));
        Optional gamePlayOptional = gameResultRepository.findById(Mockito.anyLong());
        Assert.assertEquals(Optional.of(gameResult), gamePlayOptional);
    }
}
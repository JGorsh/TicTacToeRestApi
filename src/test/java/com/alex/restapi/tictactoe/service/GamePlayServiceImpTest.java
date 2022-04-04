package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.entity.GamePlay;
import com.alex.restapi.tictactoe.repository.GamePlayRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class GamePlayServiceImpTest {

    @Mock
    GamePlayRepository gamePlayRepository;

    @Mock
    GamePlay gamePlay;

    @InjectMocks
    GamePlayServiceImp gamePlayServiceImp;

    @Test
    void getGamePlayByIdTest() {
        when(Optional.ofNullable(gamePlayServiceImp.getGamePlayById(Mockito.anyLong()))).thenReturn(Optional.ofNullable(gamePlay));
        Optional gamePlayOptional = gamePlayRepository.findById(Mockito.anyLong());
        Assert.assertEquals(Optional.of(gamePlay), gamePlayOptional);
    }

    @Test
    void save() {
        when(gamePlayServiceImp.save(gamePlay)).thenReturn((gamePlay));
        GamePlay gamePlay1 = gamePlayRepository.save(gamePlay);
        Assert.assertEquals(gamePlay, gamePlay1);
    }
}
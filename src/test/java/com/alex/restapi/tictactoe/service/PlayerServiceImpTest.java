package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.entity.GamePlay;
import com.alex.restapi.tictactoe.entity.Player;
import com.alex.restapi.tictactoe.repository.PlayerRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PlayerServiceImpTest {

    @Mock
    PlayerRepository playerRepository;

    @Mock
    Player player;

    @Mock
    List<Player> players;

    @InjectMocks
    PlayerServiceImp playerServiceImp;

    @Test
    void getPlayer() {
        when(Optional.ofNullable(playerServiceImp.getPlayer(Mockito.anyLong()))).thenReturn(Optional.ofNullable(player));
        Optional gamePlayOptional = playerRepository.findById(Mockito.anyLong());
        Assert.assertEquals(Optional.of(player), gamePlayOptional);
    }

    @Test
    void savePlayer() {
        when(playerServiceImp.savePlayer(player)).thenReturn((player));
        Player player1 = playerRepository.save(player);
        Assert.assertEquals(player, player1);
    }

    @Test
    void getAllPlayers() {
        when(playerServiceImp.getAllPlayers()).thenReturn(players);
        List<Player> players1 = playerRepository.findAll();
        Assert.assertEquals(players, players1);
    }

    @Test
    void getAllPlayersByGamePlayId() {
        when(playerServiceImp.getAllPlayersByGamePlayId(Mockito.anyLong())).thenReturn(players);
        List<Player> players1 = playerRepository.findAllByGamePlay_Id(Mockito.anyLong());
        Assert.assertEquals(players, players1);
    }
}
package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.entity.Player;
import com.alex.restapi.tictactoe.exceptions.InvalidIdException;
import com.alex.restapi.tictactoe.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlayerServiceImp implements PlayerService{

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Player getPlayer(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new InvalidIdException("invalid playerId"));
        return player;
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}

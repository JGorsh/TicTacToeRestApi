package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.entity.Game;
import com.alex.restapi.tictactoe.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GameServiceImp implements GameService{

    @Autowired
    GameRepository gameRepository;

    @Override
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }
}

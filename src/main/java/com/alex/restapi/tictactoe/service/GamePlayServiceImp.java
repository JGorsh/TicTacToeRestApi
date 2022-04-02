package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.entity.GamePlay;
import com.alex.restapi.tictactoe.exceptions.InvalidIdException;
import com.alex.restapi.tictactoe.repository.GamePlayRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GamePlayServiceImp implements GamePlayService{

    @Autowired
    GamePlayRepository gamePlayRepository;


    @Override
    public GamePlay getGamePlayById(Long id) {
        GamePlay gamePlay = gamePlayRepository.findById(id).orElseThrow(() -> new InvalidIdException("invalid id"));
        return gamePlay;
    }
}

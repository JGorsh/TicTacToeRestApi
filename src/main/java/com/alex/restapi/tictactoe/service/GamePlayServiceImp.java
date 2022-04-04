package com.alex.restapi.tictactoe.service;


import com.alex.restapi.tictactoe.entity.GamePlay;
import com.alex.restapi.tictactoe.repository.GamePlayRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class GamePlayServiceImp implements GamePlayService{

    @Autowired
    GamePlayRepository gamePlayRepository;

    @Override
    public GamePlay getGamePlayById(Long id) {
        GamePlay gamePlayOne = null;
        Optional<GamePlay> gamePlay = gamePlayRepository.findById(id);
        if(gamePlay.isPresent()){
            gamePlayOne = gamePlay.get();
        }
        return gamePlayOne;
    }


    @Override
    public GamePlay save(GamePlay gameplay) {
        return gamePlayRepository.save(gameplay);
    }

}

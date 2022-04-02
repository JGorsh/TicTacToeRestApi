package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.entity.GameResult;
import com.alex.restapi.tictactoe.entity.Player;
import com.alex.restapi.tictactoe.exceptions.InvalidIdException;
import com.alex.restapi.tictactoe.repository.GameResultRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GameResultServiceImp implements GameResultService{

    @Autowired
    GameResultRepository gameResultRepository;

    @Override
    public GameResult save(GameResult gameResult) {
        return gameResultRepository.save(gameResult);
    }

    @Override
    public GameResult create(Player player) {
        GameResult gameResult = new GameResult();
        gameResult.setWinner(player);
        var saveGameResult = save(gameResult);
        return saveGameResult;
    }

    @Override
    public GameResult getGameResult(Long id) {
        return gameResultRepository.findById(id).orElseThrow(() -> new InvalidIdException("invalid playerId"));
    }
}

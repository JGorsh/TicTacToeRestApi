package com.alex.restapi.tictactoe.service;


import com.alex.restapi.tictactoe.entity.GameResult;
import com.alex.restapi.tictactoe.entity.Player;

public interface GameResultService{

    public GameResult save(GameResult gameResult);

    public GameResult create(Player player);

    public GameResult getGameResult(Long id);

}

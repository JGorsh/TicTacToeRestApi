package com.alex.restapi.tictactoe.service;


import com.alex.restapi.tictactoe.entity.GamePlay;


public interface GamePlayService{

    public GamePlay getGamePlayById(Long id);

    public GamePlay save(GamePlay gameplay);

}

package com.alex.restapi.tictactoe.service;


import com.alex.restapi.tictactoe.entity.GamePlay;
import com.alex.restapi.tictactoe.entity.Player;

import java.util.List;

public interface GamePlayService{

    public GamePlay getGamePlayById(Long id);

    //public List<Player> getAllGamePlayByPlayerId(Long playerId);

    public GamePlay save(GamePlay gameplay);

}

package com.alex.restapi.tictactoe.service;


import com.alex.restapi.tictactoe.entity.Player;

import java.util.List;

public interface PlayerService{

    public Player getPlayer(Long id);

    public Player savePlayer(Player player);

    public List<Player> getAllPlayers();

}

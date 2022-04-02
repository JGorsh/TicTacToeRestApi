package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerServiceImp implements PlayerService{

    @Autowired
    PlayerRepository playerRepository;

}

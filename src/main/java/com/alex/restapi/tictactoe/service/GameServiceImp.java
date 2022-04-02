package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GameServiceImp implements GameService{

    @Autowired
    GameRepository gameRepository;
}

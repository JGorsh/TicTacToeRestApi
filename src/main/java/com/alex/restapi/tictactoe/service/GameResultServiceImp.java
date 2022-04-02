package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.repository.GameResultRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GameResultServiceImp implements GameResultService{

    @Autowired
    GameResultRepository gameResultRepository;
}

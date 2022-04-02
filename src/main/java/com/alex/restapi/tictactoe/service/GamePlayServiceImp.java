package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.repository.GamePlayRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GamePlayServiceImp implements GamePlayService{

    @Autowired
    GamePlayRepository gamePlayRepository;
}

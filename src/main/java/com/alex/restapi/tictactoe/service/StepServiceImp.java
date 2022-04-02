package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.entity.Player;
import com.alex.restapi.tictactoe.entity.Step;
import com.alex.restapi.tictactoe.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StepServiceImp implements StepService{

    @Autowired
    StepRepository stepRepository;
    @Autowired
    GameResultService gameResultService;
    @Autowired
    GamePlayService gamePlayService;

    @Override
    public Step saveStep(Step step) {
        return stepRepository.save(step);
    }
}

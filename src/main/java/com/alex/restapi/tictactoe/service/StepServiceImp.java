package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.entity.Step;
import com.alex.restapi.tictactoe.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Integer> findAllPositions(Long id) {
        List<Integer> listPosition = new ArrayList<>();
        List<Step> listStep = stepRepository.findAllByGame_Id(id);
        for(Step step:listStep){
            listPosition.add(step.getPlayerPosition());
        }
        return listPosition;
    }
}

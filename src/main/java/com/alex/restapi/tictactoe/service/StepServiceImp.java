package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.entity.Player;
import com.alex.restapi.tictactoe.entity.Step;
import com.alex.restapi.tictactoe.repository.StepRepository;
import com.alex.restapi.tictactoe.view.ViewResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class StepServiceImp implements StepService{

    @Autowired
    StepRepository stepRepository;

    @Override
    public ViewResponse setStep(Player player, int position) {
        Step step = new Step(player, position);
        stepRepository.save(step);
        return new ViewResponse(player);
    }
}

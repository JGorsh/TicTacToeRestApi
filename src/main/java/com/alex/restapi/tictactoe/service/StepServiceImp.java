package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StepServiceImp implements StepService{

    @Autowired
    StepRepository stepRepository;
}

package com.alex.restapi.tictactoe.service;


import com.alex.restapi.tictactoe.entity.Step;

import java.util.List;

public interface StepService{

    Step saveStep (Step step);

    List<Integer> findAllPositions(Long id);
}

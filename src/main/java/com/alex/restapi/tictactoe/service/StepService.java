package com.alex.restapi.tictactoe.service;


import com.alex.restapi.tictactoe.entity.Player;
import com.alex.restapi.tictactoe.entity.Step;

public interface StepService{

    Step saveStep (Player player, int position);
}

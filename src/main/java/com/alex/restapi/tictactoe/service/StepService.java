package com.alex.restapi.tictactoe.service;


import com.alex.restapi.tictactoe.entity.Player;
import com.alex.restapi.tictactoe.view.ViewResponse;

public interface StepService{

    ViewResponse setStep (Player player, int position);
}

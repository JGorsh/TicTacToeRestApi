package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.entity.GamePlay;
import com.alex.restapi.tictactoe.entity.Step;
import com.alex.restapi.tictactoe.repository.StepRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StepServiceImpTest {

    @Mock
    StepRepository stepRepository;

    @Mock
    Step step;

    @Mock
    List<Integer> mockList;

    @InjectMocks
    StepServiceImp stepServiceImp;

    @Test
    void saveStep() {
        when(stepServiceImp.saveStep(step)).thenReturn((step));
        Step step1 = stepRepository.save(step);
        Assert.assertEquals(step, step1);
    }
}
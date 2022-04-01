package com.alex.restapi.tictactoe.repository;


import com.alex.restapi.tictactoe.entity.Step;
import org.springframework.data.repository.CrudRepository;


public interface StepRepository extends CrudRepository<Step, Integer> {
}

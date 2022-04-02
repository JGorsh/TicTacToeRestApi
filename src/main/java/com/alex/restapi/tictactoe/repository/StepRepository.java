package com.alex.restapi.tictactoe.repository;


import com.alex.restapi.tictactoe.entity.Step;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StepRepository extends JpaRepository<Step, Long> {
}

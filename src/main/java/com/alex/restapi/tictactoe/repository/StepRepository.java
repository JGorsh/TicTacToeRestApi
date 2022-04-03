package com.alex.restapi.tictactoe.repository;


import com.alex.restapi.tictactoe.entity.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StepRepository extends JpaRepository<Step, Long> {

    List<Step> findAllByGame_Id(Long id);
}

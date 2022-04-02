package com.alex.restapi.tictactoe.repository;

import com.alex.restapi.tictactoe.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepository extends JpaRepository<Game, Long> {
}

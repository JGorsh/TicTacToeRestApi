package com.alex.restapi.tictactoe.repository;

import com.alex.restapi.tictactoe.entity.GameResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameResultRepository extends JpaRepository<GameResult, Long> {
}

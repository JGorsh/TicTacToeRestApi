package com.alex.restapi.tictactoe.repository;

import com.alex.restapi.tictactoe.entity.GameResult;
import org.springframework.data.repository.CrudRepository;

public interface GameResultRepository extends CrudRepository<GameResult, Integer> {
}

package com.alex.restapi.tictactoe.repository;

import com.alex.restapi.tictactoe.entity.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {
}

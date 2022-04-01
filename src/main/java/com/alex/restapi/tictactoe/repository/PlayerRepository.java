package com.alex.restapi.tictactoe.repository;

import com.alex.restapi.tictactoe.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
}

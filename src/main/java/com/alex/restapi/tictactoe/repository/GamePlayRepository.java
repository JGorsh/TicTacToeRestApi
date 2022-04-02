package com.alex.restapi.tictactoe.repository;

import com.alex.restapi.tictactoe.entity.GamePlay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamePlayRepository extends JpaRepository<GamePlay, Long> {
}

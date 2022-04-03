package com.alex.restapi.tictactoe.repository;

import com.alex.restapi.tictactoe.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    public List<Player> findAllByGamePlay_Id(Long id);
}

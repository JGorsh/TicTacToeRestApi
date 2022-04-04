package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.entity.Player;
import com.alex.restapi.tictactoe.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;



public class PlayerServiceImp implements PlayerService{

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Player getPlayer(Long id) {
        Player playerOne = null;
        Optional<Player> player = playerRepository.findById(id);
        if(player.isPresent()){
            playerOne = player.get();
        }
        return playerOne;
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> getAllPlayersByGamePlayId(Long id) {
        return playerRepository.findAllByGamePlay_Id(id);
    }
}

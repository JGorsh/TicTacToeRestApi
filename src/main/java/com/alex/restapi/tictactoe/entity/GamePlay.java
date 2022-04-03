package com.alex.restapi.tictactoe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class GamePlay {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonProperty("Player")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gamePlay")
    //@OneToMany(cascade = CascadeType.ALL)
    private List<Player> players = new ArrayList<>();

    @JsonProperty("Game")
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "gamePlay")
    @OneToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @JsonProperty("GameResult")
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "gamePlay")
    @OneToOne
    @JoinColumn(name = "game_result_id")
    private GameResult gameResult;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public GamePlay() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

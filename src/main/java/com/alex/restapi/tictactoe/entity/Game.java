package com.alex.restapi.tictactoe.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @JsonProperty("Step")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    public List<Step> stepList; // список шагов

    //@JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "game_id")
    private GamePlay gamePlay;

    public Game() {
    }

    public List<Step> getStepList() {
        return stepList;
    }

    public void setStepList(List<Step> stepList) {
        this.stepList = stepList;
    }

    public GamePlay getGamePlay() {
        return gamePlay;
    }

    public void setGamePlay(GamePlay gamePlay) {
        this.gamePlay = gamePlay;
    }
}

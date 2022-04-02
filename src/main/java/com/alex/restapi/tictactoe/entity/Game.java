package com.alex.restapi.tictactoe.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @JsonProperty("Step")
    @OneToMany(mappedBy = "game")
    public List<Step> stepList = new ArrayList<>(); // список шагов

    @OneToOne(cascade = CascadeType.ALL,
            mappedBy = "game")
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

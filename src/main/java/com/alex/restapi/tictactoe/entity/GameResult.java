package com.alex.restapi.tictactoe.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class GameResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonProperty("Player")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "winner_id")
    public Player winner; // победитель

    @OneToOne(cascade = CascadeType.ALL,
            mappedBy = "gameResult")
    private GamePlay gamePlay;

}

package com.alex.restapi.tictactoe.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

    @Column
    private int playerPosition;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id")
    private Game game;

    public Step(Player player, int playerPosition) {
        this.player = player;
        this.playerPosition = playerPosition;
    }

    public Step() {
    }
}

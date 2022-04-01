package com.alex.restapi.tictactoe.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @JsonProperty("Step")
    @OneToMany(mappedBy = "game")
    public List<Step> stepList; // список шагов

}
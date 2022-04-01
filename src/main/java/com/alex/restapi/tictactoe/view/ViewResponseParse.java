package com.alex.restapi.tictactoe.view;


import com.alex.restapi.tictactoe.entity.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ViewResponseParse {

    private List<char[][]> board;
    private Player winnerPlay;

    public ViewResponseParse() {

        this.board = com.alex.tictactoe.view.GameBoard.list;
        this.winnerPlay = Model.winnerPlay;

    }

}

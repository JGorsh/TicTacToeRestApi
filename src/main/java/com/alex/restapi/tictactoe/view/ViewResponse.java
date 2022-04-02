package com.alex.restapi.tictactoe.view;


import com.alex.restapi.tictactoe.entity.Player;
import com.alex.restapi.tictactoe.utils.Util;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewResponse {

    private char[][] boardView;
    private Player winnerPlay;
    private String responseMessage;
    Util util = new Util();

    public ViewResponse() {
        this.boardView = util.boardView;
        //this.responseMessage = View.responseMessageView;
        this.winnerPlay = util.winnerPlay;

    }
}

package com.alex.restapi.tictactoe.view;


import com.alex.restapi.tictactoe.entity.Player;
import com.alex.restapi.tictactoe.utils.Util;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ViewResponse {

    private char[][] boardView;
    private Player player;
    private String responseMessage;

    public ViewResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ViewResponse(Player player, String responseMessage) {
        this.player = player;
        this.boardView = Util.boardView;
        this.responseMessage = responseMessage;
    }

}

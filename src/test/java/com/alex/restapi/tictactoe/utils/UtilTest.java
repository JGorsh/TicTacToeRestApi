package com.alex.restapi.tictactoe.utils;

import com.alex.restapi.tictactoe.entity.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    char[][] boardView = {
            {'|', '1', '|', '2', '|', '3', '|'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'|', '4', '|', '5', '|', '6', '|'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'|', '7', '|', '8', '|', '9', '|'}
    };

    Player player = new Player("alex", 'X');


    @Test
    void checkProgressTest() {

        Util.boardView[0][1] = 'X';
        Util.boardView[0][3] = 'X';
        Util.boardView[0][5] = 'X';
        assertTrue(Util.checkProgress('X'));

        Util.boardView = boardView;

        Util.boardView[2][1] = 'X';
        Util.boardView[2][3] = 'X';
        Util.boardView[2][5] = 'X';
        assertTrue(Util.checkProgress('X'));

        Util.boardView = boardView;

        Util.boardView[4][1] = 'X';
        Util.boardView[4][3] = 'X';
        Util.boardView[4][5] = 'X';
        assertTrue(Util.checkProgress('X'));

        Util.boardView = boardView;

        Util.boardView[0][1] = 'X';
        Util.boardView[2][1] = 'X';
        Util.boardView[4][1] = 'X';
        assertTrue(Util.checkProgress('X'));

        Util.boardView = boardView;

        Util.boardView[0][3] = 'X';
        Util.boardView[2][3] = 'X';
        Util.boardView[4][3] = 'X';
        assertTrue(Util.checkProgress('X'));

        Util.boardView = boardView;

        Util.boardView[0][5] = 'X';
        Util.boardView[2][5] = 'X';
        Util.boardView[4][5] = 'X';
        assertTrue(Util.checkProgress('X'));

        Util.boardView = boardView;

        Util.boardView[0][1] = 'X';
        Util.boardView[2][3] = 'X';
        Util.boardView[4][5] = 'X';
        assertTrue(Util.checkProgress('X'));

        Util.boardView = boardView;

        Util.boardView[0][5] = 'X';
        Util.boardView[2][3] = 'X';
        Util.boardView[4][1] = 'X';
        assertTrue(Util.checkProgress('X'));

        Util.boardView = boardView;
    }

    @Test
    void choicePositionTest() {
        Util.choicePosition(Util.boardView,1,player);
        assertTrue(Util.boardView[0][1]=='X');
        Util.choicePosition(Util.boardView,2,player);
        assertTrue(Util.boardView[0][3]=='X');
        Util.choicePosition(Util.boardView,3,player);
        assertTrue(Util.boardView[0][5]=='X');
        Util.choicePosition(Util.boardView,4,player);
        assertTrue(Util.boardView[2][1]=='X');
        Util.choicePosition(Util.boardView,5,player);
        assertTrue(Util.boardView[2][3]=='X');
        Util.choicePosition(Util.boardView,6,player);
        assertTrue(Util.boardView[2][5]=='X');
        Util.choicePosition(Util.boardView,7,player);
        assertTrue(Util.boardView[4][1]=='X');
        Util.choicePosition(Util.boardView,8,player);
        assertTrue(Util.boardView[4][3]=='X');
        Util.choicePosition(Util.boardView,9,player);
        assertTrue(Util.boardView[4][5]=='X');

        Util.boardView = boardView;

    }

    @Test
    void progressHandlerTest() {
    }

    @Test
    void initBoardTest() {
        Util.initBoard();
        assertTrue(Util.winnerPlay==null);
        assertTrue(Util.isWin);
        assertTrue(Util.count==0);
    }
}
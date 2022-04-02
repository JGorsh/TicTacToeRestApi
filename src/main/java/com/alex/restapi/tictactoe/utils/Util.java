package com.alex.restapi.tictactoe.utils;


import com.alex.restapi.tictactoe.entity.*;
import com.alex.restapi.tictactoe.service.GameResultService;
import com.alex.restapi.tictactoe.view.ViewResponse;
import org.springframework.beans.factory.annotation.Autowired;


public class Util {

    @Autowired
    GameResultService gameResultService;

    public static Player winnerPlay ; // победитель
    private boolean isNext = true; // флаг результата
    public static int count; // запись количества ходов
    public static char[][] boardView = {
            {'|', '1', '|', '2', '|', '3', '|'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'|', '4', '|', '5', '|', '6', '|'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'|', '7', '|', '8', '|', '9', '|'}
    }; // форма поля

    //метод проверки массива на соответствие выиграшных вариантов
    public static Boolean checkProgress(char symbol) {
        if ((boardView[0][1] == symbol && boardView[0][3] == symbol && boardView[0][5] == symbol) ||
                (boardView[2][1] == symbol && boardView[2][3] == symbol && boardView[2][5] == symbol) ||
                (boardView[4][1] == symbol && boardView[4][3] == symbol && boardView[4][5] == symbol) ||

                (boardView[0][1] == symbol && boardView[2][1] == symbol && boardView[4][1] == symbol) ||
                (boardView[0][3] == symbol && boardView[2][3] == symbol && boardView[4][3] == symbol) ||
                (boardView[0][5] == symbol && boardView[2][5] == symbol && boardView[4][5] == symbol) ||

                (boardView[0][1] == symbol && boardView[2][3] == symbol && boardView[4][5] == symbol) ||
                (boardView[0][5] == symbol && boardView[2][3] == symbol && boardView[4][1] == symbol)) {

            return true;
        } else return false;
    }


    //метод обработки выбора позиции
    public static void choicePosition(char[][] boardView, int position, Player player) {

        char symbol = player.getSymbol();

        switch (position) {
            case 1:
                boardView[0][1] = symbol;
                break;
            case 2:
                boardView[0][3] = symbol;
                break;
            case 3:
                boardView[0][5] = symbol;
                break;
            case 4:
                boardView[2][1] = symbol;
                break;
            case 5:
                boardView[2][3] = symbol;
                break;
            case 6:
                boardView[2][5] = symbol;
                break;
            case 7:
                boardView[4][1] = symbol;
                break;
            case 8:
                boardView[4][3] = symbol;
                break;
            case 9:
                boardView[4][5] = symbol;
                break;
        }
    }

    public static ViewResponse progressHandler(Player player){
        count++;
        String message = "Продолжайте игру!";
        if(Util.checkProgress(player.getSymbol()))
        {
            message = "Победитель " + player.getName();
            Util.winnerPlay = player;
            return new ViewResponse(player, message);
        }
        if (Util.count==9){
            message = "Ничья!";
            return new ViewResponse(message);
        }
        return new ViewResponse(player, message);
    }

//    //сброс переменных при выборе: продолжить игру
//    public static void initBoard() {
//        char[][] boardViewClean = {
//                {'|', '1', '|', '2', '|', '3', '|'},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {'|', '4', '|', '5', '|', '6', '|'},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {'|', '7', '|', '8', '|', '9', '|'}
//        };
//        boardView = boardViewClean;
//        moveList = new ArrayList<>();
//        com.alex.tictactoe.model.Model.stepList = new ArrayList<>();
//    }

}

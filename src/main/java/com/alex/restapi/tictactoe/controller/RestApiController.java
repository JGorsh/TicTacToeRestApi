package com.alex.restapi.tictactoe.controller;


import com.alex.restapi.tictactoe.entity.*;
import com.alex.restapi.tictactoe.repository.GameRepository;
import com.alex.restapi.tictactoe.repository.GameResultRepository;
import com.alex.restapi.tictactoe.repository.PlayerRepository;
import com.alex.restapi.tictactoe.repository.StepRepository;
import com.alex.restapi.tictactoe.utils.Util;
import com.alex.restapi.tictactoe.view.ViewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RestApiController {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    StepRepository stepRepository;
    @Autowired
    GameResultRepository gameResultRepository;
    @Autowired
    GameRepository gameRepository;

    Util util = new Util();

    @RequestMapping(value = "/gameplay", method = RequestMethod.GET)
    public String getGameplay (){

        return "Введите в Body request (/gameplay/onePlayer), (/gameplay/twoPlayer) id, name, symbol игроков в JSON формате ";
    }

    @RequestMapping(value = "/gameplay/onePlayer", method = RequestMethod.POST)
    public List<Player> getOnePlayer (@RequestBody Player player){
        util.gamePlay.getPlayers().add(player);

        playerRepository.save(player);
        return util.gamePlay.getPlayers();
    }

    @RequestMapping(value = "/gameplay/twoPlayer", method = RequestMethod.POST)
    public List<Player> getTwoPlayer (@RequestBody Player player){
        util.gamePlay.getPlayers().add(player);
        playerRepository.save(player);
        return util.gamePlay.getPlayers();
    }

    @RequestMapping(value = "/gameplay/game", method = RequestMethod.GET)
    public char[][] getGame (){
        return util.boardView;
    }

    @RequestMapping(value = "/gameplay/game/{currentPlayer}/{position}", method = RequestMethod.GET)
    public ViewResponse getGamePosition (@PathVariable String currentPlayer, @PathVariable int position){

        if (currentPlayer.equals(Model.firstPlayer)){
             step = new Step(Model.onePlay,position,game);


             stepRepository.save(step);
        }
        else if (currentPlayer.equals(Model.secondPlayer)){
             step = new Step(Model.twoPlay, position,game);

             stepRepository.save(step);
        }

        Model.stepList.add(step);
        Model.choicePosition(Model.boardView, position, currentPlayer);
        Model.moveList.add(position);

        SaveParseJSON saveParseJSON = new SaveParseJSON();

        if (Model.checkProgress('X')) {
            Model.winner = Model.firstPlayer;
            Model.winnerPlay = Model.onePlay;
            //Player winner = playerRepository.findById(1).orElse(null);
            gameResult.setWinner(Model.winnerPlay);
            gameResultRepository.save(gameResult);

            game.setStepList((List<Step>) stepRepository.findAll());
            gameRepository.save(game);

            saveParseJSON.save();
            View.responseMessageView = "Победил первый игрок! Результаты игры сохранены!";
        }

        if (Model.checkProgress('0')) {
            Model.winner = Model.secondPlayer;
            Model.winnerPlay = Model.twoPlay;
            //Player winner = playerRepository.findById(2).orElse(null);
            gameResult.setWinner(Model.winnerPlay);
            gameResultRepository.save(gameResult);

            game.setStepList(Model.stepList);
            gameRepository.save(game);

            saveParseJSON.save();
            View.responseMessageView = "Победил второй игрок! Результаты игры сохранены!";
        }

        if (Model.moveList.size() == 9) {
            Model.winner = "Ничья!";
            Model.winnerPlay = null;
            gameResult.setWinner(null);
            gameResultRepository.save(gameResult);

            game.setStepList(Model.stepList);
            gameRepository.save(game);

            saveParseJSON.save();
            View.responseMessageView = "Ничья! Результаты игры сохранены!";
        }

        ViewResponse view = new ViewResponse();
        return view;
    }

    @RequestMapping(value = "/gameplay/init", method = RequestMethod.GET)
    public String initGame () {
        Model.initBoard();
        gameplay= new GamePlay();
        Model.winnerPlay = null;
        stepRepository.deleteAll();
        View.responseMessageView = "Продолжаем игру!";
        return "Можно начать новую игру!";
    }

    @RequestMapping(value = "/gameplay/archive", method = RequestMethod.POST)
    public ViewResponseParse getOnePlayer (@RequestBody Root root){

        Model.onePlay = root.getGamePlay().getPlayers().get(0);
        Model.firstPlayer = Model.onePlay.getName();
        Model.twoPlay = root.getGamePlay().getPlayers().get(1);
        Model.secondPlayer = Model.twoPlay.getName();
        Model.winnerPlay = root.getGamePlay().gameResult.getWinner();
        Model.winner = Model.winnerPlay.getName();


        for(Step step : root.getGamePlay().getGame().stepList) {
            Model.choicePosition(Model.boardView, step.getPlayerPosition(), step.getPlayer().getName());
            GameBoard.printBoardBody(Model.boardView);

        }
        return new ViewResponseParse();
    }

}

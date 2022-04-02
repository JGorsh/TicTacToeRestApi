package com.alex.restapi.tictactoe.controller;


import com.alex.restapi.tictactoe.entity.*;
import com.alex.restapi.tictactoe.service.*;
import com.alex.restapi.tictactoe.utils.Util;
import com.alex.restapi.tictactoe.view.ViewResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RestApiController {

    @Autowired
    PlayerService playerService;
    @Autowired
    StepService stepService;
    @Autowired
    GameResultService gameResultService;
    @Autowired
    GameService gameService;
    @Autowired
    GamePlayService gamePlayService;
    Util util;

//    @RequestMapping(value = "/gameplay", method = RequestMethod.GET)
//    public GamePlay getGameplay (){
//        return util.gamePlay;
//    }

    @RequestMapping(value = "/gameplay/{id}", method = RequestMethod.GET)
    public GamePlay getGameplayById (@PathVariable Long id){
        return gamePlayService.getGamePlayById(id);
    }

    @RequestMapping(value = "/gameplay/players", method = RequestMethod.POST)
    public List<Player> savePlayers (@RequestBody Player player){
        playerService.savePlayer(player);
        return playerService.getAllPlayers();
    }

    @RequestMapping(value = "/gameplay/players/{id}", method = RequestMethod.GET)
    public Player getPlayer(@PathVariable Long id) {
        return playerService.getPlayer(id);
    }

    @RequestMapping(value = "/gameplay/game", method = RequestMethod.GET)
    public char[][] getGame (){
        return util.boardView;
    }

    @RequestMapping(value = "/gameplay/game/{currentPlayerId}/{position}", method = RequestMethod.GET)
    public ViewResponse getGamePosition (@PathVariable Long currentPlayerId, @PathVariable int position){
        Player player = playerService.getPlayer(currentPlayerId);
        util.choicePosition(util.boardView, position,player);
        return stepService.setStep(player,position);


//        Model.stepList.add(step);
//        Model.choicePosition(Model.boardView, position, currentPlayer);
//        Model.moveList.add(position);
//
//        SaveParseJSON saveParseJSON = new SaveParseJSON();
//
//        if (Model.checkProgress('X')) {
//            Model.winner = Model.firstPlayer;
//            Model.winnerPlay = Model.onePlay;
//            //Player winner = playerRepository.findById(1).orElse(null);
//            gameResult.setWinner(Model.winnerPlay);
//            gameResultRepository.save(gameResult);
//
//            game.setStepList((List<Step>) stepRepository.findAll());
//            gameRepository.save(game);
//
//            saveParseJSON.save();
//            View.responseMessageView = "Победил первый игрок! Результаты игры сохранены!";
//        }
//
//        if (Model.checkProgress('0')) {
//            Model.winner = Model.secondPlayer;
//            Model.winnerPlay = Model.twoPlay;
//            //Player winner = playerRepository.findById(2).orElse(null);
//            gameResult.setWinner(Model.winnerPlay);
//            gameResultRepository.save(gameResult);
//
//            game.setStepList(Model.stepList);
//            gameRepository.save(game);
//
//            saveParseJSON.save();
//            View.responseMessageView = "Победил второй игрок! Результаты игры сохранены!";
//        }
//
//        if (Model.moveList.size() == 9) {
//            Model.winner = "Ничья!";
//            Model.winnerPlay = null;
//            gameResult.setWinner(null);
//            gameResultRepository.save(gameResult);
//
//            game.setStepList(Model.stepList);
//            gameRepository.save(game);
//
//            saveParseJSON.save();
//            View.responseMessageView = "Ничья! Результаты игры сохранены!";
//        }
//
//        ViewResponse view = new ViewResponse();
//        return view;
    }
//
//    @RequestMapping(value = "/gameplay/init", method = RequestMethod.GET)
//    public String initGame () {
//        Model.initBoard();
//        gameplay= new GamePlay();
//        Model.winnerPlay = null;
//        stepRepository.deleteAll();
//        View.responseMessageView = "Продолжаем игру!";
//        return "Можно начать новую игру!";
//    }
//
//    @RequestMapping(value = "/gameplay/archive", method = RequestMethod.POST)
//    public ViewResponseParse getOnePlayer (@RequestBody Root root){
//
//        Model.onePlay = root.getGamePlay().getPlayers().get(0);
//        Model.firstPlayer = Model.onePlay.getName();
//        Model.twoPlay = root.getGamePlay().getPlayers().get(1);
//        Model.secondPlayer = Model.twoPlay.getName();
//        Model.winnerPlay = root.getGamePlay().gameResult.getWinner();
//        Model.winner = Model.winnerPlay.getName();
//
//
//        for(Step step : root.getGamePlay().getGame().stepList) {
//            Model.choicePosition(Model.boardView, step.getPlayerPosition(), step.getPlayer().getName());
//            GameBoard.printBoardBody(Model.boardView);
//
//        }
//        return new ViewResponseParse();
//    }

}

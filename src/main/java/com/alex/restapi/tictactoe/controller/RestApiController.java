package com.alex.restapi.tictactoe.controller;


import com.alex.restapi.tictactoe.entity.*;
import com.alex.restapi.tictactoe.service.*;
import com.alex.restapi.tictactoe.utils.Util;
import com.alex.restapi.tictactoe.view.ViewResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    Game game;
    GamePlay gamePlay;
    GameResult gameResult;
    Step step;
    Player player;


    @RequestMapping(value = "/gameplay", method = RequestMethod.POST)
    public GamePlay getGameplay (){
        gamePlay = new GamePlay();
        gamePlayService.save(gamePlay);
        return gamePlay;
    }

    @RequestMapping(value = "/gameplay/{id}", method = RequestMethod.GET)
    public GamePlay getGameplayById (@PathVariable Long id){
        return gamePlayService.getGamePlayById(id);
    }

    @RequestMapping(value = "/gameplay/player/{playerName}", method = RequestMethod.GET)
    public Player savePlayers (@PathVariable String playerName){
        if(player==null){
            player = new Player(playerName,'X');
        }
        else player = new Player(playerName,'0');

        player.setGamePlay(gamePlay);
        playerService.savePlayer(player);
        return player;
    }

    @RequestMapping(value = "/gameplay/players/{id}", method = RequestMethod.GET)
    public Player getPlayer(@PathVariable Long id) {
        return playerService.getPlayer(id);
    }

    @RequestMapping(value = "/gameplay/players", method = RequestMethod.GET)
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @RequestMapping(value = "/gameplay/game", method = RequestMethod.GET)
    public char[][] getGame (){
        return Util.boardView;
    }

    @RequestMapping(value = "/gameplay/game/{currentPlayerId}/{position}", method = RequestMethod.GET)
    public ViewResponse getGamePosition (@PathVariable Long currentPlayerId, @PathVariable int position){

        Player player = playerService.getPlayer(currentPlayerId);
        Util.choicePosition(Util.boardView, position,player);

        game = new Game();

        step = new Step(player, position);
        step.setGame(game);
        stepService.saveStep(step);
        gameService.saveGame(game);

        gamePlay.setGame(game);
        gamePlayService.save(gamePlay);

        ViewResponse viewResponse = Util.progressHandler(player);
        if (Util.winnerPlay!=null){
            gameResult = gameResultService.save(gameResultService.create(player));
            gamePlay.setGameResult(gameResult);
            gamePlayService.save(gamePlay);
        }

        return viewResponse;
    }

    @RequestMapping(value = "/gameplay/init", method = RequestMethod.GET)
    public String initGame () {
        Util.initBoard();
        player = null;
        return "Можно начать новую игру!";
    }

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

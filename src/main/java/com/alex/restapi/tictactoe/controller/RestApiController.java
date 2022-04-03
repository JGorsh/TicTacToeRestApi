package com.alex.restapi.tictactoe.controller;


import com.alex.restapi.tictactoe.entity.*;
import com.alex.restapi.tictactoe.exceptions.DataException;
import com.alex.restapi.tictactoe.service.SaveParseJSON;
import com.alex.restapi.tictactoe.service.*;
import com.alex.restapi.tictactoe.utils.Util;
import com.alex.restapi.tictactoe.view.GameBoard;
import com.alex.restapi.tictactoe.view.ViewResponse;
import com.alex.restapi.tictactoe.view.ViewResponseParse;
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
        game = new Game();
        gameResult = new GameResult();
        gameResult.setGamePlay(gamePlay);
        game.setGamePlay(gamePlay);
        gamePlayService.save(gamePlay);
        gameService.saveGame(game);
        return gamePlay;
    }

    @RequestMapping(value = "/gameplay/{id}", method = RequestMethod.GET)
    public GamePlay getGameplayById (@PathVariable Long id){
        GamePlay gamePlayId = gamePlayService.getGamePlayById(id);
        if(gamePlayId==null){
            throw new DataException("Игры с id ="+id + " не существует!");
        }
        return gamePlayId;
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
        Player playerById = playerService.getPlayer(id);
        if(playerById==null){
            throw new DataException("Игрока с id ="+id + " не существует!");
        }
        return playerById;
    }

    @RequestMapping(value = "/gameplay/players", method = RequestMethod.GET)
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

//    @RequestMapping(value = "/gameplay/game", method = RequestMethod.GET)
//    public char[][] getGame (){
//        return Util.boardView;
//    }

    @RequestMapping(value = "/gameplay/game/{currentPlayerId}/{position}", method = RequestMethod.GET)
    public ViewResponse getGamePosition (@PathVariable Long currentPlayerId, @PathVariable int position){

        Player currentPlayer = playerService.getPlayer(currentPlayerId);
        Util.choicePosition(Util.boardView, position,currentPlayer);

        step = new Step(currentPlayer, position);
        step.setGame(game);
        stepService.saveStep(step);
        gamePlay.setGame(game);
        gamePlayService.save(gamePlay);

        ViewResponse viewResponse = Util.progressHandler(currentPlayer);
        if (Util.winnerPlay!=null){

            gameResult = gameResultService.create(currentPlayer);
            gameResult.setGamePlay(gamePlay);
            gameResultService.save(gameResult);
            gamePlay.setGameResult(gameResult);
            gamePlayService.save(gamePlay);
            new SaveParseJSON().save(gamePlayService.getGamePlayById(gamePlay.getId()));
        }

        return viewResponse;
    }

    @RequestMapping(value = "/gameplay/init", method = RequestMethod.GET)
    public String initGame () {
        Util.initBoard();
        player = null;
        return "Можно начать новую игру!";
    }

    @RequestMapping(value = "/gameplay/{id}/continue", method = RequestMethod.GET)
    public ViewResponse getGameplayByIdAndContinue (@PathVariable Long id){
        Util.initBoard();
        player = null;
        gamePlay = gamePlayService.getGamePlayById(id);
        game = gamePlay.getGame();
        List<Step> steps = gamePlay.getGame().getStepList();

        for(Step step : steps){
            Util.choicePosition(Util.boardView, step.getPlayerPosition(),step.getPlayer());
            player = step.getPlayer();
        }
        ViewResponse viewResponse = Util.progressHandler(player);

        return viewResponse;
    }

    @RequestMapping(value = "/gameplay/archive", method = RequestMethod.POST)
    public ViewResponseParse getOnePlayer (@RequestBody Root root){

        Util.winnerPlay = root.getGamePlay().getGameResult().getWinner();

        for(Step step : root.getGamePlay().getGame().getStepList()) {
            Util.choicePosition(Util.boardView, step.getPlayerPosition(), step.getPlayer());
            GameBoard.printBoardBody(Util.boardView);
        }
        return new ViewResponseParse();
    }

}

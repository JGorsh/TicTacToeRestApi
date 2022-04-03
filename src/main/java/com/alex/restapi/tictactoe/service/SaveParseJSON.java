package com.alex.restapi.tictactoe.service;

import com.alex.restapi.tictactoe.entity.GamePlay;
import com.alex.restapi.tictactoe.entity.Root;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SaveParseJSON implements SaveParseInterface {

    // дата игры для уникальности имени файла
    public static SimpleDateFormat formater = new SimpleDateFormat("yyyy_MM_dd  HH_mm_ss");
    public static Date date = new Date();
    public static String dateFile = formater.format(date);


    @Override
    public void save(GamePlay gamePlay){

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        Root root = new Root();
        root.setGamePlay(gamePlay);

        try {
            objectMapper.writeValue(new File(gamePlay.getPlayers().get(0).getName() + " и " +
                    gamePlay.getPlayers().get(1).getName() + " " + dateFile + ".json"), root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void parse(String url){
//        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
//
//        JsonNode nodePlayers = null;
//        JsonNode nodeStep = null;
//        JsonNode nodeGameResult = null;
//        try {
//            nodePlayers = objectMapper.readTree(new File(url)).get("GamePlay").get("Player");
//            nodeStep = objectMapper.readTree(new File(url)).get("GamePlay").get("Game").get("Step");
//            nodeGameResult = objectMapper.readTree(new File(url)).get("GamePlay").get("GameResult").get("Player");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        GamePlay gamePlay = new GamePlay();
//        try {
//            gamePlay.setPlayers(Arrays.asList(objectMapper.readValue(nodePlayers.toString(), Player[].class)));
//            Model.stepList = Arrays.asList(objectMapper.readValue(nodeStep.toString(), Step[].class));
//            Model.winnerPlay = objectMapper.readValue(nodeGameResult.toString(),Player.class);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        Model.onePlay = gamePlay.getPlayers().get(0);
//        Model.firstPlayer = Model.onePlay.getName();
//        Model.twoPlay = gamePlay.getPlayers().get(1);
//        Model.secondPlayer = Model.twoPlay.getName();
//    }
}

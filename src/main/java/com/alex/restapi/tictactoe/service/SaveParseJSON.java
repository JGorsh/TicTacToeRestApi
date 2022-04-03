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
}

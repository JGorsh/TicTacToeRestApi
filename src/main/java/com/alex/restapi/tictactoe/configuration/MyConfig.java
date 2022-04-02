package com.alex.restapi.tictactoe.configuration;


import com.alex.restapi.tictactoe.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.alex.restapi.tictactoe")
public class MyConfig {

    @Bean
    public PlayerService playerServiceConf(){
        return new PlayerServiceImp();
    }

    @Bean
    public GamePlayService gamePlayServiceConf(){
        return new GamePlayServiceImp();
    }

    @Bean
    public GameResultService gameResultServiceConf(){
        return new GameResultServiceImp();
    }

    @Bean
    public GameService gameServiceConf(){
        return new GameServiceImp();
    }

    @Bean
    public StepService stepServiceConf(){
        return new StepServiceImp();
    }
}

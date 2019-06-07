package com.zonetech;

import com.zonetech.entity.Robot;
import com.zonetech.service.FileCommandReader;
import com.zonetech.service.PlayGame;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EntityScan("com.zonetech")
public class Application {

    private static final String filePath = "src/main/resources/command-list.txt";

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        FileCommandReader fileCommandReader = new FileCommandReader(filePath);
        PlayGame playGame = new PlayGame(fileCommandReader);
        Robot robot = playGame.startGame();

    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }


}
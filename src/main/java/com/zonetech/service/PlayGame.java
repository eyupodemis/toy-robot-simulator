package com.zonetech.service;

import com.zonetech.entity.*;
import com.zonetech.exception.RobotException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class PlayGame {


    private final CommandReader commandReader;

    public PlayGame(CommandReader commandReader) {
        this.commandReader = commandReader;
    }

    public Robot startGame(){

        System.out.println("game started");

        Coordinate coordinate = new Coordinate(0,0);
        Board board = new Board(5,5);
        Robot robot = new Robot(coordinate,  board);

        boolean placeFlag = false;

        do {

            String commandStr = commandReader.getNextCommand();
            Command command = CommandFactory.create(commandStr);


            if(command.getCommandType().equals(CommandType.PLACE) && board.isValidCoordinate(((PlaceCommand)command).getCoordinate()))
                placeFlag = true;

            if(placeFlag)
               command.applyCommand(robot);

            if(command.getCommandType().equals(CommandType.REPORT))
                placeFlag = false;

        }while(commandReader.getCommandList().size() != 0);

        return robot;
    }

}

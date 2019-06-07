package com.zonetech.entity;

import com.zonetech.exception.RobotException;

import java.util.Optional;

public class CommandFactory {

    public static Command create(String commandString) {
        String[] strArr = commandString.split(" ");
        try{
           CommandType commandType = CommandType.valueOf(strArr[0]);

            switch (commandType) {
                case PLACE:
                    return new PlaceCommand(new Coordinate(Integer.valueOf(strArr[1].split(",")[0]),
                                                           Integer.valueOf(strArr[1].split(",")[1])),
                                           Direction.valueOf(strArr[1].split(",")[2])
                            );
                case MOVE:
                    return new MoveCommand();
                case LEFT:
                    return new LeftCommand();
                case RIGHT:
                    return new RightCommand();
                case REPORT:
                    return new ReportCommand();
                default:
                    throw new RobotException("Invalid command");
            }
        }catch (IllegalArgumentException ex){
            throw new RobotException("Illegal Command " + strArr[0]);
        }

    }
}

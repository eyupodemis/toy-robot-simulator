package com.zonetech.entity;

public class MoveCommand extends Command {

    public MoveCommand() {
        super(CommandType.MOVE);
    }

    @Override
    public  void applyCommand(Robot robot){
        robot.move();
    }

}

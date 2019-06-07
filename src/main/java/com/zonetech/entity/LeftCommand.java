package com.zonetech.entity;

public class LeftCommand extends Command {

    public LeftCommand() {
        super(CommandType.LEFT);
    }

    @Override
    public void applyCommand(Robot robot) {
        robot.turnLeft();
    }
}

package com.zonetech.entity;

public class RightCommand extends Command {

    public RightCommand() {
        super(CommandType.RIGHT);
    }

    @Override
    public void applyCommand(Robot robot) {
        robot.turnRight();
    }
}

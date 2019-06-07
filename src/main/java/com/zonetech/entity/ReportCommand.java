package com.zonetech.entity;

public class ReportCommand extends Command {

    public ReportCommand() {
        super(CommandType.REPORT);
    }

    @Override
    public void applyCommand(Robot robot) {
        System.out.println(robot.report());
    }
}

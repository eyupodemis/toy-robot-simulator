package com.zonetech.entity;

public abstract class Command {

    private final CommandType commandType;

    public Command(CommandType commandType) {
        this.commandType = commandType;
    }

    public abstract  void applyCommand(Robot robot);

    public CommandType getCommandType() {
        return commandType;
    }
}

package com.zonetech.service;

import com.zonetech.exception.RobotException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class FileCommandReader implements CommandReader {

    private List<String> commandList = new LinkedList<>();

    private String filePath;

    public FileCommandReader(List<String> commandList){
        this.commandList = commandList;
    }

    public FileCommandReader(String filePath) throws RobotException {

        try {

            this.commandList = Files.lines(Paths.get(filePath)).collect(Collectors.toList());

        } catch (IOException ex) {

            throw new RobotException("File path not found " + filePath);

        }

    }

    @Override
    public String getNextCommand(){

        String str = this.commandList.get(0);
        commandList.remove(0);
        return str;

    }

    @Override
    public List<String> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<String> commandList) {
        this.commandList = commandList;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}

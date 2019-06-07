package com.zonetech.service;

import java.util.List;

public interface CommandReader {

     String getNextCommand();

     List<String> getCommandList();
}

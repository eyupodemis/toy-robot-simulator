package com.zonetech;

import com.zonetech.entity.*;
import com.zonetech.exception.RobotException;
import com.zonetech.service.FileCommandReader;
import com.zonetech.service.PlayGame;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RobotTest {

  //  @Autowired
  //  FileCommandReader readFromFile;

    private static final String filePath = "src/main/resources/command-list.txt";
    private static FileCommandReader fileCommandReader;
    private static PlayGame playGame;
    private List<String> commandList;
    Robot robot;

    @Before
    public void runBeforeClass(){
        commandList = new LinkedList<>();
    }

    @Test()
    public void validCommandTest(){

        commandList = new LinkedList<>();
        commandList.add("PLACE 0,0,NORTH");
        commandList.add("MOVE");
        commandList.add("MOVE");
        commandList.add("REPORT");
        fileCommandReader = new FileCommandReader(commandList);

        FileCommandReader reader = mock(FileCommandReader.class);
        when(reader.getCommandList()).thenReturn(commandList);

        playGame = new PlayGame(fileCommandReader);
        robot = playGame.startGame();
        assertEquals(0, robot.getCoordinate().getX());
        assertEquals(2, robot.getCoordinate().getY());

    }

    @Test(expected = RobotException.class)
    public void invalidCommandTest(){
        commandList.add("PLACE 0,0,NORTH");
        commandList.add("FLY");
        commandList.add("MOVE");
        commandList.add("REPORT");
        fileCommandReader = new FileCommandReader(commandList);

        FileCommandReader reader = mock(FileCommandReader.class);
        when(reader.getCommandList()).thenReturn(commandList);

        playGame = new PlayGame(fileCommandReader);
        robot = playGame.startGame();
    }


    @Test
    public void doNotProcessForOutOfTableMoveTest(){
        commandList.add("PLACE 0,0,WEST");
        commandList.add("MOVE");
        commandList.add("MOVE");
        commandList.add("REPORT");
        fileCommandReader = new FileCommandReader(commandList);

        FileCommandReader reader = mock(FileCommandReader.class);
        when(reader.getCommandList()).thenReturn(commandList);

        playGame = new PlayGame(fileCommandReader);
        robot = playGame.startGame();

        assertEquals(0, robot.getCoordinate().getX());
        assertEquals(0, robot.getCoordinate().getY());
    }

    @Test
    public void doNotProcessWhenFirstCommandIsNotPlaceTest(){
        commandList.add("MOVE");
        commandList.add("MOVE");
        commandList.add("MOVE");
        commandList.add("REPORT");
        fileCommandReader = new FileCommandReader(commandList);

        FileCommandReader reader = mock(FileCommandReader.class);
        when(reader.getCommandList()).thenReturn(commandList);

        playGame = new PlayGame(fileCommandReader);
        robot = playGame.startGame();

        assertEquals(0, robot.getCoordinate().getX());
        assertEquals(0, robot.getCoordinate().getY());
    }


    @Test
    public void initialCommandCoordinateOutOfBoardTest(){
        commandList.add("PLACE 6,0,WEST");
        commandList.add("MOVE");
        commandList.add("MOVE");
        commandList.add("MOVE");
        commandList.add("REPORT");
        fileCommandReader = new FileCommandReader(commandList);

        FileCommandReader reader = mock(FileCommandReader.class);
        when(reader.getCommandList()).thenReturn(commandList);

        playGame = new PlayGame(fileCommandReader);
        robot = playGame.startGame();
        assertEquals(0, robot.getCoordinate().getX());
        assertEquals(0, robot.getCoordinate().getY());

    }
}

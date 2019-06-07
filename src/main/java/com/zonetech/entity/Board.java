package com.zonetech.entity;

public class Board {

    private final int rows;
    private final int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public boolean isValidCoordinate(Coordinate coordinate) {
        boolean result = !(coordinate.getX() > this.columns || coordinate.getX() < 0 ||
                 coordinate.getY() > this.rows || coordinate.getY() < 0
        );

        if(!result)
           System.out.println("Bad move, out of board!");

        return result;
    }

}

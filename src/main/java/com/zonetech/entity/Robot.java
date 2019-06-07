package com.zonetech.entity;

import org.springframework.stereotype.Component;

public class Robot {


    private Coordinate coordinate;
    private Direction direction;
    private final Board board;


    public Robot(Coordinate coordinate, Board board) {
        this.coordinate = coordinate;
        this.board = board;
    }


    public boolean turnRight(){
        this.direction = this.direction.getRight();
        System.out.println("RIGHT");
        return true;
    }

    public boolean turnLeft(){
        this.direction = this.direction.getLeft();
        System.out.println("LEFT");
        return true;
    }


    public Coordinate move(){

        Coordinate coordinateTemp = new Coordinate(this.coordinate.getX(),this.coordinate.getY());

        switch (this.direction) {
            case NORTH:
                coordinateTemp.setY(coordinateTemp.getY()+1);
                if(moveDecision(coordinateTemp))
                    this.coordinate.setY(this.coordinate.getY()+1);
                break;
            case EAST:
                coordinateTemp.setX(coordinateTemp.getX()+1);
                if(moveDecision(coordinateTemp))
                    this.coordinate.setX(this.coordinate.getX()+1);
                break;
            case SOUTH:
                coordinateTemp.setY(coordinateTemp.getY()-1);
                if(moveDecision(coordinateTemp))
                    this.coordinate.setY(this.coordinate.getY()-1);
                break;
            case WEST:
                coordinateTemp.setX(coordinateTemp.getX()-1);
                if(moveDecision(coordinateTemp))
                    this.coordinate.setX(this.coordinate.getX()-1);
                break;
        }
        return this.coordinate;
    }


    private boolean moveDecision(Coordinate coordinateTemp){
        if(!this.board.isValidCoordinate(coordinateTemp))
            return false;

        System.out.println("MOVE");
        return true;
    }

    public String report() {
        System.out.println("REPORT");
        return "    Output:"+this.coordinate.getX() + "," + this.coordinate.getY() + "," + this.direction.toString();
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public Board getBoard() {
        return board;
    }
}

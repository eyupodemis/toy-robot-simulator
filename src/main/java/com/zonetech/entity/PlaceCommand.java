package com.zonetech.entity;

public class PlaceCommand extends Command{

    private final Coordinate coordinate;
    private final Direction direction;

    public PlaceCommand(Coordinate coordinate, Direction direction) {
        super(CommandType.PLACE);
        this.coordinate = coordinate;
        this.direction = direction;
    }

    @Override
    public void applyCommand(Robot robot) {

        robot.setCoordinate(this.coordinate);
        robot.setDirection(this.direction);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Direction getDirection() {
        return direction;
    }
}

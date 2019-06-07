package com.zonetech.entity;

public enum Direction {
    EAST("NORTH", "SOUTH"),
    WEST("SOUTH", "NORTH"),
    NORTH("WEST", "EAST"),
    SOUTH("EAST", "WEST");

    private final String left;
    private final String right;

    Direction(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public Direction getLeft() {
        return Direction.valueOf(left);
    }

    public Direction getRight() {
        return Direction.valueOf(right);
    }
}

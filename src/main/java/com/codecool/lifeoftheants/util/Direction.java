package com.codecool.lifeoftheants.util;

public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    public static Direction getRandomDirection(){
        double random=Math.random();

        if (random<0.25)
            return Direction.NORTH;
        else if (random<0.5)
            return Direction.SOUTH;
        else if (random<0.75)
            return Direction.EAST;
        else if (random<1)
            return Direction.WEST;
        return null;
    }

}

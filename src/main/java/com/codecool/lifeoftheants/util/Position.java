package com.codecool.lifeoftheants.util;

public class Position {
    private final int x;
    private final int y;


    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Position))
            return false;

        Position other=(Position) o;

        return ((x==other.getX()) && (y==other.getY()));
    }

    public static Position getRandomPosition(int width, int height){

        return new Position((int)(Math.random()*(width)),(int)(Math.random()*(height)));

    }


}

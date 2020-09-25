package com.codecool.lifeoftheants.model;

import com.codecool.lifeoftheants.AntColony;
import com.codecool.lifeoftheants.util.Direction;
import com.codecool.lifeoftheants.util.Position;

public abstract class Ant {
    protected Position position;
    private char identifier;
    protected AntColony colony;

    public Position getPosition() {
        return position;
    }

    public char getIdentifier() {
        return identifier;
    }

    public Ant(Position position, char identifier, AntColony colony) {
        this.position = position;
        this.identifier = identifier;
        this.colony = colony;
    }

    public abstract void move();

    public void changePosition(Direction direction){
        int xDir=0, yDir=0;
        switch (direction){
            case NORTH: yDir=-1;break;
            case SOUTH: yDir=1;break;
            case EAST: xDir=1;break;
            case WEST: xDir=-1;break;
        }
        Position newPosition=new Position(position.getX()+xDir,position.getY()+yDir);

        if (colony.isValid(newPosition))
            this.position=newPosition;

    }

}

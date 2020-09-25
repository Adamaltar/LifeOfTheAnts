package com.codecool.lifeoftheants.model;

import com.codecool.lifeoftheants.AntColony;
import com.codecool.lifeoftheants.util.Direction;
import com.codecool.lifeoftheants.util.Position;

public class Drone extends Ant {
    int counter = 0;

    public Drone(Position position, char identifier, AntColony colony) {
        super(position, identifier, colony);
    }

    @Override
    public void move() {

        if (counter > 0) {
            counter--;
            if (counter == 0)
                kickAway();
            return;
        }

        Direction directionToMove = null;


        if (getPosition().getX() < colony.getQueen().getPosition().getX())
            directionToMove = Direction.EAST;
        else if (getPosition().getX() > colony.getQueen().getPosition().getX())
            directionToMove = Direction.WEST;
        else if (getPosition().getY() < colony.getQueen().getPosition().getY())
            directionToMove = Direction.SOUTH;
        else if (getPosition().getY() > colony.getQueen().getPosition().getY())
            directionToMove = Direction.NORTH;

        changePosition(directionToMove);



        if (getPosition().equals(colony.getQueen().getPosition())) {

            if (colony.getQueen().isInMood()) {
                //System.out.println("mating");
                colony.getQueen().mate();
                counter = 10;
            } else {
                kickAway();
                //System.out.println("mater kicked away");
            }
        }
    }

    private void kickAway() {
        int kickonX = (int) ((Math.random() * (colony.getWidth() / 2)));
        int kickonY = colony.getWidth() / 2 - kickonX;
        int xMultiplier = (Math.random() < 0.5) ? 1 : -1;
        int yMultiplier = (Math.random() < 0.5) ? 1 : -1;

//        System.out.println(getPosition().getX());
//        System.out.println(getPosition().getY());
//        System.out.println("x:"+kickonX);
//        System.out.println("y:"+kickonY);

        Position newPosition = new Position(position.getX() + xMultiplier * kickonX, position.getY() + yMultiplier * kickonY);

        while (!colony.isValid(newPosition)) {
            kickonX = (int) ((Math.random() * (colony.getWidth() / 2)));
            kickonY = colony.getWidth() / 2 - kickonX;
            xMultiplier = (Math.random() < 0.5) ? 1 : -1;
            yMultiplier = (Math.random() < 0.5) ? 1 : -1;
            newPosition = new Position(position.getX() + xMultiplier * kickonX, position.getY() + yMultiplier * kickonY);
        }
        position = newPosition;

    }
}



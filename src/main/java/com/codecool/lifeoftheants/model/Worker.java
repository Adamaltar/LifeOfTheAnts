package com.codecool.lifeoftheants.model;

import com.codecool.lifeoftheants.AntColony;
import com.codecool.lifeoftheants.util.Direction;
import com.codecool.lifeoftheants.util.Position;

public class Worker extends Ant {


    public Worker(Position position, char identifier, AntColony colony) {
        super(position, identifier, colony);
    }

    @Override
    public void move(){
        changePosition(Direction.getRandomDirection());
    }

}

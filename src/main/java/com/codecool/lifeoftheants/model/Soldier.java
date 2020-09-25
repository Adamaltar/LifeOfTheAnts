package com.codecool.lifeoftheants.model;

import com.codecool.lifeoftheants.AntColony;
import com.codecool.lifeoftheants.util.Direction;
import com.codecool.lifeoftheants.util.Position;

public class Soldier extends Ant {

    int i=0;

    public Soldier(Position position, char identifier, AntColony colony) {
        super(position, identifier, colony);
    }

    @Override
    public void move(){
        int n=i%4;
        switch (n){
            case 0: changePosition(Direction.WEST);break;
            case 1: changePosition(Direction.SOUTH);break;
            case 2: changePosition(Direction.EAST);break;
            case 3: changePosition(Direction.NORTH);break;
        }
        i++;

    }


}

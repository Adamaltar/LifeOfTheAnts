package com.codecool.lifeoftheants.model;

import com.codecool.lifeoftheants.AntColony;
import com.codecool.lifeoftheants.util.Position;

public class Queen extends Ant {

    int counter=0;


    public Queen(Position position, char identifier, AntColony colony) {
        super(position, identifier, colony);
    }

    @Override
    public void move(){
        if (counter>0)
            counter--;
    }


    public void mate(){
        counter=(int)((Math.random()*51+50));
    }

    public boolean isInMood(){
        return counter==0;
    }

}

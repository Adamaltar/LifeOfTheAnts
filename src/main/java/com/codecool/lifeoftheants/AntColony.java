package com.codecool.lifeoftheants;

import com.codecool.lifeoftheants.model.*;
import com.codecool.lifeoftheants.util.Position;

import java.util.ArrayList;
import java.util.List;



public class AntColony {
    public static final int NUMBEROFDRONES=5;
    public static final int NUMBEROFWORKERS=5;
    public static final int NUMBEROFSOLDIERS=5;

    List<Ant> ants=new ArrayList<>();
    int width;
    Queen queen;


    public AntColony(int width) {
        this.width = width;
        this.queen=new Queen(new Position(width/2,width/2),'Q',this);
        generateAnts(NUMBEROFDRONES,NUMBEROFWORKERS,NUMBEROFSOLDIERS);

    }

    private void generateAnts(int drones, int workers, int soldiers) {
        for (int i=0;i<drones;i++)
            ants.add(new Drone(Position.getRandomPosition(getWidth(),getWidth()),'D',this));
        for (int i=0;i<workers;i++)
            ants.add(new Worker(Position.getRandomPosition(getWidth(),getWidth()),'W',this));
        for (int i=0;i<soldiers;i++)
            ants.add(new Soldier(Position.getRandomPosition(getWidth(),getWidth()),'S',this));
    }

    public boolean isValid(Position newPosition) {
        return ((0<=newPosition.getX())&&(newPosition.getX()<getWidth())&&(0<=newPosition.getY())&&(newPosition.getY()<getWidth()));

    }

    public void update(){
        queen.move();
        for (Ant ant:ants)
            ant.move();
    }

    public void display() {
        char[][] board = new char[width][width];

        for (Ant ant : ants)
            board[ant.getPosition().getY()][ant.getPosition().getX()] = ant.getIdentifier();
        board[getQueen().getPosition().getY()][getQueen().getPosition().getX()] = getQueen().getIdentifier();

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print("----");
                }
                System.out.println("-");
                for (int j = 0; j < width; j++) {
                    System.out.print("| "+board[i][j]+" ");
                }
                System.out.println("|");
            }
            for (int j = 0; j < width; j++) {
                System.out.print("----");
            }
            System.out.println("-");
        }





    public int getWidth() {
        return this.width;
    }

    public Queen getQueen() {
        return queen;
    }

    public static void main(String[] args){
        AntColony a=new AntColony(10);
        a.display();
        for (int i = 0; i < 30; i++) {
            a.update();
            System.out.println();
            a.display();

        }

    }



}

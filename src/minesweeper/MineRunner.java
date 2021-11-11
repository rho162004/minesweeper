package minesweeper;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Scanner;

public class MineRunner {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        int x;
        System.out.println("HELLO. Welcome to minesweeper! How many mines would you like? (This determines difficulty of the game," +
                " and more mines mean it's harder.");
        x = reader.nextInt ();
        System.out.println("Okay, "+x+" mines are being generated... how big would you like the grid to be? (It will be a square " +
                "so just enter one number please)");
        int y;
        y=reader.nextInt();
        Grid<Actor> grid = new BoundedGrid<Actor>(y, y);
        MineWorld w = new MineWorld(grid, x);
        ArrayList<Location> occupied = new ArrayList<Location>();
        MineWorld.numCells=y*y-x;
        // change this later to fit any grid, but for now it's just a 10x10

        for (int r = 0; r<y; r++) {
            for (int c=0; c<y;c++) {
                w.add(new Location (r,c), new Cell());
            }
        }
        for (int i = 0; i<x; i++) {
            Location loc = new Location ((int)(Math.random()*y), (int)(Math.random()*y));
            w.remove(loc);
            w.add(loc, new Mine());
            w.show();
            occupied.add(loc);
        }
        //   Extension: Ask user how many mines they want and how big of a grid they want
    }
}

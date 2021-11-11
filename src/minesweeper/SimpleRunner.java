package minesweeper;

import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class SimpleRunner {

    //extension is in MineRunner
    public static void main(String[] args) {
        Grid<Actor> grid = new BoundedGrid<Actor>(7, 7);
        MineWorld world = new MineWorld(grid, 4);

        world.add(new Location(1, 1), new Mine());
        world.add(new Location(1, 2), new Mine());
        world.add(new Location(2, 2), new Mine());
        world.add(new Location(3, 3), new Mine());

        for (int i=0; i<45; i++) {
            world.add(new Cell());
        }

        world.show();
    }
}
package minesweeper;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class MineWorld extends ActorWorld {
    public static boolean gameOver;
    public static int numCells;

    public MineWorld(Grid<Actor> grid,int numMines) {
        super(grid);
        numCells=grid.getNumCols()*grid.getNumRows()-numMines;
        System.out.println(""+numCells+"   "+numMines);
        this.setMessage("Welcome to Minesweeper!");
    }

    public boolean locationClicked (Location loc ) {
        Grid<Actor>gr = this.getGrid();
        Actor a = gr.get(loc);
        if (numCells<=0) {
            this.setMessage("Congrats! You won!");
            return true;
        }
        else if (a instanceof Cell) {
            numCells--;
            Cell c = (Cell) a;
            if (c.isHidden()) {
                c.setHidden(false);
                ArrayList<Location> lst;
                lst=gr.getOccupiedAdjacentLocations(loc);
                for (int i=0; i<lst.size(); i++) {
                    Actor b = gr.get(lst.get(i));
                    if (b instanceof Cell) {
                        lst.remove(i);
                        i--;
                    }
                }
                c.setState(lst.size());
                //recursive
                if (c.getState()==0) {
                    ArrayList<Location> neigh;
                    neigh = gr.getOccupiedAdjacentLocations(loc);
                    //cycle through neighbors and click on them IF they're hidden
                    for (int i = 0; i<neigh.size(); i++) {
                        Actor hello = gr.get(neigh.get(i));
                        Cell z = (Cell) hello;
                        if (z.isHidden()) {
                            locationClicked(neigh.get(i));
                        }
                    }
                }
                //state is number of neighbors
                this.setMessage("You clicked: "+ loc);
                return true;
            } else {
                //cell is already revealed
                this.setMessage("You clicked: " + loc);
                return true;
            }
        } else {
            //mine has been clicked
            gameOver=true;
            this.setMessage("Game Over!");
            return true;
        }
    }
}

package minesweeper;

import info.gridworld.actor.Actor;

public class Mine extends Actor {
    //no instance variables
    public Mine () {
        setColor(null);
    }

    public String getImageSuffix () {
        if (MineWorld.gameOver) {
            return "-show";
        } else {
            return "-hide";
        }
    }

    public String toString () {
        return "";
    }
}

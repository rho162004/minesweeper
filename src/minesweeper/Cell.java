package minesweeper;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;

public class Cell extends Actor {
    private int state;
    private boolean hidden;

    public Cell() {
        state=-1;
        setColor(null);
        hidden=true;
    }

    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }

    public boolean isHidden() {
        return hidden;
    }
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String toString() {
        return "";
    }

    public String getImageSuffix() {

        if (isHidden()) {
            return "";
        } else {
            return "-" + getState();
        }
    }


}

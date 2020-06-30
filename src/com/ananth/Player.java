package com.ananth;

public class Player {
    private boolean whiteSide;
    private boolean humanPlayer;

    public boolean isWhiteSide() {
        return whiteSide;
    }

    public boolean isHumanPlayer() {
        return humanPlayer;
    }

    public void setWhiteSide(boolean whiteSide) {
        this.whiteSide = whiteSide;
    }

    public void setHumanPlayer(boolean humanPlayer) {
        this.humanPlayer = humanPlayer;
    }
}

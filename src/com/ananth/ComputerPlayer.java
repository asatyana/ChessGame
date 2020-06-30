package com.ananth;

public class ComputerPlayer extends Player{
    public ComputerPlayer(boolean whiteSide) {
        this.setHumanPlayer(false);
        this.setWhiteSide(whiteSide);
    }
}

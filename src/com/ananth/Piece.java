package com.ananth;

/**
 * Types of Pieces
 * King - can move one square
 * Queen - can move any number of squares
 * Knight - can move any number of squares horizontal or vertical
 * Pawns - can move vertically one square and one square diagonally if it is occupied
 * Rooks - can move any number of squares diagonally
 * Bishops - can move 3 squares in L shape
 */

public abstract class Piece {
    private boolean isWhite = false;
    private boolean killed = false;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public abstract boolean canMove(Board board, Spot x, Spot y);
}

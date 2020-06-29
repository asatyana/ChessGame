package com.ananth;

/**
 *  Spot: A spot represents one block of the 8×8 grid and an optional piece.
 */

public class Spot {
    private Piece piece;
    private int x;
    private int y;

    /**
     *
     * @param piece
     * @param x
     * @param y
     */
    public Spot(int x, int y, Piece piece) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

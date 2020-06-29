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
    public Spot(int x, int y, Piece piece) throws Exception{
        // Check if they are with-in bounds
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Index Out of Bounds");
        }
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

    public void setX(int x) throws Exception{
        // Check if they are with-in bounds
        if (x < 0 || x > 7) {
            throw new Exception("Index Out of Bounds");
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) throws Exception{
        // Check if they are with-in bounds
        if (y < 0 || y > 7) {
            throw new Exception("Index Out of Bounds");
        }
        this.y = y;
    }
}

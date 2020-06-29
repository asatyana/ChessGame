package com.ananth;

public class Rook extends Piece {
    private boolean isWhite = false;

    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot x, Spot y) {
        return false;
    }
}

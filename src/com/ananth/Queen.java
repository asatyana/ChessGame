package com.ananth;

public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot x, Spot y) {
        return false;
    }
}

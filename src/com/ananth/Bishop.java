package com.ananth;

public class Bishop extends Piece{
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot x, Spot y) {
        return false;
    }


}

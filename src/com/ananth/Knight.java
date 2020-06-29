package com.ananth;

public class Knight extends Piece{

    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot x, Spot y) {
        return false;
    }

}

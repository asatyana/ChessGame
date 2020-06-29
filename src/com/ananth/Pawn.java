package com.ananth;

public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot x, Spot y) {
        return false;
    }


}

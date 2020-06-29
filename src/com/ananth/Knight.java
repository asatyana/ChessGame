package com.ananth;

public class Knight extends Piece{

    public Knight(boolean isWhite) {
        super(isWhite);
    }


    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        // Same color Piece, can't move
        if ((end.getPiece() != null) && (end.getPiece().isWhite() == this.isWhite())) {
            return false;
        }

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        return (x*y == 2);
    }
}

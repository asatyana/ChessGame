package com.ananth;

public class King extends Piece {
    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        // Can't move if the source and the destination Spots have same colour Pieces
        if ((end.getPiece() != null) && (end.getPiece().isWhite() == this.isWhite())) {
            return false;
        }

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        if (x + y == 1) {
            //Valid move if king is not being attacked
            return true;
        }
        return false;
    }
}

package com.ananth;

public class Bishop extends Piece{
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) throws Exception{
        // Same color Piece, can't move
        if ((end.getPiece() != null) && (end.getPiece().isWhite() == this.isWhite())) {
            return false;
        }

        // Check for obstructions

        // How many boxes to check?
        int noBoxesToCheck = Math.abs(start.getX() - end.getX());

        // We are not checking for the status of end box. We are here if the end box is either empty
        // or it has opposite color Piece.
        for (int i = 1; i < noBoxesToCheck; i++) {
            int x, y;

            // Calculate diagonal box co-ordinates
            if (end.getX() > start.getX())
                x = end.getX() - i;
            else
                x = end.getX() + i;
            if (end.getY() > start.getY())
                y = end.getY() - i;
            else
                y = end.getY() + i;

            // Check if the box is empty
            if (board.getBox(x, y).getPiece() != null) {
                return false;
            }
        }
        return true;
    }


}

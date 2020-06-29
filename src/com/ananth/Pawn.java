package com.ananth;

public class Pawn extends Piece {
    private boolean atHome = true;

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        // Can't move if the source and the destination Spots have same colour Pieces
        if ((end.getPiece() != null) && (end.getPiece().isWhite() == this.isWhite())) {
            return false;
        }

        // First move can be 2 spots
        if (atHome && (end.getY() - start.getY()) == 2) {
            return true;
        } else if (Math.abs(start.getX() - end.getX()) * Math.abs(start.getY() - end.getY()) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void setAtHome(boolean atHome) {
        this.atHome = atHome;
    }
}

package com.ananth;

public class Rook extends Piece {
    private boolean isWhite = false;

    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) throws Exception{

        // Can't move if the source and the destination Spots have same colour Pieces
        if ((end.getPiece() != null) && (end.getPiece().isWhite() == this.isWhite())) {
            return false;
        }

        boolean moveHorizontal = start.getY() - end.getY() == 0 ? true : false;
        boolean ltr = start.getX() < end.getX() ? true : false; // Move left to right
        boolean btt = start.getY() < end.getY() ? true : false; // Move bottom to top
        int distance = moveHorizontal ? Math.abs(start.getX() - end.getX()) : Math.abs(start.getY() - end.getY());

        // Starting with index 1 so that we leave out the end box.
        // check for horizontal/vertical move
        if (start.getX() == end.getX() || start.getY() == end.getY()) {
            for (int i = 1; i < distance; i++) {
                if (moveHorizontal) {
                    if (ltr) {
                        if (board.getBox(start.getX() + i, start.getY()) != null) {
                            // encountered block
                            return false;
                        }
                    } else {
                        if (board.getBox(start.getX() - i, start.getY()) != null) {
                            // encountered block
                            return false;
                        }
                    }
                } else {
                    if (btt) {
                        if (board.getBox(start.getX(), start.getY() + i) != null) {
                            // encountered block
                            return false;
                        }
                    } else {
                        if (board.getBox(start.getX(), start.getY() - i) != null) {
                            // encountered block
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }
}

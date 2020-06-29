package com.ananth;

public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) throws Exception {
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
        } else {
            // Check for diagonal moves
            int noBoxesToCheck = Math.abs(start.getX() - end.getX());
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
        }
        return true;
    }
}

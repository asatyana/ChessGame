package com.ananth;

import java.lang.Exception;

public class Board {
    private Spot[][] boxes;

    public Board() {
        resetBoard();
    }

    public Spot getBox(int x, int y) throws Exception {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Index Out of Bounds");
        } else {
            return boxes[x][y];
        }
    }

    private void resetBoard() {
        // Initialize white pieces
        boxes[0][0] = new Spot(0, 0, new Rook(true));
        boxes[0][1] = new Spot(0, 1, new Knight(true));
        boxes[0][2] = new Spot(0, 2, new Bishop(true));
        boxes[0][3] = new Spot(0, 3, new Queen(true));
        boxes[0][4] = new Spot(0, 4, new King(true));
        boxes[0][5] = new Spot(0, 5, new Bishop(true));
        boxes[0][6] = new Spot(0, 6, new Knight(true));
        boxes[0][7] = new Spot(0, 7, new Rook(true));

        boxes[1][0] = new Spot(0, 0, new Pawn(true));
        boxes[1][1] = new Spot(0, 0, new Pawn(true));
        boxes[1][2] = new Spot(0, 0, new Pawn(true));
        boxes[1][3] = new Spot(0, 0, new Pawn(true));
        boxes[1][4] = new Spot(0, 0, new Pawn(true));
        boxes[1][5] = new Spot(0, 0, new Pawn(true));
        boxes[1][6] = new Spot(0, 0, new Pawn(true));
        boxes[1][7] = new Spot(0, 0, new Pawn(true));

        // Initialize Black Pieces
        boxes[7][0] = new Spot(7, 0, new Rook(true));
        boxes[7][1] = new Spot(7, 1, new Knight(true));
        boxes[7][2] = new Spot(7, 2, new Bishop(true));
        boxes[7][3] = new Spot(7, 3, new Queen(true));
        boxes[7][4] = new Spot(7, 4, new King(true));
        boxes[7][5] = new Spot(7, 5, new Bishop(true));
        boxes[7][6] = new Spot(7, 6, new Knight(true));
        boxes[7][7] = new Spot(7, 7, new Rook(true));

        boxes[6][0] = new Spot(0, 0, new Pawn(true));
        boxes[6][1] = new Spot(0, 0, new Pawn(true));
        boxes[6][2] = new Spot(0, 0, new Pawn(true));
        boxes[6][3] = new Spot(0, 0, new Pawn(true));
        boxes[6][4] = new Spot(0, 0, new Pawn(true));
        boxes[6][5] = new Spot(0, 0, new Pawn(true));
        boxes[6][6] = new Spot(0, 0, new Pawn(true));
        boxes[6][7] = new Spot(0, 0, new Pawn(true));

        // Initialize rest of the boxes without any piece
        for (int i = 2; i <6; i++) {
            for (int j = 0; j < 8;j++) {
                boxes[i][j] = new Spot(i, j, null);
            }
        }


    }
}

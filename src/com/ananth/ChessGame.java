package com.ananth;

import java.util.List;

public class ChessGame {

    /**
     * The main classes will be:
     *
     * Spot: A spot represents one block of the 8×8 grid and an optional piece.
     * Piece: The basic building block of the system, every piece will be placed on a spot. Piece class is an abstract class. The extended classes (Pawn, King, Queen, Rook, Knight, Bishop) implements the abstracted operations.
     * Board: Board is an 8×8 set of boxes containing all active chess pieces.
     * Player: Player class represents one of the participants playing the game.
     * Move: Represents a game move, containing the starting and ending spot. The Move class will also keep track of the player who made the move.
     * ChessGame: This class controls the flow of a game. It keeps track of all the game moves, which player has the current turn, and the final result of the game.
     */

    public enum GameStatus {
        ACTIVE,
        BLACK_WIN,
        WHITE_WIN,
        FORFEIT,
        STALEMATE,
        RESIGNATION,
        INVALID
    }

    private Player [] players;
    private Board board;
    private Player currentTurn;
    private GameStatus status;
    private List<Move> movesPlayed;

    /**
     * Initialize the game
     * @param p1 - Player 1
     * @param p2 - Player 2
     */
    private void init(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;

        try {
            board.resetBoard();
        } catch (Exception e) {
            status = GameStatus.INVALID;
            e.printStackTrace();
        }

        movesPlayed.clear();
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public boolean movePiece(Player player, int startX, int startY, int endX, int endY) throws Exception{
        Spot startBox = board.getBox(startX, startY);
        Spot endBox = board.getBox(endX, endY);
        Move move = new Move(player, startBox, endBox);
        return makeMove(move, player);
    }

    private boolean makeMove(Move move, Player player) throws Exception{
        // Source piece should not be null
        if (move.getStart().getPiece() == null) {
            return false;
        }

        // Is valid player?
        if (player != currentTurn) {
            return false;
        }

        // Moving right color Piece
        if (player.isWhiteSide() != move.getStart().getPiece().isWhite()) {
            return false;
        }

        // Valid move?
        if (!move.getStart().getPiece().canMove(board, move.getStart(), move.getEnd())) {
            return false;
        }

        // Kill?
        Piece destPiece = move.getEnd().getPiece();
        if (destPiece != null) {
            destPiece.setKilled(true);
            move.setPiecekilled(destPiece);
        }

        // Save the move
        movesPlayed.add(move);

        // All set to execute move
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);

        // Game over?
        if (destPiece instanceof King) {
            if (player.isWhiteSide()) {
                setStatus(GameStatus.WHITE_WIN);
            } else {
                setStatus(GameStatus.BLACK_WIN);
            }
        }

        // Switch player turn
        if (currentTurn == players[0]) {
            currentTurn = players[1];
        } else {
            currentTurn = players[0];
        }
        return true;
    }

    public static void main(String[] args) {
	// write your code here
    }
}

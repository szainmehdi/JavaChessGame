package course.rcc.cis18b.chess.Behaviors;

import course.rcc.cis18b.chess.Entities.Board;
import course.rcc.cis18b.chess.Entities.Piece;

public class RookMoveBehavior implements MoveBehavior {
    /**
     * Determine whether a move is legal according to the rules of each game.
     *
     * @param piece
     * @param row
     * @param column
     * @return
     */
    @Override
    public boolean isValidMove(Piece piece, int row, int column) {
        Board board = Board.getInstance();
        if(board.spaceExists(row, column)) {

            float rowDifference = Math.abs(row - piece.getRow());
            float columnDifference = Math.abs(column - piece.getColumn());

            // Only the rowDifference or columnDifference can be >0 at one time
            // for the move to be valid.
            return ((rowDifference == 0 && columnDifference >0) || (rowDifference >0 && columnDifference == 0));

        } else {
            return false;
        }
    }
}

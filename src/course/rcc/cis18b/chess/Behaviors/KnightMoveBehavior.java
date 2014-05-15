package course.rcc.cis18b.chess.Behaviors;

import course.rcc.cis18b.chess.Entities.Board;
import course.rcc.cis18b.chess.Entities.Piece;

public class KnightMoveBehavior implements MoveBehavior {
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

            if (rowDifference <= 1 && columnDifference <=1) {
                // A knight cannot move into any piece it is adjacent to.
                return false;
            } else if (rowDifference == 0 && columnDifference > 0)  {
                // A knight cannot move directly left or right.
                return false;
            } else if (columnDifference == 0 && rowDifference > 0) {
                // A knight cannot move directly up or down
                return false;
            } else if (columnDifference == rowDifference) {
                // A knight cannot move directly diagonal.
                return false;
            } else if(rowDifference > 2 || columnDifference > 2) {
                // A knight cannot move into a piece that is greater than two spaces away.
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}

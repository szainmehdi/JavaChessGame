package course.rcc.cis18b.chess.Behaviors;


import course.rcc.cis18b.chess.Entities.Board;
import course.rcc.cis18b.chess.Entities.Piece;

public class PawnMoveBehavior implements MoveBehavior {

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
            return true;
        } else {
            return false;
        }
    }
}

package course.rcc.cis18b.chess.Behaviors;

import course.rcc.cis18b.chess.Entities.Piece;

public interface MoveBehavior {

    /**
     * Determine whether a move is legal according to the rules of each game.
     * @param piece
     * @param row
     * @param column
     * @return
     */
    public boolean isValidMove(Piece piece, int row, int column);

}

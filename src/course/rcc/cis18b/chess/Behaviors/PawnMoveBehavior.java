package course.rcc.cis18b.chess.Behaviors;


import course.rcc.cis18b.chess.Entities.Board;
import course.rcc.cis18b.chess.Entities.Piece;
import course.rcc.cis18b.chess.Entities.PlayerTeam;



public class PawnMoveBehavior implements MoveBehavior {

    /**
     * Determine whether a move is legal according to the rules of each game.
     *
     * @param piece
     * @param desiredRow
     * @param desiredColumn
     * @return
     */
    @Override
    public boolean isValidMove(Piece piece, int desiredRow, int desiredColumn) {

        // Let's make sure that this pawn cannot move backwards or sideways
        // and can only move up one or two spaces.

        Board board = Board.getInstance();
        if(board.spaceExists(desiredRow, desiredColumn)) {

            // The piece's current location.
            int currentRow = piece.getRow();
            int currentColumn = piece.getColumn();

            PlayerTeam team = piece.getPlayer().getTeam();

            int rowDifference;
            int columnDifference = desiredColumn - currentColumn;

            switch(team) {
                case BLACK:
                    // The change in location (Delta).
                    rowDifference = desiredRow - currentRow;
                    break;
                case WHITE:
                    // The change in location (Delta).
                    rowDifference = currentRow - desiredRow;
                    break;
                default:
                    rowDifference = 0;
            }
            // Row difference should be positive if the move is valid
            // Row difference should be less than two if the move is valid.
            // Column difference should be zero if the move is valid.
            return ((rowDifference > 0 && rowDifference <=2) && columnDifference == 0);
        } else {
            return false;
        }
    }
}

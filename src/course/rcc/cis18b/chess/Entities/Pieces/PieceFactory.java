package course.rcc.cis18b.chess.Entities.Pieces;

public abstract class PieceFactory
{
    /**
     * Create a piece using PieceType.
     * @param type
     * @return a newly minted Piece.
     */
    public static Piece make(PieceType type)
    {
        Piece piece;

        switch(type)
        {
            case KING:
                piece = new King();
                break;
            case QUEEN:
                piece = new Queen();
                break;
            case ROOK:
                piece = new Rook();
                break;
            case KNIGHT:
                piece = new Knight();
                break;
            case BISHOP:
                piece = new Bishop();
                break;
            case PAWN:
                piece = new Pawn();
                break;
            default:
                throw new IllegalArgumentException(type.toString() + " is not a valid type.");
        }
        return piece;
    }
}

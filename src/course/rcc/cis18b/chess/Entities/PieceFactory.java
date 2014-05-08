package course.rcc.cis18b.chess.Entities;

import course.rcc.cis18b.chess.Behaviors.*;

public class PieceFactory
{
    public static Piece make(PieceType type)
    {
        MoveBehavior moveBehavior;

        switch(type)
        {
            case KING:
                moveBehavior = new PawnMoveBehavior();
                break;
            case QUEEN:
                moveBehavior = new PawnMoveBehavior();
                break;
            case ROOK:
                moveBehavior = new PawnMoveBehavior();
                break;
            case KNIGHT:
                moveBehavior = new PawnMoveBehavior();
                break;
            case BISHOP:
                moveBehavior = new PawnMoveBehavior();
                break;
            case PAWN:
                moveBehavior = new PawnMoveBehavior();
                break;
            default:
                moveBehavior = new PawnMoveBehavior();
        }
        return new Piece(moveBehavior);
    }
}

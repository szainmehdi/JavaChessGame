package course.rcc.cis18b.chess.Entities;

import course.rcc.cis18b.chess.Behaviors.*;
import course.rcc.cis18b.chess.Exceptions.InvalidMoveException;

public class PieceFactory
{
    public static Piece make(Player player, PieceType type)
    {
        MoveBehavior moveBehavior = getMoveBehavior(type);
        String model = getModel(type);
        
        return new Piece(player, model, moveBehavior, type);
    }

    public static Piece make(Player player, PieceType type, int row, int column) throws InvalidMoveException
    {
        MoveBehavior moveBehavior = getMoveBehavior(type);
        String model = getModel(type);
        return new Piece(player, model, moveBehavior, row, column, type);
    }
    
    private static MoveBehavior getMoveBehavior(PieceType type) {
        switch(type)
        {
            case KING: return new PawnMoveBehavior();
            case QUEEN: return new PawnMoveBehavior();
            case ROOK: return new PawnMoveBehavior();
            case KNIGHT: return new PawnMoveBehavior();
            case BISHOP: return new PawnMoveBehavior();
            case PAWN: return new PawnMoveBehavior();
                
            default:
                return new PawnMoveBehavior();
        }
    }
    
    private static String getModel(PieceType type) {
        switch(type)
        {
            case KING: return "";
            case QUEEN: return "";
            case ROOK: return "";
            case KNIGHT: return "";
            case BISHOP: return "";
            case PAWN: return "";

            default:
                return "";
        }
    }
}

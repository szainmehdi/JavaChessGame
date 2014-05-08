package course.rcc.cis18b.chess.Entities;

import com.sun.istack.internal.Nullable;
import course.rcc.cis18b.chess.Exceptions.InvalidMoveException;
import course.rcc.cis18b.chess.Entities.Pieces.Piece;

public class Space
{
    /**
     * The game-piece that this space holds.
     */
    public Piece piece = null;

    public Space() {

    }

    public Space(Piece piece) {
        try {
            this.push(piece);
        } catch (IllegalArgumentException e) {
            //Do error catching here.
        } catch (InvalidMoveException e) {
            //Do error catching here.
        }
    }

    /**
     * Check if the space is currently holding any piece.
     * @return true or false
     */
    public boolean isEmpty()
    {
        return (piece==null);
    }

    /**
     * Place a piece in the space.
     * @param piece
     * @throws InvalidMoveException
     * @throws IllegalArgumentException
     */
    public void push(Piece piece)
            throws InvalidMoveException, IllegalArgumentException
    {
        if(!this.isEmpty()) {
            throw new InvalidMoveException("The space already contains a piece.");
        } else if(piece == null) {
            throw new IllegalArgumentException("The piece provided is invalid.");
        }

        this.piece = piece;
    }

    /**
     * Get the piece associated with the space.
     * @return Current piece in space
     */
    public Piece getPiece()
    {
        return this.piece;
    }

    /**
     * Clear the space of any piece.
     */
    public void clear()
    {
        this.piece = null;
    }

    /**
     * Grab the current piece in the space and remove it from the space.
     * @return Piece|null
     */
    @Nullable
    public Piece pop()
    {
        Piece p = this.getPiece();
        this.clear();

        return p;
    }


}

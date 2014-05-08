package course.rcc.cis18b.chess.Entities;

public class Board
{
    /**
     * Use a standard 2-D array of Spaces to account for each
     * space on the board. A regular chess board spans
     * 8 spaces both horizontally and vertically,
     * for a total of 64 spaces.
     */
    public Space[][] spaces = new Space[8][8];

    public Board()
    {

    }

}


/*
package course.rcc.cis18b.chess;

import java.util.ArrayList;
import java.util.Scanner;

public class Board
{
    public ArrayList<Space> spaces = new ArrayList<Space>();

    int xCoordinate = 0;
    int yCoordinate = 0;
    int pieceSymbol = 0;

    Piece piece = new Piece();
    Scanner keyboard = new Scanner(System.in);

    public Board()
    {
        xCoordinate = 2;
        yCoordinate = 3;
        piece.SetPosition(xCoordinate, yCoordinate);

        piece.PrintPosition();
    }

    public void PrintBoard()
    {
        InvertSymbolPosition(piece.yCoordinate);

        for(int i = 0; i < 8; i++) {
            System.out.print("\n");
            for (int j = 0; j < 9; j++) {
                System.out.print("|");
                if ((piece.xCoordinate - 1) == j && (piece.yCoordinate - 1) == i) {
                    System.out.print(pieceSymbol);
                }
            }
        }
    }

    public void InvertSymbolPosition(int y)
    {
        int j = 8;
        for(int i = 1; i < 8; i++)
        {
            if(y == i)
            {
                piece.yCoordinate = j;
                break;
            }
            else
                j--;
        }
    }

    public void MovePiece()
    {
        piece.Move();
    }
}
*/

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

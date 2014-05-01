package course.rcc.cis18b.chess;

import java.util.Scanner;

public class Piece
{
    int xCoordinate = 0;
    int yCoordinate = 0;

    Scanner keyboard = new Scanner(System.in);

    public Piece()
    {

    }

    public void SetPosition(int xCoordinate, int yCoordinate)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public void Move()
    {
        System.out.print("Enter new xCoordinate = ");
        xCoordinate = keyboard.nextInt();
        System.out.print("Enter new yCoordinate = ");
        yCoordinate = keyboard.nextInt();
    }

    public void GetPiece()
    {

    }

    public void AddPiece()
    {

    }

    public void PrintPosition()
    {
        System.out.println("Position = (" + xCoordinate + ", " + yCoordinate + ")");

    }
}

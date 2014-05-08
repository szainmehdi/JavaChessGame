package course.rcc.cis18b.chess;

import java.awt.Image;

public class Piece
{
    private Image image;
    private int XPosition;//Position in Pixels
    private int YPosition;

    public Piece(Image image, int xPosition, int yPosition)
    {
        this.image = image;
        this.XPosition = xPosition;
        this.YPosition = yPosition;
    }

    public Image GetImage()
    {
        return image;
    }

    public int GetXPosition()
    {
        return XPosition;
    }

    public int GetYPosition()
    {
        return YPosition;
    }

    public void SetXPosition(int XPosition)
    {
        this.XPosition = XPosition;
    }

    public void SetYPosition(int YPosition)
    {
        this.YPosition = YPosition;
    }

    public int GetWidth()
    {
        return image.getWidth(null);
    }

    public int GetHeight()
    {
        return image.getHeight(null);
    }

    /*
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
    */
}
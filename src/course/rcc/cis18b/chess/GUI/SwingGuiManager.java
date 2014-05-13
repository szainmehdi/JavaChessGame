package course.rcc.cis18b.chess.GUI;

import course.rcc.cis18b.chess.Entities.PieceType;
import course.rcc.cis18b.chess.Entities.Board;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.net.URL;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class SwingGuiManager extends JPanel implements GuiManager
{
    public static final int ROWS = 8;
    public static final int COLUMNS = 8;
    private int offset = 100;//Tile size
    private int center = 15;//Value to center pieces inside the tile
    private Image tile;
    private Image backgroundImage;
    private Image blackTile;
    private Image whiteTile;
    private Image pieceImage;
    private Image[][] grid = new Image[ROWS][COLUMNS];
    private int[][] xPositions = new int[ROWS][COLUMNS];
    private int[][] yPositions = new int[ROWS][COLUMNS];
    private int xPosition;
    private int yPosition;
    String colorPiece;


    public SwingGuiManager()
    {
        createWindow();
        createBoard();
        colorPiece = "Black";
        createPieces(colorPiece);
        colorPiece = "White";
        createPieces(colorPiece);
        render();

        Controller controller = new Controller(grid, xPositions, yPositions, this);
        addMouseListener(controller);
        addMouseMotionListener(controller);
    }

    private void createWindow()
    {
        JFrame frame = new JFrame();
        frame.setTitle("Chess Game");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        frame.setSize(1280, 840);
        frame.setLocationRelativeTo(null);
    }

    public void createBoard()
    {
        backgroundImage = getImage("WoodBackground.jpg");
        blackTile = getImage("BlackTile.jpg");
        whiteTile = getImage("WhiteTile.jpg");
    }

    private Image getImage(String filename)
    {
        String path = "../Images/";
        Image image;

        path += filename;
        URL urlImage = getClass().getResource(path);
        image = new ImageIcon(urlImage).getImage();

        return image;
    }

    private Image createPiece(PieceType type, String color)
    {
        String filename;
        filename = (color.equals("Black"))?"black":"white";

        switch(type)
        {
            case ROOK:
                filename += "rook";
                break;
            case KNIGHT:
                filename += "knight";
                break;
            case BISHOP:
                filename += "bishop";
                break;
            case QUEEN:
                filename += "queen";
                break;
            case KING:
                filename += "king";
                break;
            case PAWN:
                filename += "pawn";
                break;
        }

        filename += ".png";
        return getImage(filename);
    }

    private void createPieces(String color)
    {
        if(color.equals("Black"))
        {
            pieceImage = createPiece(PieceType.ROOK, color);
            grid[0][0] = pieceImage;
            grid[0][7] = pieceImage;
            pieceImage = createPiece(PieceType.KNIGHT, color);
            grid[0][1] = pieceImage;
            grid[0][6] = pieceImage;
            pieceImage = createPiece(PieceType.BISHOP, color);
            grid[0][2] = pieceImage;
            grid[0][5] = pieceImage;
            pieceImage = createPiece(PieceType.QUEEN, color);
            grid[0][3] = pieceImage;
            pieceImage = createPiece(PieceType.KING, color);
            grid[0][4] = pieceImage;

            pieceImage = createPiece(PieceType.PAWN, color);
            for(int j = 0; j < 8; j++ )
            {
                grid[1][j] = pieceImage;
            }
        }

        else
        {
            pieceImage = createPiece(PieceType.ROOK, color);
            grid[7][0] = pieceImage;
            grid[7][7] = pieceImage;
            pieceImage = createPiece(PieceType.KNIGHT, color);
            grid[7][1] = pieceImage;
            grid[7][6] = pieceImage;
            pieceImage = createPiece(PieceType.BISHOP, color);
            grid[7][2] = pieceImage;
            grid[7][5] = pieceImage;
            pieceImage = createPiece(PieceType.QUEEN, color);
            grid[7][3] = pieceImage;
            pieceImage = createPiece(PieceType.KING, color);
            grid[7][4] = pieceImage;

            pieceImage = createPiece(PieceType.PAWN, color);
            for (int j = 0; j < 8; j++) {
                grid[6][j] = pieceImage;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics graphics)
    {
        //Draws background image
        graphics.drawImage(backgroundImage, 0, 0, null);



        //Draws the tiles
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLUMNS; j++)
            {
                xPositions[i][j] = offset * i;
                yPositions[i][j] = offset * j;

                System.out.println("XPosition: " + xPositions[i][j]);
                System.out.println("YPosition: " + yPositions[i][j]);

                tile = ((i % 2) == (j % 2)) ? blackTile : whiteTile;
                graphics.drawImage(tile, xPositions[i][j], yPositions[i][j], null);
            }
        }

        //Draws the pieces
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLUMNS; j++)
            {
                graphics.drawImage(grid[j][i], xPositions[i][j] + center, yPositions[i][j] + center, null);
            }
        }
    }

    public void render()
    {
        System.out.println("You called me bro?");
        repaint();
    }
}









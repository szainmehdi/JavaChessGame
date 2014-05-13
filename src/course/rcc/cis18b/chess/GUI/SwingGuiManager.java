package course.rcc.cis18b.chess.GUI;

import course.rcc.cis18b.chess.Entities.Piece;
import course.rcc.cis18b.chess.Entities.Board;
import course.rcc.cis18b.chess.Entities.Space;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.net.URL;
import java.awt.Graphics;
import java.awt.Image;

public class SwingGuiManager extends JPanel implements GuiManager
{
//    public static final int ROWS = 8;
//    public static final int COLUMNS = 8;
    public static final String IMAGES_PATH = "../Images/";

    /**
     * Size of each tile.
     */
    private static final int TILE_SIZE = 100;

    /**
     * Value to offset pieces inside each tile
     */
    private static final int OFFSET = 15;

    private Image backgroundImage;
    private Image blackTile;
    private Image whiteTile;

//    private Image pieceImage;
//    private Image[][] grid = new Image[ROWS][COLUMNS];
//    private int[][] xPositions = new int[ROWS][COLUMNS];
//    private int[][] yPositions = new int[ROWS][COLUMNS];
//    private int xPosition;
//    private int yPosition;
//    String colorPiece;


    public SwingGuiManager()
    {
        createWindow();
        createBoard();
//        colorPiece = "Black";
//        createPieces(colorPiece);
//        colorPiece = "White";
//        createPieces(colorPiece);
//        render();
//
//        Controller controller = new Controller(grid, xPositions, yPositions, this);
//        addMouseListener(controller);
//        addMouseMotionListener(controller);
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
        String path = IMAGES_PATH + filename;
        URL urlImage = getClass().getResource(path);
        return new ImageIcon(urlImage).getImage();
    }

    public Image getImage(Piece piece) {
        String path = IMAGES_PATH + piece.getModel();
        URL urlImage = getClass().getResource(path);
        return new ImageIcon(urlImage).getImage();
    }

    /*private Image createPiece(PieceType type, String color)
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
    }*/

    /*private void createPieces(String color)
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
    }*/

    @Override
    protected void paintComponent(Graphics graphics)
    {
        //Draws background image
        graphics.drawImage(backgroundImage, 0, 0, null);


        Space[][] grid = Board.getInstance().grid;

        //Draws the tiles
        for (int row = 0; row < Board.ROWS; row++)
        {
            for (int column = 0; column < Board.COLUMNS; column++)
            {
//                xPositions[i][j] = TILE_SIZE * i;
//                yPositions[i][j] = TILE_SIZE * j;

                int x = TILE_SIZE * column;
                int y = TILE_SIZE * row;

                // Alternate color for tile background
                Image tile = ((row % 2) == (column % 2)) ? whiteTile : blackTile;
                graphics.drawImage(tile, x, y, null);
            }
        }

        //Draws the pieces
        for (int row = 0; row < Board.ROWS; row++)
        {
            for (int column = 0; column < Board.COLUMNS; column++)
            {
                try {
                    Piece piece = Board.getInstance().getSpace(row, column).getPiece();
                    Image image = getImage(piece);
                    int x = TILE_SIZE * column;
                    int y = TILE_SIZE * row;
                    graphics.drawImage(image, x + OFFSET, y + OFFSET, null);
                } catch(Exception e) {

                }
            }
        }
    }

    public void render()
    {
//        System.out.println("You called me bro?");
        repaint();
    }
}









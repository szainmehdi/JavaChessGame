package course.rcc.cis18b.chess.GUI;

import course.rcc.cis18b.chess.Entities.Piece;
import course.rcc.cis18b.chess.Entities.Board;
import course.rcc.cis18b.chess.Entities.Player;
import course.rcc.cis18b.chess.Entities.Space;
import course.rcc.cis18b.chess.TurnManager;

import javax.swing.*;
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
        Controller controller = new Controller();
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
        String path = IMAGES_PATH + filename;
        URL urlImage = getClass().getResource(path);
        return new ImageIcon(urlImage).getImage();
    }

    public Image getImage(Piece piece) {
        String path = IMAGES_PATH + piece.getModel();
        URL urlImage = getClass().getResource(path);
        return new ImageIcon(urlImage).getImage();
    }

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
        repaint();
    }

    @Override
    public double getTileSize() {
        return TILE_SIZE;
    }
}









//package course.rcc.cis18b.chess;
//
//import com.sun.istack.internal.Nullable;
//import course.rcc.cis18b.chess.Entities.Piece;
//
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import java.net.URL;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SwingGUI extends JPanel
//{
//    private static SwingGUI _instance = null;
//
//    private List<Piece> pieces = new ArrayList<Piece>();
//    private Image backgroundImage;
//
//    private final int xPositionBoard = 44;//Pixels with respect to ChessBoard.jpg
//    private final int yPositionBoard = 44;//Pixels with respect to ChessBoard.jpg
//
//    private final int spaceSizeOffset = 80;//Width/Height of the space in pixels
//    private int row = 0;
//    private int column = 0;
//
//
//
//    public static SwingGUI GetInstance()
//    {
//        if(_instance == null)
//        {
//            _instance = new SwingGUI();
//        }
//        return _instance;
//    }
//
//    private SwingGUI()
//    {
//        CreateBoard();
//        CreatePieces();
//    }
//
//    /**
//     * Get the image from the Images package.
//     * @param filename
//     * @return the instance of the found image.
//     */
//    @Nullable
//    private Image GetImage(String filename)
//    {
//        String path = "Images/";
//        Image image = null;
//
//        path += filename;
//        URL imagePath = getClass().getResource(path);
//        image = new ImageIcon(imagePath).getImage();
//
//        return image;
//    }
//
//    private void CreateBoard()
//    {
//        backgroundImage = GetImage("ChessBoard.jpg");
//
//        JFrame frame = new JFrame();
//        frame.setTitle("Chess Game");
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(this);
//        frame.setResizable(false);
//        frame.setSize(backgroundImage.getWidth(null), 760);
//        frame.setLocationRelativeTo(null);
//    }
//
//    private void CreatePieces()
//    {
//        System.out.println("CreatePieces Called!");
//        column = 7;
//        CreatePiece("White", "Rook",
//                xPositionBoard + spaceSizeOffset * row,
//                yPositionBoard + spaceSizeOffset * column);
//    }
//
//    private void CreatePiece(String color, String type, int XPosition, int YPosition)
//    {
//        System.out.println("CreatePiece Called!");
//        String filename = "";
//        String extension = ".png";
//        filename = color + type + extension;
//
//        System.out.println(filename);
//        Image image = GetImage(filename);
//        System.out.println("Width: " + image.getWidth(null) + "Height: " + image.getHeight(null));
//        Piece piece = new Piece(image, XPosition, YPosition);
//        pieces.add(piece);
//        //System.out.println("Pieces: " + pieces.size());
//    }
//
//    protected void paintComponent(Graphics graphics)
//    {
//        graphics.drawImage(backgroundImage, 0, 0, null);
//        //System.out.println("XPosition: " + pieces.get(0).GetXPosition() + "YPosition: " + pieces.get(0).GetYPosition());
//        //graphics.drawImage(pieces.get(0).GetImage(), pieces.get(0).GetXPosition(), pieces.get(0).GetYPosition(), null);
//        /*
//        for (int i = 0; i < pieces.size(); i++)
//        {
//            graphics.drawImage(pieces.get(i).GetImage(), pieces.get(i).GetXPosition(), pieces.get(i).GetYPosition(), null);
//        }
//        */
//    }
//
//}
//

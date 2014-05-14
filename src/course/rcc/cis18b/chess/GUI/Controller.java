package course.rcc.cis18b.chess.GUI;

import course.rcc.cis18b.chess.Application;
import course.rcc.cis18b.chess.Entities.Board;
import course.rcc.cis18b.chess.Entities.Piece;
import course.rcc.cis18b.chess.Exceptions.InvalidMoveException;
import course.rcc.cis18b.chess.Exceptions.UnauthorizedMoveException;
import course.rcc.cis18b.chess.TurnManager;

import java.awt.*;
import java.awt.event.*;

public class Controller implements MouseListener, MouseMotionListener, KeyListener
{
//    public static final int ROWS = 8;
//    public static final int COLUMNS = 8;
//    private Image[][] grid = new Image[ROWS][COLUMNS];
//    private int[][] xPositions = new int[ROWS][COLUMNS];
//    private int[][] yPositions = new int[ROWS][COLUMNS];
//    private SwingGuiManager swingGuiManager;
//    private Image dragPiece;
//    private boolean isBreak;

    private Piece selectedPiece = null;


    public Controller() {

    }

    public Controller(Image[][] grid, int[][] xPositions, int[][] yPositions, SwingGuiManager swingGuiManager)
    {
//        this.grid = grid;
//        this.xPositions = xPositions;
//        this.yPositions = yPositions;
//        this.swingGuiManager = swingGuiManager;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent event)
    {
        int mouseXPosition = event.getPoint().x;
        int mouseYPosition = event.getPoint().y;

        double tileSize = Application.getGuiManager().getTileSize();

        int column = (int)Math.floor(mouseXPosition/tileSize);
        int row = (int)Math.floor(mouseYPosition/tileSize);

        try {
            if(selectedPiece == null) {
                Piece piece = Board.getInstance().getSpace(row,column).getPiece();

                if(piece.getPlayer() != TurnManager.getInstance().currentPlayer()) {
                    throw new UnauthorizedMoveException("This piece does not belong to the current player.");
                }

                System.out.println("Location Clicked: (" + mouseXPosition + ", " + mouseYPosition + ")");
                System.out.println("Grid Box: (" + row + ", " + column + ")");

                selectedPiece = piece;
            } else { //if a piece is selected
                selectedPiece.move(row, column);
                TurnManager.getInstance().next();
                Board.getInstance().render();
                clearSelection();
            }

        } catch(IndexOutOfBoundsException e) {
            //Invalid space, ignore click.
        } catch (InvalidMoveException e) {
            System.err.println(e.getMessage());
            clearSelection();
        } catch (UnauthorizedMoveException e) {
            System.err.println(e.getMessage());
            clearSelection();
        } catch (Exception e) {
            System.err.println("Unknown error occured: " + e.getMessage());
        }
    }

    @Override
    public void mouseReleased(MouseEvent event)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent event)
    {
        //if(dragPiece != null)
        //{
            //dragPiece.setX(evt.getPoint().x - this.dragOffsetX);
            //dragPiece.setY(evt.getPoint().y - this.dragOffsetY);
            //SwingGuiManager.render();
        //}
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    private boolean selectedPiece(Image selectedPiece, int mouseXPosition, int mouseYPosition)
    {
        /*for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid.length; j++)
            {
                if(xPositions[i][j] <= mouseXPosition
                        && xPositions[i][j] + selectedPiece.getWidth(null) >= mouseXPosition
                        && yPositions[i][j] <= mouseXPosition
                        && yPositions[i][j] + selectedPiece.getHeight(null) >= mouseYPosition)
                {
                    isBreak = true;
                    break;
                }
            }
            if(isBreak == true)
                break;
        }*/
        return true;
    }

    private void clearSelection() {
        selectedPiece = null;
    }
}

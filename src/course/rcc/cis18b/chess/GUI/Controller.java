package course.rcc.cis18b.chess.GUI;

import java.awt.*;
import java.awt.event.*;

public class Controller implements MouseListener, MouseMotionListener, KeyListener
{
    public static final int ROWS = 8;
    public static final int COLUMNS = 8;
    private Image[][] grid = new Image[ROWS][COLUMNS];
    private int[][] xPositions = new int[ROWS][COLUMNS];
    private int[][] yPositions = new int[ROWS][COLUMNS];
    private SwingGuiManager swingGuiManager;
    private Image dragPiece;
    private boolean isBreak;

    public Controller(Image[][] grid, int[][] xPositions, int[][] yPositions, SwingGuiManager swingGuiManager)
    {
        this.grid = grid;
        this.xPositions = xPositions;
        this.yPositions = yPositions;
        this.swingGuiManager = swingGuiManager;
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

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid.length; j++)
            {
                Image piece = grid[i][j];

                if(selectedPiece(piece, mouseXPosition, mouseYPosition))
                {
                    dragPiece = piece;
                    isBreak = true;
                    break;
                }
            }
            if(isBreak == true)
                break;
        }


        System.out.println("X: " + mouseXPosition);
        System.out.println("Y: " + mouseYPosition);
    }

    @Override
    public void mouseReleased(MouseEvent event)
    {
        dragPiece = null;
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
        if(dragPiece != null)
        {
            //dragPiece.setX(evt.getPoint().x - this.dragOffsetX);
            //dragPiece.setY(evt.getPoint().y - this.dragOffsetY);
            //SwingGuiManager.render();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    private boolean selectedPiece(Image selectedPiece, int mouseXPosition, int mouseYPosition)
    {
        for(int i = 0; i < grid.length; i++)
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
        }
        return true;
    }
}

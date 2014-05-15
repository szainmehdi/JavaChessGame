package course.rcc.cis18b.chess.GUI;

import course.rcc.cis18b.chess.Application;
import course.rcc.cis18b.chess.Entities.Board;
import course.rcc.cis18b.chess.Entities.Piece;
import course.rcc.cis18b.chess.Exceptions.InvalidMoveException;
import course.rcc.cis18b.chess.Exceptions.UnauthorizedMoveException;
import course.rcc.cis18b.chess.TurnManager;

import java.awt.*;
import java.awt.event.*;

public class Controller implements MouseListener, MouseMotionListener, KeyListener {

    private Piece selectedPiece = null;


    public Controller() {

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
    public void mousePressed(MouseEvent event) {
        int mouseXPosition = event.getPoint().x;
        int mouseYPosition = event.getPoint().y;

        double tileSize = Application.getGuiManager().getTileSize();

        int column = (int)Math.floor(mouseXPosition/tileSize);
        int row = (int)Math.floor(mouseYPosition/tileSize);

        try {
            if(selectedPiece == null) {
                Piece piece = Board.getInstance().getSpace(row,column).getPiece();
                if(piece == null) {
                    return;
                }
                if(piece.getPlayer() != TurnManager.getInstance().currentPlayer()) {
                    throw new UnauthorizedMoveException("This piece does not belong to the current player.");
                }
                selectedPiece = piece;
            } else { //if a piece is selected
                selectedPiece.move(row, column);
                TurnManager.getInstance().next();
                clearSelection();
            }

        } catch(IndexOutOfBoundsException e) {
            //Invalid space, ignore click.
        } catch (InvalidMoveException e) {
            Application.getGuiManager().showAlert(e.getMessage());
            clearSelection();
        } catch (UnauthorizedMoveException e) {
            Application.getGuiManager().showAlert(e.getMessage());

            clearSelection();
        } catch (Exception e) {
            Application.getGuiManager().showAlert("Unknown error occured: " + e.getMessage());

        } finally {
            Board.getInstance().render();
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent event) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    private void clearSelection() {
        selectedPiece = null;
    }

    public Piece getSelectedPiece() {
        return selectedPiece;
    }
}

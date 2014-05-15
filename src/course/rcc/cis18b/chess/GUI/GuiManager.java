package course.rcc.cis18b.chess.GUI;

public interface GuiManager {

    /**
     * Render the current game state to the screen.
     */
    public void render();

    /**
     * Get each tile's size.
     * @return
     */
    public int getTileSize();

    /**
     * Show a message to the user.
     * @param msg
     */
    public void showMessage(String msg);

    /**
     * Show an alert to the user.
     * @param msg
     */
    public void showAlert(String msg);

}

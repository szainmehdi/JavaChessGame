package course.rcc.cis18b.chess.GUI;

public interface GuiManager {

    public void render();

    public int getTileSize();

    public void showMessage(String msg);

    public void showAlert(String msg);

}

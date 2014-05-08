package course.rcc.cis18b.chess.Behaviors;

public interface MoveBehavior {

    /**
     * Move the piece to a new location.
     * @param row
     * @param column
     */
    public void move(int row, int column);

}

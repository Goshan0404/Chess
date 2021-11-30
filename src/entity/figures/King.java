package entity.figures;

import entity.Coordinates;

public class King extends Figure {

    private King(boolean isWhite, char symbol, Coordinates coordinates) {
        super(isWhite, symbol, coordinates);
    }

    public static King newBlackKing(Coordinates coordinates) {
        return new King(false, '\u265a', coordinates);
    }

    public static King newWhiteKing(Coordinates coordinates) {
        return new King(true, '\u2654', coordinates);
    }


    @Override
    public String toString() {
        return super.toString() + " " + coordinates.getX() + " " + coordinates.getY();
    }

    @Override
    public boolean canMove(int toY, int toX) {
        return (Math.abs(coordinates.getX() - toX) == 1 &&
                Math.abs(coordinates.getY() - toY) == 1);
    }
}

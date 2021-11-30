package entity.figures;

import entity.Coordinates;

public class Rook extends Figure {

    private Rook(boolean isWhite, char symbol, Coordinates coordinates) {
        super(isWhite, symbol, coordinates);

    }

    public static Rook newWhitRook(Coordinates coordinates) {
        return new Rook(true, '\u2656', coordinates);
    }

    public static Rook newBlackRook(Coordinates coordinates) {
        return new Rook(false, '\u265c', coordinates);
    }

    @Override
    public boolean canMove(int toY, int toX) {
        if (coordinates.getX() != toX && coordinates.getY() == toY)
            return true;
        else if (coordinates.getX() == toX && coordinates.getY() != toY)
            return true;
        return false;
    }
}

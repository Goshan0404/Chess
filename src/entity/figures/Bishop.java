package entity.figures;

import entity.Coordinates;

public class Bishop extends Figure {


    private Bishop(boolean isWhite, char symbol, Coordinates coordinates) {
        super(isWhite, symbol, coordinates);
    }

    public static Bishop newBlackBishop(Coordinates coordinates) {
        return new Bishop(false, '\u265d', coordinates);
    }

    public static Bishop newWhiteBishop(Coordinates coordinates) {
        return new Bishop(true, '\u2657', coordinates);
    }

    @Override
    public boolean canMove(int toY, int toX) {
        if (Math.abs(toY - coordinates.getY()) - Math.abs(toX - coordinates.getX()) == 0)
            return true;
        return false;
    }
}

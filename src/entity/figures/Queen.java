package entity.figures;

import entity.Coordinates;

public class Queen extends Figure {


    private Queen(boolean isWhite, char symbol, Coordinates coordinates) {
        super(isWhite, symbol, coordinates);

    }

    public static Queen newWhiteQueen(Coordinates coordinates) {
        return new Queen(true, '\u2655', coordinates);
    }

    public static Queen newBlackQueen(Coordinates coordinates) {
        return new Queen(false, '\u265b', coordinates);
    }


    @Override
    public boolean canMove(int toY, int toX) {
        if ((Math.abs(coordinates.getX() - toX) == 1) && (Math.abs(coordinates.getY() - toY) == 2)
                || (Math.abs(coordinates.getX() - toX)) != 2 && (Math.abs(coordinates.getY() - toY) != 1)) {
            return false;
        }else
            return true;
    }
}

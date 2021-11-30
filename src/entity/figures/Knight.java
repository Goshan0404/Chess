package entity.figures;

import entity.Coordinates;

public class Knight extends Figure {


    private Knight(boolean isWhite, char symbol, Coordinates coordinates) {
        super(isWhite, symbol, coordinates);
    }

    public static Knight newBlackKnight(Coordinates coordinates) {
        return new Knight(false, '\u265e', coordinates);
    }

    public static Knight newWhiteKnight(Coordinates coordinates) {
        return new Knight(true, '\u2658', coordinates);
    }



    @Override
    public boolean canMove(int toY, int toX) {

        if ((Math.abs(coordinates.getX() - toX) == 1) && (Math.abs(coordinates.getY() - toY) == 2)
                || (Math.abs(coordinates.getX() - toX)) == 2 && (Math.abs(coordinates.getY() - toY) == 1)) {
            return true;
        }else
            return false;
    }
}

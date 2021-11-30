package entity.figures;

import entity.Coordinates;

public class Pawn extends Figure {
	boolean isFirstStep = true;

	private Pawn(boolean isWhite, char symbol, Coordinates coordinates) {
		super(isWhite, symbol, coordinates);
	}

	public static Pawn newBlackPawn(Coordinates coordinates) {
		return new Pawn(false, '\u265f', coordinates);
	}

	public static Pawn newWhitePawn(Coordinates coordinates) {
		return new Pawn(true, '\u2659', coordinates);
	}

	@Override
	public boolean canMove(int toY, int toX) {
		if (isFirstStep) {
			if (coordinates.getY() - toY <= 2 && coordinates.getY() - toY != 0
					&& coordinates.getX() == toX) {
				isFirstStep = false;
				return true;
			}
		} else if(coordinates.getY() - toY == 1
				&& coordinates.getX() == toX) {
			return true;
		}
		return false;
	}
}

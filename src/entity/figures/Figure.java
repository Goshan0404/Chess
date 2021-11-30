package entity.figures;

import entity.Coordinates;

public abstract class Figure {

	protected boolean colorIsWhite; // true = white, false = black
	protected boolean isOnBoard;  // true = onBoard
	protected char symbol; // '\u2654'..'\u265f';
	protected Coordinates coordinates;

	public boolean isColorIsWhite() {
		return colorIsWhite;
	}

	public boolean isOnBoard() {
		return isOnBoard;
	}

	public void setOnBoard(boolean onBoard) {
		isOnBoard = onBoard;
	}

	public void setColorIsWhite(boolean colorIsWhite) {
		this.colorIsWhite = colorIsWhite;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

	public Figure(boolean colorIsWhite, char symbol, Coordinates coordinates) {
		setColorIsWhite(colorIsWhite);
		this.isOnBoard = true;
		setSymbol(symbol);
		this.coordinates = coordinates;
	}

	public void move(int toY, int toX) {
		coordinates.setX(toX);
		coordinates.setY(toY);
	}

	public abstract boolean canMove(int toY, int toX);

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return String.valueOf(symbol);
	}
}

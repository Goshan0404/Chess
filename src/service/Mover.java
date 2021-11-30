package service;

import entity.Coordinates;
import field.Field;
import entity.figures.Figure;

public class Mover {
	private final Reader reader = new Reader();

	private final Field field;
	private Coordinates coordinates;
	private Coordinates newCoordinates;

	private boolean isWhiteTurn = true;

	public Mover(Field field) {
		this.field = field;
	}

	public void move() {
		selectFigure();
		setNewCoordinates();
	}

	private boolean checkMoveCoordinates() {
		for(int i = 0; i < Math.abs(newCoordinates.getY() - coordinates.getY()); i++) {
			for(int j = 0; j < Math.abs(newCoordinates.getX() - coordinates.getX()); j++) {

				if (field.getFigure(new Coordinates(coordinates.getY() + (newCoordinates.getY() - coordinates.getY()) + i,
						coordinates.getX() + (newCoordinates.getX() - coordinates.getX()) + j)) != null) {
					return false;
				}
			}
		}

		if (field.getFigure(newCoordinates) == null
				|| field.getFigure(coordinates).isColorIsWhite() != field.getFigure(newCoordinates).isColorIsWhite()) {
			return field.getFigure(coordinates).canMove(newCoordinates.getY(), newCoordinates.getX())
					&& 9 > newCoordinates.getX() && newCoordinates.getX() > 0
					&& 9 > newCoordinates.getY() && newCoordinates.getY() > 0;
		}
		return false;

	}

	private boolean checkFigureCoordinates(boolean isWhiteTurn) {
		if (field.getFigure(coordinates) == null) {
			return false;
		}

		if (checkForWhite(isWhiteTurn)) {
			return true;
		}
		return checkForBlack(isWhiteTurn);
	}

	private boolean checkForBlack(boolean isWhiteTurn) {
		return !isWhiteTurn
				&& !field.getFigure(coordinates).isColorIsWhite()
				&& 9 > coordinates.getX() && coordinates.getX() > 0
				&& 9 > coordinates.getY() && coordinates.getY() > 0;
	}

	private boolean checkForWhite(boolean isWhiteTurn) {
		return isWhiteTurn
				&& field.getFigure(coordinates).isColorIsWhite()
				&& 9 > coordinates.getX() && coordinates.getX() > 0
				&& 9 > coordinates.getY() && coordinates.getY() > 0;
	}

	private void selectFigure() {

		do {
			coordinates = reader.readFigureCoordinates();

			if (checkFigureCoordinates(isWhiteTurn)) {
				break;
			}
			System.out.println();
			System.out.println();

			field.printField();
			System.out.println();
			System.out.println("Ошибка: введены не верные координаты фигуры");
		} while (true);

	}

	private void setNewCoordinates() {
		do {
			newCoordinates = reader.readMoveCoordinates();

			if (checkMoveCoordinates()) {
				Figure figure = field.getFigure(coordinates);

				if (field.getFigure(newCoordinates) != null) {
					field.getFigure(newCoordinates).setOnBoard(false);
				}
				figure.move(newCoordinates.getY(), newCoordinates.getX());
				field.exchangeFigures(coordinates, newCoordinates);
				isWhiteTurn = !isWhiteTurn;
				break;
			}
			System.out.println();
			System.out.println();

			field.printField();
			System.out.println();
			System.out.println("Ошибка: введены не верные координаты хода");
			selectFigure();
		} while (true);


	}
}

package service;

import field.Field;

public class Judge {
	private final Field field = new Field();
	Mover mover = new Mover(field);


	public void startGame() {
		while(field.getStatusOfWhiteKing() && field.getStatusOfBlackKing()) {
			field.printField();
			mover.move();

			System.out.println();
			System.out.println();
		}
	}
}

package service;

import entity.Coordinates;

import java.util.Scanner;

public class Reader {
	private final Scanner scanner = new Scanner(System.in);

	public Coordinates readMoveCoordinates() {
		System.out.print("Введите координаты X хода: ");
		int x = scanner.nextInt();

		System.out.print("Введите координаты Y хода: ");
		int y = scanner.nextInt();

		return new Coordinates(y, x);
	}

	public Coordinates readFigureCoordinates() {
		System.out.print("Введите координаты X фигуры: ");
		int x = scanner.nextInt();

		System.out.print("Введите координаты Y фигуры: ");
		int y = scanner.nextInt();

		return new Coordinates(y, x);
	}
}

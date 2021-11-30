package field;

import entity.Coordinates;
import entity.figures.*;


public class Field {

	King whiteKing = King.newWhiteKing(new Coordinates(8, 5));
	King blackKing = King.newBlackKing(new Coordinates(1, 5));
	Queen whiteQueen = Queen.newWhiteQueen(new Coordinates(8, 4));
	Queen blackQueen = Queen.newBlackQueen(new Coordinates(1, 4));
	Rook whiteRook = Rook.newWhitRook(new Coordinates(8, 1));
	Rook blackRook = Rook.newBlackRook(new Coordinates(1, 1));
	Knight whiteKnight = Knight.newWhiteKnight(new Coordinates(8, 2));
	Knight blackKnight = Knight.newBlackKnight(new Coordinates(1, 2));
	Bishop whiteBishop = Bishop.newWhiteBishop(new Coordinates(8, 3));
	Bishop blackBishop = Bishop.newBlackBishop(new Coordinates(1, 3));
	Rook whiteRook2 = Rook.newWhitRook(new Coordinates(8, 8));
	Rook blackRook2 = Rook.newBlackRook(new Coordinates(1, 8));
	Knight whiteKnight2 = Knight.newWhiteKnight(new Coordinates(8, 7));
	Knight blackKnight2 = Knight.newBlackKnight(new Coordinates(1, 7));
	Bishop whiteBishop2 = Bishop.newWhiteBishop(new Coordinates(8, 6));
	Bishop blackBishop2 = Bishop.newBlackBishop(new Coordinates(1, 6));

	Pawn[] whitePawns = new Pawn[8];
	Pawn[] blackPawns = new Pawn[8];

	Figure[][] chessField = new Figure[9][9];

	public boolean getStatusOfWhiteKing() {
		return whiteKing.isOnBoard();
	}

	public boolean getStatusOfBlackKing() {
		return blackKing.isOnBoard();
	}

	public Field() {
		setInitialPositionPawns();

		setInitialPositionFigure(whiteKing);
		setInitialPositionFigure(blackKing);
		setInitialPositionFigure(whiteRook);
		setInitialPositionFigure(blackRook);
		setInitialPositionFigure(whiteQueen);
		setInitialPositionFigure(blackQueen);
		setInitialPositionFigure(whiteKnight);
		setInitialPositionFigure(whiteKing);
		setInitialPositionFigure(blackKnight);
		setInitialPositionFigure(whiteBishop);
		setInitialPositionFigure(blackBishop);
		setInitialPositionFigure(blackRook2);
		setInitialPositionFigure(whiteRook2);
		setInitialPositionFigure(blackKnight2);
		setInitialPositionFigure(whiteKnight2);
		setInitialPositionFigure(blackBishop2);
		setInitialPositionFigure(whiteBishop2);
	}

	public Figure getFigure(Coordinates coordinates) {
		return chessField[coordinates.getY()][coordinates.getX()];
	}

	public void exchangeFigures(Coordinates coordinates, Coordinates newCoordinates) {
		chessField[newCoordinates.getY()][newCoordinates.getX()] = chessField[coordinates.getY()][coordinates.getX()];
		chessField[coordinates.getY()][coordinates.getX()] = null;
	}

	public void printField() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (chessField[i][j] != null)
					System.out.print(" " + chessField[i][j].getSymbol());
				else if (i == 0 && j == 0)
					continue;
				else if (i == 0)
					System.out.print("  " + j);
				else if (j == 0)
					System.out.print(i + " ");
				else
					System.out.print(" " +'⛝');
			}
			System.out.println();
		}
	}

	private void setInitialPositionPawns() {
		for (int i = 0; i < blackPawns.length; i++) {
			blackPawns[i] = Pawn.newBlackPawn(new Coordinates(2, i + 1));
			setInitialPositionFigure(blackPawns[i]);
		}

		for (int i = 0; i < whitePawns.length; i++) {
			whitePawns[i] = Pawn.newWhitePawn(new Coordinates(7, i + 1));
			setInitialPositionFigure(whitePawns[i]);
		}
	}

	private void setInitialPositionFigure(Figure figure) {
		Coordinates coordinates = figure.getCoordinates();
		chessField[coordinates.getY()][coordinates.getX()] = figure;
	}
}

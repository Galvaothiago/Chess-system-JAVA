package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position piece = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			piece.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(piece) && !getBoard().thereIsAPiece(piece)) {
				matriz[piece.getRow()][piece.getColumn()] = true;
			}
			piece.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(piece) && !getBoard().thereIsAPiece(piece) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				matriz[piece.getRow()][piece.getColumn()] = true;
			}
			piece.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(piece) && isThereOpponentPiece(piece)) {
				matriz[piece.getRow()][piece.getColumn()] = true;
			}			
			piece.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(piece) && isThereOpponentPiece(piece)) {
				matriz[piece.getRow()][piece.getColumn()] = true;
			}			
		}
		else {
			piece.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(piece) && !getBoard().thereIsAPiece(piece)) {
				matriz[piece.getRow()][piece.getColumn()] = true;
			}
			piece.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(piece) && !getBoard().thereIsAPiece(piece) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				matriz[piece.getRow()][piece.getColumn()] = true;
			}
			piece.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(piece) && isThereOpponentPiece(piece)) {
				matriz[piece.getRow()][piece.getColumn()] = true;
			}			
			piece.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(piece) && isThereOpponentPiece(piece)) {
				matriz[piece.getRow()][piece.getColumn()] = true;
			}	
		}
		return matriz;
	}

	@Override
	public String toString() {
		return "P";
	}

}

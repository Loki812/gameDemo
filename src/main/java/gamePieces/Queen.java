package gamePieces;

import boardGame.boardModel;

import java.util.ArrayList;

public class Queen extends gamePiece{

    public Queen(boardModel model, Coordinates initCoor) {
        super(model, initCoor);
    }

    @Override
    ArrayList<Coordinates> getAvailableMoves() {
        return null;
    }
}

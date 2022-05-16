package gamePieces;

import boardGame.boardModel;

import java.util.ArrayList;

public class Bishop extends gamePiece{

    public Bishop(boardModel model, Coordinates initCoor) {
        super(model, initCoor);
    }

    @Override
    ArrayList<Coordinates> getAvailableMoves() {
        return null;
    }
}

package gamePieces;

import boardGame.boardModel;

import java.util.ArrayList;

public class Khight extends gamePiece{
    public Khight(boardModel model, Coordinates initCoor) {
        super(model, initCoor);
    }

    @Override
    ArrayList<Coordinates> getAvailableMoves() {
        return null;
    }
}

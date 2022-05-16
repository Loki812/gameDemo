package gamePieces;

import boardGame.boardModel;

import java.util.ArrayList;

public class Pawn extends gamePiece{


    public Pawn(boardModel model, Coordinates initCoor) {
        super(model, initCoor);

    }

    @Override
    ArrayList<Coordinates> getAvailableMoves() {
        return null;
    }
}

package gamePieces;

import boardGame.boardModel;

import java.util.ArrayList;

public class King extends gamePiece{


    public King(boardModel model, Coordinates initCoor) {
        super(model, initCoor);
    }

    @Override
    ArrayList<Coordinates> getAvailableMoves() {
        return null;
    }
}

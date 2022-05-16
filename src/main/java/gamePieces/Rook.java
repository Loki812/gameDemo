package gamePieces;

import boardGame.boardModel;

import java.util.ArrayList;

public class Rook extends gamePiece{

    public Rook(boardModel model, Coordinates initCoor) {
        super(model, initCoor);
    }

    @Override
    ArrayList<Coordinates> getAvailableMoves() {
        ArrayList<Coordinates> availableMoves = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            availableMoves.add(new Coordinates(i, getCurrentPos().col()));
        }
        for (int i = 0; i < 7; i++) {
            availableMoves.add(new Coordinates(getCurrentPos().row(), i));
        }
        availableMoves.remove(getCurrentPos());
        return availableMoves;
    }

    //TODO
    @Override
    public boolean equals(Object o) {
        return false;
    }
}

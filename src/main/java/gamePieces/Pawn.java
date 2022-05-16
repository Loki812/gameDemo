package gamePieces;

import boardGame.boardModel;

import javafx.scene.layout.BackgroundRepeat;

import java.util.ArrayList;

public class Pawn extends gamePiece{

    Coordinates intialPos;

    public Pawn(boardModel model, Coordinates initCoor) {
        super(model, initCoor);
        intialPos = initCoor;
    }

    //TODO: collision detection by using model
    //TODO: capturing other pieces by using model data
    @Override
    ArrayList<Coordinates> getAvailableMoves() {
        ArrayList<Coordinates> availableMoves = new ArrayList<>();

        if(intialPos.row() == 1 && getCurrentPos().row() == 1) {
            availableMoves.add(new Coordinates(2, getCurrentPos().col()));
            availableMoves.add(new Coordinates(3, getCurrentPos().col()));
        }
        //TODO include upgrading to queen etc
        else if(intialPos.row() == 1 && getCurrentPos().row() != 7) {
            availableMoves.add(new Coordinates(getCurrentPos().row() + 1, getCurrentPos().col()));
        }
        else if(intialPos.row() == 6 && getCurrentPos().row() == 6) {
            availableMoves.add(new Coordinates(5, getCurrentPos().col()));
            availableMoves.add(new Coordinates(4, getCurrentPos().col()));
        }
        else if (intialPos.row() == 6 && getCurrentPos().row() != 0) {
            availableMoves.add(new Coordinates(getCurrentPos().row() - 1, getCurrentPos().col()));
        }
        else {
            return null; //For now
        }
        return availableMoves;
    }
}

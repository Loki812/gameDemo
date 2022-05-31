package gamePieces;

import java.util.ArrayList;
import java.util.Objects;

import boardGame.boardModel;
import javafx.scene.image.ImageView;

public class Pawn extends gamePiece{

    Coordinates intialPos;

    public Pawn(boardModel model, Coordinates initCoor) {
        super(model, initCoor);
        intialPos = initCoor;

        if(initCoor.row() == 1) {
            color = false;
            image = new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/blackPieces/blackPawn.png")).toExternalForm());
        }
        else if(initCoor.row() == 6) {
            color = true;
            image = new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/whitePieces/whitePawn.png")).toExternalForm());
        }
    }

    //TODO: collision detection by using model
    //TODO: capturing other pieces by using model data
    @Override
    public void generateMoves() {
        ArrayList<Coordinates> availableMoves = new ArrayList<>();

        if(!color && getCurrentPos().row() == 1) {
            availableMoves.add(new Coordinates(2, getCurrentPos().col()));
            availableMoves.add(new Coordinates(3, getCurrentPos().col()));
        }
        //TODO include upgrading to queen etc
        else if(!color && getCurrentPos().row() != 7) {
            availableMoves.add(new Coordinates(getCurrentPos().row() + 1, getCurrentPos().col()));
        }
        else if(color && getCurrentPos().row() == 6) {
            availableMoves.add(new Coordinates(5, getCurrentPos().col()));
            availableMoves.add(new Coordinates(4, getCurrentPos().col()));
        }
        else if (color && getCurrentPos().row() != 0) {
            availableMoves.add(new Coordinates(getCurrentPos().row() - 1, getCurrentPos().col()));
        }
        setAvailableMoves(availableMoves);
    }
}

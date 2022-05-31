package gamePieces;

import java.util.ArrayList;
import java.util.Objects;

import boardGame.boardModel;
import javafx.scene.image.ImageView;

public class Rook extends gamePiece{

    public Rook(boardModel model, Coordinates initCoor) {
        super(model, initCoor);
        if(initCoor.row() == 0) {
            color = false;
            image = new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/blackPieces/blackRook.png")).toExternalForm());
        }
        else if(initCoor.row() == 7) {
            color = true;
            image = new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/whitePieces/whiteRook.png")).toExternalForm());
        }
    }


    /**
     * Generates the moves for the rook gamePiece, will add horizontal and vertical moves to
     * the arraylist until it is met with a collision, upon said collision (checking the hashmap if it contains
     * said coordinates). It will check if it can capture it or not.
     */
    @Override
    public void generateMoves() {
        ArrayList<Coordinates> availableMoves = new ArrayList<>();
        //creates the moves to the north of the rook
        for(int i = getCurrentPos().row(); i >= 0; i--) {
            if(model.map.containsKey(new Coordinates(i, getCurrentPos().col()))) {
                if(model.map.get(new Coordinates(i, getCurrentPos().col())).color != this.color) {
                    availableMoves.add(new Coordinates(i, getCurrentPos().col()));
                }
                break;
            }
            else {
                availableMoves.add(new Coordinates(i, getCurrentPos().col()));
            }
        }
        //creates the moves to the south of the rook
        for(int i = getCurrentPos().row(); i < 8; i++) {
            if(model.map.containsKey(new Coordinates(i, getCurrentPos().col()))) {
                if(model.map.get(new Coordinates(i, getCurrentPos().col())).color != this.color) {
                    availableMoves.add(new Coordinates(i, getCurrentPos().col()));
                }
                break;
            }
            else {
                availableMoves.add(new Coordinates(i, getCurrentPos().col()));
            }
        }
        //creates the moves to the east of the rook
        for(int x = getCurrentPos().col(); x < 8; x++) {
            if(model.map.containsKey(new Coordinates(getCurrentPos().row(), x))) {
                if(model.map.get(new Coordinates(getCurrentPos().row(), x)).color != this.color) {
                    availableMoves.add(new Coordinates(getCurrentPos().row(), x));
                }
                break;
            }
            else {
                availableMoves.add(new Coordinates(getCurrentPos().row(), x));
            }
        }
        //creates the moves to the west of the rook
        for(int x = getCurrentPos().col(); x >= 0; x--) {
            if(model.map.containsKey(new Coordinates(getCurrentPos().row(), x))) {
                if(model.map.get(new Coordinates(getCurrentPos().row(), x)).color != this.color) {
                    availableMoves.add(new Coordinates(getCurrentPos().row(), x));
                }
                break;
            }
            else {
                availableMoves.add(new Coordinates(getCurrentPos().row(), x));
            }
        }

       setAvailableMoves(availableMoves);
    }


}

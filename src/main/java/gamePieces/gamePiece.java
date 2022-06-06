package gamePieces;

import javafx.scene.image.ImageView;
import boardGame.boardModel;

import java.util.ArrayList;
import java.util.Objects;

public abstract class gamePiece {

    private Coordinates currentPos;

    private ArrayList<Coordinates> availableMoves;

    public static boardModel model;

    public ImageView image;

    public char notation;

    /** true for white, false for black**/
    public boolean color;

    public gamePiece(boardModel model, Coordinates initCoor) {
        gamePiece.model = model;
        this.currentPos = initCoor;
    }

    public Coordinates getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(Coordinates currentPos) {
        this.currentPos = currentPos;
    }

    public ArrayList<Coordinates> getAvailableMoves() {
        return availableMoves;
    }

    public void setAvailableMoves(ArrayList<Coordinates> moves) {this.availableMoves = moves;}

    public abstract void generateMoves();


}

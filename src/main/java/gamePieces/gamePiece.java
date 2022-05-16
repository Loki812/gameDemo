package gamePieces;

import boardGame.boardModel;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public abstract class gamePiece {

    private Coordinates currentPos;

    private boardModel model;

    public ImageView image;

    public boolean color;

    public gamePiece(boardModel model, Coordinates initCoor) {
        this.model = model;
        this.currentPos = initCoor;
    }

    public Coordinates getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(Coordinates currentPos) {
        this.currentPos = currentPos;
    }

    public void setImage(ImageView image) {
        this.image = image;

    }

    abstract ArrayList<Coordinates> getAvailableMoves();


}

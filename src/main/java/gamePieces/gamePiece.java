package gamePieces;

import boardGame.boardModel;

import javax.swing.text.html.ImageView;
import java.util.ArrayList;

public abstract class gamePiece {

    private Coordinates currentPos;

    private boardModel model;

    public ImageView image;

    public gamePiece(boardModel model, Coordinates initCoor) {
        this.model = model;
        this.currentPos = initCoor;
    }

    public Coordinates getCurrentPos() {
        return currentPos;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    abstract ArrayList<Coordinates> getAvailableMoves();


}

package gamePieces;

import javafx.scene.image.ImageView;
import boardGame.boardModel;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Representative of a gamePiece in the game of Chess, used by the model to hold states of the game piece.
 *
 * @author Connor McRoberts
 */
public abstract class gamePiece {

    /**
     * The current coordinate of the gamePiece, should always be between
     * (0, 0) and (7, 7)
     */
    private Coordinates currentPos;

    /**
     * An ArrayList of coordinates containing all the possible moves for the gamePiece to move to,
     * is edited with multiple functions such as generateMoves(), generateCheckMoves(), and getters and setters.
     *
     * Used by the view to display to the player where the gamePiece can move
     */
    private ArrayList<Coordinates> availableMoves;

    /**
     * The *backend* that the gamePiece connects too, gamePieces are initialized in the Model's constructor
     *
     * Mainly used when calling the generateMoves
     */
    public static boardModel model;

    /**
     * The image used by the view to display the gamePiece
     */
    public ImageView image;

    /**
     * Used by the displayPrevMoves() on the view, each gamePiece gets assigned a char
     * in its constructor
     *
     * - Pawn null
     * - Khight N
     * - Bishop B
     * - Rook R
     * - King K
     * - Queen Q
     */
    public char notation;

    /** true for white, false for black**/
    public boolean color;

    public int pointValue;

    /**
     *
     * @param model The backend to the gamePiece
     * @param initCoor The initial coordinates of the gamePiece
     */
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

    //TODO make all of the implementations look at the gameState, create check moves dependent on that
    public abstract void generateMoves();

    //TODO
    public  abstract gamePiece copyPiece();

}

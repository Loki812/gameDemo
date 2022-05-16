package boardGame;

import gamePieces.*;

import java.util.HashMap;

public class boardModel {

    public HashMap<Coordinates, gamePiece> boardMap = new HashMap<>();

    // Empty squares have the null gamePiece
    public boardModel() {
        //puts black pieces onto the hashmap
        boardMap.put(new Coordinates(0, 0), new Rook(this, new Coordinates(0, 0)));
        boardMap.put(new Coordinates(0, 1), new Khight(this, new Coordinates(0, 1)));
        boardMap.put(new Coordinates(0, 2), new Bishop(this, new Coordinates(0, 2)));
        boardMap.put(new Coordinates(0, 3), new Queen(this, new Coordinates(0, 3)));
        boardMap.put(new Coordinates(0, 4), new King(this, new Coordinates(0, 4)));
        boardMap.put(new Coordinates(0, 5), new Bishop(this, new Coordinates(0, 5)));
        boardMap.put(new Coordinates(0, 6), new Khight(this, new Coordinates(0, 6)));
        boardMap.put(new Coordinates(0, 7), new Rook(this, new Coordinates(0, 7)));
        for(int i = 0; i < 8; i++) {
            boardMap.put(new Coordinates(1, i), new Pawn(this, new Coordinates(1, i)));
        }

        //puts white pieces onto the hashmap
        boardMap.put(new Coordinates(7, 0), new Rook(this, new Coordinates(7, 0)));
        boardMap.put(new Coordinates(7, 1), new Khight(this, new Coordinates(7, 1)));
        boardMap.put(new Coordinates(7, 2), new Bishop(this, new Coordinates(7, 2)));
        boardMap.put(new Coordinates(7, 3), new Queen(this, new Coordinates(7, 3)));
        boardMap.put(new Coordinates(7, 4), new King(this, new Coordinates(7, 4)));
        boardMap.put(new Coordinates(7, 5), new Bishop(this, new Coordinates(7, 5)));
        boardMap.put(new Coordinates(7, 6), new Khight(this, new Coordinates(7, 6)));
        boardMap.put(new Coordinates(7, 7), new Rook(this, new Coordinates(7, 7)));
        for(int i = 0; i < 8; i++) {
            boardMap.put(new Coordinates(6, i), new Pawn(this, new Coordinates(6, i)));
        }
    }
}

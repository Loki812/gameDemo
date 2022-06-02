package boardGame;

import gamePieces.*;
import javafx.fxml.FXML;


import java.util.*;


public class boardModel  {


    public HashMap<Coordinates, gamePiece> map = new HashMap<>();



    public boardModel() {
        loadData();
    }


    @FXML
    private void loadData() {
        //Black pieces
        for(int i = 0; i < 8; i++) {
            map.put(new Coordinates(1, i), new Pawn(this, new Coordinates(1, i)));
        }
        map.put(new Coordinates(0, 0), new Rook(this, new Coordinates(0,0)));
        map.put(new Coordinates(0, 1), new Khight(this, new Coordinates(0, 1)));
        map.put(new Coordinates(0, 2), new Bishop(this, new Coordinates(0, 2)));
        map.put(new Coordinates(0, 3), new Queen(this, new Coordinates(0, 3)));
        map.put(new Coordinates(0, 4), new King(this, new Coordinates(0, 4)));
        map.put(new Coordinates(0, 5), new Bishop(this, new Coordinates(0, 5)));
        map.put(new Coordinates(0, 6), new Khight(this, new Coordinates(0, 6)));
        map.put(new Coordinates(0, 7), new Rook(this, new Coordinates(0,7)));

        //White pieces
        for(int i = 0; i < 8; i++) {
            map.put(new Coordinates(6, i), new Pawn(this, new Coordinates(6, i)));
        }
        map.put(new Coordinates(7, 0), new Rook(this, new Coordinates(7,0)));
        map.put(new Coordinates(7, 1), new Khight(this, new Coordinates(7, 1)));
        map.put(new Coordinates(7, 2), new Bishop(this, new Coordinates(7, 2)));
        map.put(new Coordinates(7, 3), new Queen(this, new Coordinates(7, 3)));
        map.put(new Coordinates(7, 4), new King(this, new Coordinates(7, 4)));
        map.put(new Coordinates(7, 5), new Bishop(this, new Coordinates(7, 5)));
        map.put(new Coordinates(7, 6), new Khight(this, new Coordinates(7, 6)));
        map.put(new Coordinates(7, 7), new Rook(this, new Coordinates(7,7)));
    }

    public void update(Coordinates old, Coordinates selected) {
        gamePiece gamePiece = map.get(old);
        gamePiece.setCurrentPos(selected);
        map.remove(old);
        map.put(selected, gamePiece);

        map.forEach((key, value) -> (value).generateMoves());
    }
}





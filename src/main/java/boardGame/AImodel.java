package boardGame;

import gamePieces.Coordinates;
import gamePieces.gamePiece;

import java.util.HashMap;

public class AImodel {


    private final boardModel model;

    public AImodel(boardModel model) {
        this.model = model;
    }

    private HashMap<Coordinates, gamePiece> copyMap(HashMap<Coordinates, gamePiece> map) {
        HashMap<Coordinates, gamePiece> newMap = new HashMap<>(32);

        for(int i = 0; i < 8; i++) {
            for(int k = 0; k< 8; k++) {
                if(map.containsKey(new Coordinates(i, k))) {
                    //change this to a deep copy, need new instances of objects
                    newMap.put(new Coordinates(i,k), map.get(new Coordinates(i, k)));
                }
            }
        }
        return newMap;
    }

    private int evalBoard(HashMap<Coordinates, gamePiece> map) {
        int evaluation = 0;
        for(gamePiece g : map.values()) {
            if(g.color) {
                evaluation = evaluation + g.pointValue;
            }
            else {
                evaluation = evaluation - g.pointValue;
            }
        }
        return evaluation;
    }


}

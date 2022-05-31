package gamePieces;

import java.util.ArrayList;
import java.util.Objects;

import boardGame.boardModel;
import javafx.scene.image.ImageView;

public class Khight extends gamePiece{
    public Khight(boardModel model, Coordinates initCoor) {
        super(model, initCoor);
        if(initCoor.row() == 0) {
            color = false;
            image = new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/blackPieces/blackKhight.png")).toExternalForm());
        }
        else if(initCoor.row() == 7) {
            color = true;
            image = new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/whitePieces/whiteKhight.png")).toExternalForm());
        }
    }

    @Override
    public void generateMoves() {
        ArrayList<Coordinates> availableMoves = new ArrayList<>();
        int x = getCurrentPos().col();
        int y = getCurrentPos().row();

        if(y - 2 >= 0 && x - 1 >= 0) {
            if(model.map.containsKey(new Coordinates(y - 2, x - 1))) {
                if(model.map.get(new Coordinates(y - 2, x - 1)).color != this.color) {
                    availableMoves.add(new Coordinates(y - 2, x - 1));
                }
            }
            else {
                availableMoves.add(new Coordinates(y - 2, x - 1));
            }
        }
        if(y - 2 >= 0 && x + 1 < 8) {
            if(model.map.containsKey(new Coordinates(y - 2, x + 1))) {
                if(model.map.get(new Coordinates(y - 2, x + 1)).color != this.color) {
                    availableMoves.add(new Coordinates(y - 2, x + 1));
                }
            }
            else {
                availableMoves.add(new Coordinates(y - 2, x + 1));
            }
        }
        if(y - 1 >= 0 && x + 2 < 8) {
            if(model.map.containsKey(new Coordinates(y - 1, x + 2))) {
                if(model.map.get(new Coordinates(y - 1, x + 2)).color != this.color) {
                    availableMoves.add(new Coordinates(y - 1, x + 2));
                }
            }
            else {
                availableMoves.add(new Coordinates(y - 1, x + 2));
            }
        }
        if(y + 1 < 8 && x + 2 < 8) {
            if(model.map.containsKey(new Coordinates(y + 1, x + 2))) {
                if(model.map.get(new Coordinates(y + 1, x + 2)).color != this.color) {
                    availableMoves.add(new Coordinates(y + 1, x + 2));
                }
            }
            else {
                availableMoves.add(new Coordinates(y + 1, x + 2));
            }
        }
        if(y + 2 < 8 && x + 1 < 8) {
            if(model.map.containsKey(new Coordinates(y + 2, x + 1))) {
                if(model.map.get(new Coordinates(y + 2, x + 1)).color != this.color) {
                    availableMoves.add(new Coordinates(y + 2, x + 1));
                }
            }
            else {
                availableMoves.add(new Coordinates(y + 2, x + 1));
            }
        }
        if(y + 2 < 8 && x - 1 >= 0) {
            if(model.map.containsKey(new Coordinates(y + 2, x - 1))) {
                if(model.map.get(new Coordinates(y + 2, x - 1)).color != this.color) {
                    availableMoves.add(new Coordinates(y + 2, x - 1));
                }
            }
            else {
                availableMoves.add(new Coordinates(y + 2, x - 1));
            }
        }
        if(y + 1 < 8 && x - 2 >= 0) {
            if(model.map.containsKey(new Coordinates(y + 1, x - 2))) {
                if(model.map.get(new Coordinates(y + 1, x - 2)).color != this.color) {
                    availableMoves.add(new Coordinates(y + 1, x - 2));
                }
            }
            else {
                availableMoves.add(new Coordinates(y + 1, x - 2));
            }
        }
        if(y - 1 >= 0 && x - 2 >= 0) {
            if(model.map.containsKey(new Coordinates(y - 1, x - 2))) {
                if(model.map.get(new Coordinates(y - 1, x - 2)).color != this.color) {
                    availableMoves.add(new Coordinates(y - 1, x - 2));
                }
            }
            else {
                availableMoves.add(new Coordinates(y - 1, x - 2));
            }
        }
        setAvailableMoves(availableMoves);
    }


}

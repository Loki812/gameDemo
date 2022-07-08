package gamePieces;

import java.util.ArrayList;
import java.util.Objects;

import boardGame.boardModel;
import javafx.scene.image.ImageView;

public class King extends gamePiece{


    public King(boardModel model, Coordinates initCoor) {
        super(model, initCoor);
        notation = 'K';
        if(initCoor.row() == 0) {
            color = false;
            image = new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/blackPieces/blackKing.png")).toExternalForm());
        }
        else if(initCoor.row() == 7) {
            color = true;
            image = new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/whitePieces/whiteKing.png")).toExternalForm());
        }
    }

    @Override
    public void generateMoves() {
        ArrayList<Coordinates> availableMoves = new ArrayList<>();
        int x = getCurrentPos().col();
        int y = getCurrentPos().row();

        if(x - 1 >= 0) {
            if(model.map.containsKey(new Coordinates(y, x - 1))) {
                if(model.map.get(new Coordinates(y, x - 1)).color != this.color) {
                    availableMoves.add(new Coordinates(y, x - 1));
                }
            }
            else {
                availableMoves.add(new Coordinates(y, x - 1));
            }
        }
        if(x + 1 < 8) {
            if(model.map.containsKey(new Coordinates(y, x + 1))) {
                if(model.map.get(new Coordinates(y, x + 1)).color != this.color) {
                    availableMoves.add(new Coordinates(y, x + 1));
                }
            }
            else {
                availableMoves.add(new Coordinates(y, x + 1));
            }
        }
        if(y + 1 < 8) {
            if(model.map.containsKey(new Coordinates(y + 1, x))) {
                if(model.map.get(new Coordinates(y + 1, x)).color != this.color) {
                    availableMoves.add(new Coordinates(y + 1, x));
                }
            }
            else {
                availableMoves.add(new Coordinates(y + 1, x));
            }
        }
        if(y - 1 >= 0) {
            if(model.map.containsKey(new Coordinates(y - 1, x))) {
                if(model.map.get(new Coordinates(y - 1, x)).color != this.color) {
                    availableMoves.add(new Coordinates(y - 1, x));
                }
            }
            else {
                availableMoves.add(new Coordinates(y - 1, x));
            }
        }

        if(y - 1 >= 0 && x - 1 >= 0) {
            if(model.map.containsKey(new Coordinates(y - 1, x - 1))) {
                if(model.map.get(new Coordinates(y - 1, x - 1)).color != this.color) {
                    availableMoves.add(new Coordinates(y - 1, x - 1));
                }
            }
            else {
                availableMoves.add(new Coordinates(y - 1, x - 1));
            }
        }

        if(y + 1 < 8 && x - 1 >= 0) {
            if(model.map.containsKey(new Coordinates(y + 1, x - 1))) {
                if(model.map.get(new Coordinates(y + 1, x - 1)).color != this.color) {
                    availableMoves.add(new Coordinates(y + 1, x - 1));
                }
            }
            else {
                availableMoves.add(new Coordinates(y + 1, x - 1));
            }
        }

        if(y - 1 >= 0 && x + 1 < 8) {
            if(model.map.containsKey(new Coordinates(y - 1, x + 1))) {
                if(model.map.get(new Coordinates(y - 1, x + 1)).color != this.color) {
                    availableMoves.add(new Coordinates(y - 1, x + 1));
                }
            }
            else {
                availableMoves.add(new Coordinates(y - 1, x + 1));
            }
        }

        if(y + 1 < 8 && x + 1 < 8) {
            if(model.map.containsKey(new Coordinates(y + 1, x + 1))) {
                if(model.map.get(new Coordinates(y + 1, x + 1)).color != this.color) {
                    availableMoves.add(new Coordinates(y + 1, x + 1));
                }
            }
            else {
                availableMoves.add(new Coordinates(y + 1, x + 1));
            }
        }

        setAvailableMoves(availableMoves);
    }


}

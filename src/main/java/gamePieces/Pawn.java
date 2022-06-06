package gamePieces;

import java.util.ArrayList;
import java.util.Objects;

import boardGame.boardModel;
import javafx.scene.image.ImageView;

public class Pawn extends gamePiece{



    public Pawn(boardModel model, Coordinates initCoor) {
        super(model, initCoor);
        notation = '`';
        if(initCoor.row() == 1) {
            color = false;
            image = new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/blackPieces/blackPawn.png")).toExternalForm());
        }
        else if(initCoor.row() == 6) {
            color = true;
            image = new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/whitePieces/whitePawn.png")).toExternalForm());
        }
    }

    //TODO include upgrading to queen etc
    @Override
    public void generateMoves() {
        ArrayList<Coordinates> availableMoves = new ArrayList<>();
        int y = getCurrentPos().row();
        int x = getCurrentPos().col();
        if(!color) {
            if (y == 1) {
                if (!model.map.containsKey(new Coordinates(y + 1, x))) {
                    availableMoves.add(new Coordinates(y + 1, x));
                }
                if (!model.map.containsKey(new Coordinates(y + 2, x))) {
                    availableMoves.add(new Coordinates(y + 2, x));
                }
            }
            else if (y != 7) {
                if (!model.map.containsKey(new Coordinates(y + 1, x))) {
                    availableMoves.add(new Coordinates(y + 1, x));
                }
            }
            if(model.map.containsKey(new Coordinates(y + 1, x - 1))) {
                if(model.map.get(new Coordinates(y + 1, x - 1)).color != this.color) {
                    availableMoves.add(new Coordinates(y + 1, x - 1));
                }
            }
            if(model.map.containsKey(new Coordinates(y + 1, x + 1))) {
                if(model.map.get(new Coordinates(y + 1, x + 1)).color != this.color) {
                    availableMoves.add(new Coordinates(y + 1, x + 1));
                }
            }
        }
        else {
            if (y == 6) {
                if (!model.map.containsKey(new Coordinates(y - 1, x))) {
                    availableMoves.add(new Coordinates(y - 1, x));
                }
                if (!model.map.containsKey(new Coordinates(y - 2, x))) {
                    availableMoves.add(new Coordinates(y - 2, x));
                }
            }
            else if (y != 0) {
                if (model.map.containsKey(new Coordinates(y - 1, x))) {
                    availableMoves.add(new Coordinates(y - 1, x));
                }
            }
            if(model.map.containsKey(new Coordinates(y - 1, x - 1))) {
                if(model.map.get(new Coordinates(y - 1, x - 1)).color != this.color) {
                    availableMoves.add(new Coordinates(y - 1, x - 1));
                }
            }
            if(model.map.containsKey(new Coordinates(y - 1, x + 1))) {
                if(model.map.get(new Coordinates(y - 1, x + 1)).color != this.color) {
                    availableMoves.add(new Coordinates(y - 1, x + 1));
                }
            }

        }
        setAvailableMoves(availableMoves);
    }
}

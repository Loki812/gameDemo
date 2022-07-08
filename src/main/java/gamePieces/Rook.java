package gamePieces;

import java.util.ArrayList;
import java.util.Objects;

import boardGame.boardModel;
import javafx.scene.image.ImageView;

public class Rook extends gamePiece{

    public Rook(boardModel model, Coordinates initCoor) {
        super(model, initCoor);
        if(initCoor.row() == 0) {
            color = false;
            image = new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/blackPieces/blackRook.png")).toExternalForm());
        }
        else if(initCoor.row() == 7) {
            color = true;
            image = new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/whitePieces/whiteRook.png")).toExternalForm());
        }
    }



    @Override
    public void generateMoves() {
        ArrayList<Coordinates> availableMoves = new ArrayList<>();
        int x = getCurrentPos().col();
        int y = getCurrentPos().row();
        notation = 'R';
        //adds move's to the north
        int i = 1;
        while (y - i >= 0) {
            if(model.map.containsKey(new Coordinates(y- i, x))) {
                if(model.map.get(new Coordinates(y - i, x)).color != this.color) {
                    availableMoves.add(new Coordinates(y - i, x));
                }
                break;
            }
            availableMoves.add(new Coordinates(y - i, x));
            i++;
        }
        //adds move's to the west
        i = 1;
        while (x - i >= 0) {
            if(model.map.containsKey(new Coordinates(y, x - i))) {
                if(model.map.get(new Coordinates(y, x - i)).color != this.color) {
                    availableMoves.add(new Coordinates(y, x - i));
                }
                break;
            }
            availableMoves.add(new Coordinates(y, x - i));
            i++;
        }
        //adds move's to the south
        i = 1;
        while(y + i < 8) {
            if(model.map.containsKey(new Coordinates(y + i, x))) {
                if(model.map.get(new Coordinates(y + i, x)).color != this.color) {
                    availableMoves.add(new Coordinates(y + i, x));
                }
                break;
            }
            availableMoves.add(new Coordinates(y + i, x));
            i++;
        }
        //adds move's to the east
        i = 1;
        while(x + i < 8) {
            if(model.map.containsKey(new Coordinates(y, x + i))) {
                if(model.map.get(new Coordinates(y, x + i)).color != this.color) {
                    availableMoves.add(new Coordinates(y, x + i));
                }
                break;
            }
            availableMoves.add(new Coordinates(y, x + i));
            i++;
        }

        setAvailableMoves(availableMoves);
    }


}

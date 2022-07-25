package gamePieces;

import java.util.ArrayList;
import java.util.Objects;

import boardGame.boardModel;
import javafx.scene.image.ImageView;

public class Bishop extends gamePiece{

    public Bishop(boardModel model, Coordinates initCoor) {
        super(model, initCoor);
        notation = 'B';
        pointValue = 3;
        if(initCoor.row() == 0) {
            color = false;
            image = new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/blackPieces/blackBishop.png")).toExternalForm());
        }
        else if(initCoor.row() == 7) {
            color = true;
            image = new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/whitePieces/whiteBishop.png")).toExternalForm());
        }

    }

    @Override
    public void generateMoves() {
        ArrayList<Coordinates> availableMoves = new ArrayList<>();
        int x = getCurrentPos().col();
        int y = getCurrentPos().row();

        // builds moves to northwest diagonally
        while (x >= 0 && y >= 0) {
            if(!new Coordinates(y, x).equals(getCurrentPos()) && model.map.containsKey(new Coordinates(y, x))) {
                if(model.map.get(new Coordinates(y, x)).color != this.color) {
                    availableMoves.add(new Coordinates(y, x));
                }
                break;
            }
            if(!new Coordinates(y, x).equals(getCurrentPos())) {
                availableMoves.add(new Coordinates(y, x));
            }
            x--;
            y--;
        }
        //builds moves to the northeast diagonally
        x = getCurrentPos().col();
        y = getCurrentPos().row();
        while(x < 8 && y >= 0) {
            if(!new Coordinates(y, x).equals(getCurrentPos()) && model.map.containsKey(new Coordinates(y, x))) {
                if(model.map.get(new Coordinates(y, x)).color != this.color) {
                    availableMoves.add(new Coordinates(y, x));
                }
                break;
            }
            if(!new Coordinates(y, x).equals(getCurrentPos())) {
                availableMoves.add(new Coordinates(y, x));
            }
            x++;
            y--;
        }
        //builds moves to the southeast
        x = getCurrentPos().col();
        y = getCurrentPos().row();
        while(x < 8 && y < 8) {
            if(!new Coordinates(y, x).equals(getCurrentPos()) && model.map.containsKey(new Coordinates(y, x))) {
                if(model.map.get(new Coordinates(y, x)).color != this.color) {
                    availableMoves.add(new Coordinates(y, x));
                }
                break;
            }
            if(!new Coordinates(y, x).equals(getCurrentPos())) {
                availableMoves.add(new Coordinates(y, x));
            }
            x++;
            y++;
        }
        //builds moves to the southwest
        x = getCurrentPos().col();
        y = getCurrentPos().row();
        while(x >= 0 && y < 8) {
            if(!new Coordinates(y, x).equals(getCurrentPos()) && model.map.containsKey(new Coordinates(y, x))) {
                if(model.map.get(new Coordinates(y, x)).color != this.color) {
                    availableMoves.add(new Coordinates(y, x));
                }
                break;
            }
            if(!new Coordinates(y, x).equals(getCurrentPos())) {
                availableMoves.add(new Coordinates(y, x));
            }
            x--;
            y++;
        }

        setAvailableMoves(availableMoves);
    }
}

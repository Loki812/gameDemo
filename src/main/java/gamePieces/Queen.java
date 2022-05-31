package gamePieces;

import java.util.ArrayList;
import java.util.Objects;

import boardGame.boardModel;
import javafx.scene.image.ImageView;

public class Queen extends gamePiece{

    public Queen(boardModel model, Coordinates initCoor) {
        super(model, initCoor);
        if(initCoor.row() == 0) {
            color = false;
            image = new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/blackPieces/blackQueen.png")).toExternalForm());
        }
        else if(initCoor.row() == 7) {
            color = true;
            image = new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/whitePieces/whiteQueen.png")).toExternalForm());
        }
    }

    @Override
    public void generateMoves() {
        ArrayList<Coordinates> availableMoves = new ArrayList<>();
        //creates moves to the north of the queen
        for(int i = getCurrentPos().row(); i >= 0; i--) {
            if(model.map.containsKey(new Coordinates(i, getCurrentPos().col()))) {
                if(model.map.get(new Coordinates(i, getCurrentPos().col())).color != this.color) {
                    availableMoves.add(new Coordinates(i, getCurrentPos().col()));
                }
                break;
            }
            else {
                availableMoves.add(new Coordinates(i, getCurrentPos().col()));
            }
        }
        //creates the moves to the south of the queen
        for(int i = getCurrentPos().row(); i < 8; i++) {
            if(model.map.containsKey(new Coordinates(i, getCurrentPos().col()))) {
                if(model.map.get(new Coordinates(i, getCurrentPos().col())).color != this.color) {
                    availableMoves.add(new Coordinates(i, getCurrentPos().col()));
                }
                break;
            }
            else {
                availableMoves.add(new Coordinates(i, getCurrentPos().col()));
            }
        }
        //creates the moves to the east of the queen
        for(int x = getCurrentPos().col(); x < 8; x++) {
            if(model.map.containsKey(new Coordinates(getCurrentPos().row(), x))) {
                if(model.map.get(new Coordinates(getCurrentPos().row(), x)).color != this.color) {
                    availableMoves.add(new Coordinates(getCurrentPos().row(), x));
                }
                break;
            }
            else {
                availableMoves.add(new Coordinates(getCurrentPos().row(), x));
            }
        }
        //creates the moves to the west of the queen
        for(int x = getCurrentPos().col(); x >= 0; x--) {
            if(model.map.containsKey(new Coordinates(getCurrentPos().row(), x))) {
                if(model.map.get(new Coordinates(getCurrentPos().row(), x)).color != this.color) {
                    availableMoves.add(new Coordinates(getCurrentPos().row(), x));
                }
                break;
            }
            else {
                availableMoves.add(new Coordinates(getCurrentPos().row(), x));
            }
        }

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
        availableMoves.remove(getCurrentPos());
        setAvailableMoves(availableMoves);
    }
}

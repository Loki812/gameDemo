package gamePieces;

import java.util.ArrayList;
import java.util.Objects;

import boardGame.boardModel;
import javafx.scene.image.ImageView;

public class Queen extends gamePiece{

    public Queen(boardModel model, Coordinates initCoor) {
        super(model, initCoor);
        notation = 'Q';
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
        int x = getCurrentPos().col();
        int y = getCurrentPos().row();

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

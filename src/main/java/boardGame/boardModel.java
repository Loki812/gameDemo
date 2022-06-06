package boardGame;

import com.sun.javafx.scene.control.LabeledText;
import gamePieces.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


import java.util.*;


public class boardModel  {


    public HashMap<Coordinates, gamePiece> map = new HashMap<>();

    private HashMap<Integer, Character> notationMap = new HashMap<>();
    private final boardView view;

    private ArrayList<String> disPrevMoves = new ArrayList<>();

    private enum gameState {
        WHITEMOVE,
        BLACKMOVE,
        WHITECHECK,
        BLACKCHECK,
        GAMEOVER;
    }
    gameState state;



    public boardModel(boardView view) {
        loadData();
        state = gameState.BLACKMOVE;
        this.view = view;
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

        //for the notation map
        notationMap.put(0, 'a');
        notationMap.put(1, 'b');
        notationMap.put(2, 'c');
        notationMap.put(3, 'd');
        notationMap.put(4, 'e');
        notationMap.put(5, 'f');
        notationMap.put(6, 'g');
        notationMap.put(7, 'h');

    }

    public void update(Coordinates old, Coordinates selected) {
        updatePrevMoves(old, selected);
        //deals with the possibility of a capture//
        captured(selected);
        //refreshes the board as normal//
        gamePiece gamePiece = map.get(old);
        gamePiece.setCurrentPos(selected);
        map.remove(old);
        map.put(selected, gamePiece);
        view.refresh();
        //***************************//
        if(state == gameState.WHITEMOVE) {
            for (gamePiece g : map.values()) {
                if (g.color) {
                    g.generateMoves();
                } else {
                    g.setAvailableMoves(new ArrayList<>());
                }
            }
            state = gameState.BLACKMOVE;
        }
        else if(state == gameState.BLACKMOVE) {
            for (gamePiece g : map.values()) {
                if (!g.color) {
                    g.generateMoves();
                } else {
                    g.setAvailableMoves(new ArrayList<>());
                }
            }
            state = gameState.WHITEMOVE;
        }
    }


    private void updatePrevMoves(Coordinates old, Coordinates selected) {
        StringBuilder builder = new StringBuilder();
        gamePiece game = map.get(old);
        if(!(game instanceof Pawn)) {
            builder.append(game.notation);
        }
        if(map.containsKey(selected)) {
            builder.append('x');
        }
        builder.append(notationMap.get(selected.col()));
        builder.append(8 - selected.row());
        disPrevMoves.add(builder.toString());

        //***** actually changes the view to display the previous moves *****//
        view.prevMoves.getChildren().clear();
        int x = 0;
        int y = 0;
        for(String s : disPrevMoves) {
            view.prevMoves.add(createPrevMoveLabel(s), x, y);
            if(x == 1) {
                x = 0;
                y++;
            }
            else {
                x++;
            }
        }

    }

    private Label createPrevMoveLabel(String s) {
        Label l = new Label(s);
        l.setScaleX(2);
        l.setScaleY(2);
        l.autosize();
        l.setFont(Font.font("Impact"));
        return l;
    }

    private void captured(Coordinates c) {
        if(map.containsKey(c)) {
            gamePiece game = map.get(c);
            game.setCurrentPos(new Coordinates(-99, -99));
            game.image.setFitWidth(50);
            game.image.setFitHeight(50);
            map.remove(c);
            if(game.color) {
                view.whiteCap.getChildren().add(game.image);
            }
            else {
                view.blackCap.getChildren().add(game.image);
            }
        }
    }
}





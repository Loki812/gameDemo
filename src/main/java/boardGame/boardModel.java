package boardGame;


import gamePieces.*;
import javafx.fxml.FXML;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


import java.awt.*;
import java.util.*;


public class boardModel  {

    //*** States of the model ***//

    /**
     * The blueprint of the chess board, maps coordinates on the board to gamePiece objects.
     *
     * ex. Coordinate (0,0) -> Black Rook
     */
    public HashMap<Coordinates, gamePiece> map = new HashMap<>();

    /**
     * Used to 'link' the model and view
     * so the model can call the view's refresh() function
     *
     * *also added linking for the display of previous moves*
     */
    private final boardView view;

    /** Just used for creating move names ex. column 0 -> 'a' column */
    private final HashMap<Integer, Character> notationMap = new HashMap<>();

    /** Displays the previous moves by players dynamically, so when it reaches move ~20, it will remove
     * the oldest moves from the array.
     *
     * - This should later be changed, so it does not remove Strings past twenty, by implementing a scrollPane -
     */
    public final ArrayList<String> disPrevMoves = new ArrayList<>();

    private final ArrayList<gamePiece> whiteCapPieces = new ArrayList<>();

    private final ArrayList<gamePiece> blackCapPieces = new ArrayList<>();


    /**
     * True for white, false for black
     */
    private boolean state;


    public ArrayList<gamePiece> getWhiteCapPieces() {
        return whiteCapPieces;
    }

    public ArrayList<gamePiece> getBlackCapPieces() {
        return blackCapPieces;
    }


    //**************************************//

    public boardModel(boardView view) {
        loadData();
        state = true;
        for(gamePiece g : map.values()) {
            if(g.color == state) {
                g.generateMoves();
            }
        }

        this.view = view;
    }

    //*** Functions of the model ***//

    /**
     * Fills the map and notationMap state with (Key, Value) pairs.
     *
     * is called @FXML, so it gets called before the app initializes
     */
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

    /**
     * Called when a played clicks on one of the opaque 'available move' buttons
     * on the screen. After doing so a few things happen,
     *
     * 1. The previous moves board to the right adds on the move chosen by the player
     *
     * 2. It edits the map state to reflect the changed board
     *
     * 3. It changes the state of the game so that the other players moves are generated
     *
     * @param old The coordinates of the gamePiece object selected
     * @param selected The coordinates of the availableMove that the player selected
     */
    public void update(Coordinates old, Coordinates selected) {
        updatePrevMoves(old, selected);
        //deals with the possibility of a capture//
        captured(selected);
        //refreshes the board as normal//
        gamePiece gamePiece = map.get(old);
        gamePiece.setCurrentPos(selected);
        map.remove(old);
        map.put(selected, gamePiece);
        //new code goes here
        if(checkForCheck()) {
            map.remove(selected);
            map.put(old, gamePiece);
            gamePiece.setCurrentPos(old);
        }
        else {
            view.refresh();
            if(checkForGameOver()) {
                if(state) {
                    view.blackCap.getChildren().clear();
                    Text winText = new Text("White Wins!!!");
                    winText.setFont(new Font("Impact", 50));
                    view.blackCap.getChildren().add(winText);
                }
                else {
                    view.whiteCap.getChildren().clear();
                    Text winText = new Text("Black Wins!!!");
                    winText.setFont(new Font("Impact", 50));
                    view.whiteCap.getChildren().add(winText);
                }
                for(gamePiece g : map.values()) {
                    g.setAvailableMoves(new ArrayList<>());
                }
            }
            else {
                state = !state;
                for (gamePiece g : map.values()) {
                    if (g.color == state) {
                        g.generateMoves();
                    } else {
                        g.setAvailableMoves(new ArrayList<>());
                    }
                }
            }
        }
    }



    private Coordinates getKingsCoordinates() {
        boolean color = state;

        for(gamePiece g : map.values()) {
            if(g instanceof King && g.color == color) {
                return g.getCurrentPos();
            }
        }
        return null;
    }

    private Coordinates getOppKingsCoordinates() {
        boolean color = !state;

        for(gamePiece g : map.values()) {
            if(g instanceof King && g.color == color) {
                return g.getCurrentPos();
            }
        }
        return null;
    }

    private boolean checkForCheck() {
        boolean color = state;
        Coordinates kingsCoor = getKingsCoordinates();
        for(gamePiece g : map.values()) {
            if(g.color != color) {
                g.generateMoves();
                for(Coordinates c : g.getAvailableMoves()) {
                    if(c.equals(kingsCoor)) {

                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkForOppCheck() {
        boolean color = !state;
        Coordinates kingsCoor = getOppKingsCoordinates();
        for(gamePiece g : map.values()) {
            if(g.color != color) {
                g.generateMoves();
                for(Coordinates c : g.getAvailableMoves()) {
                    if(c.equals(kingsCoor)) {

                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * Starts off by creating a StringBuilder object to store the move name,
     * then accesses the gamePiece objects notation state,
     * then checks if it is capturing another piece by seeing if the model.map contains the selected coordinate,
     * then runs the column number of the old Coordinate through the notationMap to get a letter a-h
     * then takes 8 minus the row number.
     *
     * You should end up with a string like Bc6, or Nc5, or e4, or Qxe5
     *
     * lastly it adds it to the arraylist of disPrevMoves.
     * @param old The coordinates of the gamePiece that was selected by the player
     * @param selected The coordinates of the available move that was selected by the player
     */
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

    }


    /**All moves are passed through this function, if a piece is captured during this move
     * it updates the model.map and then places the piece in the blackCap or whiteCap depending on
     * the color of the piece
     *
     */
    private void captured(Coordinates c) {
        if(map.containsKey(c)) {
            gamePiece game = map.get(c);
            game.setCurrentPos(new Coordinates(-99, -99));
            game.image.setFitWidth(50);
            game.image.setFitHeight(50);
            map.remove(c);
            if(game.color) {
                whiteCapPieces.add(game);
            }
            else {
                blackCapPieces.add(game);
            }
        }
    }


    public boolean checkForGameOver() {
       gamePiece king = map.get(getOppKingsCoordinates());
       king.generateMoves();
       Coordinates oldPos = king.getCurrentPos();
       if(king.getAvailableMoves().size() == 0) {
           return checkForOppCheck();
       }
       else {
           for (Coordinates c : king.getAvailableMoves()) {
               map.remove(oldPos);
               map.put(c, king);
               king.setCurrentPos(c);
               if (!checkForOppCheck()) {
                   map.remove(c);
                   map.put(oldPos, king);
                   king.setCurrentPos(oldPos);
                   return false;
               }
               map.remove(c);
               map.put(oldPos, king);
               king.setCurrentPos(oldPos);
           }
           return true;
       }
    }
    //*****************************//
}


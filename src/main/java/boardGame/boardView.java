package boardGame;


import gamePieces.Coordinates;
import gamePieces.gamePiece;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.Objects;



public class boardView extends Application  {

//**************** Declaration of private states **************//



    /** A box at the bottom of the screen to display what pieces White has captured */
    private final HBox whiteCap = makeWhiteCap();

    /** A box at the top of the screen to display what pieces Black has captured */
    private final HBox blackCap = makeBlackCap();

    /** Makes the Chess board the game is played on */
    private final GridPane board = makeBoard();

    /** Makes the previous moves section that is to the right of the board */
    private final VBox prevMoves = makePrevMoves();

    /** The logic backend of the chessGame */
    @FXML
    private boardModel model;

    

    /** just an array of the 'same' imageview to make for easy removal off the grid pane */
    private final ArrayList<ImageView> arrAvailMoves = buildAvailMoves();


//***********************************************************//


//********************** Styles the screen *******************//

    private GridPane makeBoard()  {
        GridPane board = new GridPane();

        // Make & set the background
        BackgroundImage image = new BackgroundImage(new Image(Objects.requireNonNull(getClass().getResource(
                "/Resources/board.png")).toExternalForm()),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(740, 740, false, false, true, false));

        board.setBackground(new Background(image));
        board.setPrefWidth(740);
        board.setPrefHeight(740);

        board.setHgap(19);

        for(int i = 0; i < 8; i++) {
            board.getRowConstraints().add(new RowConstraints(92));
        }

        board.setPadding(new Insets(0, 0, 0, 7));






        return board;
    }

    private HBox makeWhiteCap() {
        HBox whiteCap = new HBox();

        BackgroundImage image = new BackgroundImage(new Image(Objects.requireNonNull(getClass().getResource(
                "/Resources/captured.png")).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(100, 740, false, false, true, false));
        whiteCap.setBackground(new Background(image));
        whiteCap.setPrefHeight(100);
        whiteCap.setPrefWidth(740);

        return whiteCap;
    }


    private HBox makeBlackCap() {
        HBox blackCap = new HBox();

        BackgroundImage image = new BackgroundImage(new Image(Objects.requireNonNull(getClass().getResource(
                "/Resources/captured.png")).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(100, 740, false, false, true, false));
        blackCap.setBackground(new Background(image));
        blackCap.setPrefHeight(100);
        blackCap.setPrefWidth(740);
        return blackCap;
    }


    private VBox makePrevMoves() {
        VBox prevMove = new VBox();

        BackgroundImage image = new BackgroundImage(new Image(Objects.requireNonNull(getClass().getResource(
                "/Resources/prevMove.png")).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(940, 200, false, false, true, false));
        prevMove.setBackground(new Background(image));
        prevMove.setPrefHeight(940);
        prevMove.setPrefWidth(200);
        return prevMove;
    }

    private void addPieces() {
        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                if(model.map.containsKey(new Coordinates(x, y))) {
                    board.add(model.map.get(new Coordinates(x, y)).image, y, x);
                }
            }
        }
    }

    private ArrayList<ImageView> buildAvailMoves() {
        ArrayList<ImageView> arr = new ArrayList<>();
        for(int i = 0; i < 32; i++) {
            arr.add(new ImageView(Objects.requireNonNull(getClass().getResource(
                    "/Resources/availMove.png")).toExternalForm()));
        }
        return arr;
    }



//********************** Setting actions of pieces *****************//

    private void addEvents() {
        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                if(model.map.containsKey(new Coordinates(x, y))) {
                    addMoves(model.map.get(new Coordinates(x, y)));
                }
            }
        }
    }


    private void addMoves(gamePiece gamePiece) {
        gamePiece.generateMoves();
        gamePiece.image.setOnMouseClicked(event -> {

            for(ImageView view : arrAvailMoves) {
                if(board.getChildren().contains(view)) {
                        board.getChildren().remove(view);
                }
                else {
                    break;
                }
            }

            for (int i = 0; i < gamePiece.getAvailableMoves().size(); i++) {
                board.add( arrAvailMoves.get(i),gamePiece.getAvailableMoves().get(i).col(),
                        gamePiece.getAvailableMoves().get(i).row());
            }

        });
    }






//******************************Initialization**********************//
    @Override
    public void start(Stage stage) {
        initializeModel();
        addPieces();
        addEvents();
        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(board);
        borderpane.setTop(whiteCap);
        borderpane.setBottom(blackCap);
        ImageView imageView = new ImageView(Objects.requireNonNull(getClass().getResource("/Resources/sidePiece.jpg")).toExternalForm());
        imageView.setFitWidth(15);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(imageView, borderpane, prevMoves);
        hBox.setPrefWidth(955);
        Scene scene = new Scene(hBox);
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {launch();}

    @FXML
    private void initializeModel() {
        model = new boardModel();
    }


//*********************************************************//
}

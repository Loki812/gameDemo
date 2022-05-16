package boardGame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class boardView extends Application {

//**************** Declaration of private states **************//
    private HBox whiteCap = makeWhiteCap();

    private HBox blackCap = makeBlackCap();


    private GridPane board = makeBoard();


    private VBox prevMoves = makePrevMoves();

//***********************************************************//


//********************** Styles the screen *******************//
    private GridPane makeBoard()  {
        GridPane board = new GridPane();

        // Make & set the background
        BackgroundImage image = new BackgroundImage(new Image(getClass().getResource("/Resources/board.png").toExternalForm()),
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

        // Put pieces on board in initial positions
        board.add(new ImageView(getClass().getResource("/Resources/blackPieces/blackRook.png").toExternalForm()), 0, 0);
        board.add(new ImageView(getClass().getResource("/Resources/blackPieces/blackKhight.png").toExternalForm()), 1, 0);
        board.add(new ImageView(getClass().getResource("/Resources/blackPieces/blackBishop.png").toExternalForm()), 2, 0);
        board.add(new ImageView(getClass().getResource("/Resources/blackPieces/blackQueen.png").toExternalForm()), 3, 0);
        board.add(new ImageView(getClass().getResource("/Resources/blackPieces/blackKing.png").toExternalForm()), 4, 0);
        board.add(new ImageView(getClass().getResource("/Resources/blackPieces/blackBishop.png").toExternalForm()), 5, 0);
        board.add(new ImageView(getClass().getResource("/Resources/blackPieces/blackKhight.png").toExternalForm()), 6, 0);
        board.add(new ImageView(getClass().getResource("/Resources/blackpieces/blackRook.png").toExternalForm()), 7, 0);
        for (int i = 0; i < 8; i++) {
            board.add(new ImageView(getClass().getResource("/Resources/blackPieces/blackPawn.png").toExternalForm()), i, 1);
        }
        for (int i = 0; i < 8; i++) {
            board.add(new ImageView(getClass().getResource("/Resources/whitePieces/whitePawn.png").toExternalForm()), i, 6);
        }
        board.add(new ImageView(getClass().getResource("/Resources/whitePieces/whiteRook.png").toExternalForm()), 0, 7);
        board.add(new ImageView(getClass().getResource("/Resources/whitePieces/whiteKhight.png").toExternalForm()), 1, 7);
        board.add(new ImageView(getClass().getResource("/Resources/whitePieces/whiteBishop.png").toExternalForm()), 2, 7);
        board.add(new ImageView(getClass().getResource("/Resources/whitePieces/whiteKing.png").toExternalForm()), 3, 7);
        board.add(new ImageView(getClass().getResource("/Resources/whitePieces/whiteQueen.png").toExternalForm()), 4, 7);
        board.add(new ImageView(getClass().getResource("/Resources/whitePieces/whiteBishop.png").toExternalForm()), 5, 7);
        board.add(new ImageView(getClass().getResource("/Resources/whitePieces/whiteKhight.png").toExternalForm()), 6, 7);
        board.add(new ImageView(getClass().getResource("/Resources/whitePieces/whiteRook.png").toExternalForm()), 7, 7);



        return board;
    }


    private HBox makeWhiteCap() {
        HBox whiteCap = new HBox();

        BackgroundImage image = new BackgroundImage(new Image(getClass().getResource(
                "/Resources/captured.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(100, 740, false, false, true, false));
        whiteCap.setBackground(new Background(image));
        whiteCap.setPrefHeight(100);
        whiteCap.setPrefWidth(740);

        return whiteCap;
    }


    private HBox makeBlackCap() {
        HBox blackCap = new HBox();

        BackgroundImage image = new BackgroundImage(new Image(getClass().getResource(
                "/Resources/captured.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(100, 740, false, false, true, false));
        blackCap.setBackground(new Background(image));
        blackCap.setPrefHeight(100);
        blackCap.setPrefWidth(740);
        return blackCap;
    }


    private VBox makePrevMoves() {
        VBox prevMove = new VBox();

        BackgroundImage image = new BackgroundImage(new Image(getClass().getResource(
                "/Resources/prevMove.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(940, 200, false, false, true, false));
        prevMove.setBackground(new Background(image));
        prevMove.setPrefHeight(940);
        prevMove.setPrefWidth(200);
        return prevMove;
    }




//***********************************************************//
    @Override
    public void start(Stage stage) throws Exception {

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(board);
        borderpane.setTop(whiteCap);
        borderpane.setBottom(blackCap);

        ImageView imageView = new ImageView(getClass().getResource("/Resources/sidePiece.jpg").toExternalForm());
        imageView.setFitWidth(15);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(imageView, borderpane, prevMoves);
        hBox.setPrefWidth(955);
        Scene scene = new Scene(hBox);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {launch();}
}

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.sql.Time;

/**
 * Created by 万运泽 on 2018/1/17.
 */
public class Javafx_BasicPlayStyle extends Application {
    private static final int VIEWER_Width = 1200;
    private static final int VIEWER_Height = 900;
    private static final String URI_BASE = "Image/";
    private final Group root = new Group();
    private final Group background = new Group();
    private boolean toggleBlack = true;
    private String placementsBlack = "";
    private String placementsWhite = "";
    private int tmp = 60;

    private void setup(){
        board b = new board();
        background.getChildren().add(b);
        Clock c = new Clock();
        background.getChildren().add(c);
    }

    private String locationToString(double x, double y){
        double startX = 24;
        double startY = 25;
        char startLetter = 'A';
        int startNumber = 1;
        double space = 58;

        while (startLetter <'O') {
            if (x == startX) {
                break;
            }else{
                startLetter++;
                startX += space;
            }
        }

        while (startNumber <15) {
            if (y == startY) {
                break;
            }else{
                startNumber++;
                startY += space;
            }
        }
        return startLetter + "" + startNumber;
    }

    class board extends ImageView {
        board(){
            if (tmp == 58) {
                Label a = new Label("HEHE");
                a.setFont(javafx.scene.text.Font.font(60));
                a.setTranslateY(100);
                a.setTranslateX(1050);
                root.getChildren().add(a);
            }

            setImage(new Image(Javafx_BasicPlayStyle.class.getResource(URI_BASE + "棋盘"+".jpg").toString()));
            setFitHeight(900);
            setFitWidth(900);

            Image whiteBoxImage = (new Image(Javafx_BasicPlayStyle.class.getResource(URI_BASE + "白棋盒" + ".png").toString()));
            ImageView whiteBox = new ImageView();
            whiteBox.setImage(whiteBoxImage);
            whiteBox.setTranslateX(950);
            whiteBox.setTranslateY(500);
            whiteBox.setFitHeight(150);
            whiteBox.setFitWidth(150);
            root.getChildren().add(whiteBox);

            Image blackBoxImage = (new Image(Javafx_BasicPlayStyle.class.getResource(URI_BASE + "黑棋盒" + ".png").toString()));
            ImageView blackBox = new ImageView();
            blackBox.setImage(blackBoxImage);
            blackBox.setTranslateX(950);
            blackBox.setTranslateY(275);
            blackBox.setFitHeight(150);
            blackBox.setFitWidth(150);

            Image blackTurnImage = (new Image(Javafx_BasicPlayStyle.class.getResource(URI_BASE + "黑棋回合" + ".png").toString()));
            ImageView blackTurn = new ImageView();
            blackTurn.setImage(blackTurnImage);
            blackTurn.setTranslateX(950);
            blackTurn.setTranslateY(225);
            blackTurn.setFitHeight(200);
            blackTurn.setFitWidth(200);
            root.getChildren().add(blackTurn);

            Image whiteTurnImage = (new Image(Javafx_BasicPlayStyle.class.getResource(URI_BASE + "白棋回合" + ".png").toString()));
            ImageView whiteTurn = new ImageView();
            whiteTurn.setImage(whiteTurnImage);
            whiteTurn.setTranslateX(950);
            whiteTurn.setTranslateY(500);
            whiteTurn.setFitHeight(200);
            whiteTurn.setFitWidth(200);

            setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY){
                    double x = event.getSceneX()-20;
                    double y = event.getSceneY()-20;
                    final double deviation = 10;
                    final double boundary = 840;
                    final double space = 58;
                    final double pieceSize = 40;
                    double startX = 24;
                    double startY = 25;
                    Image pieceImageBlack = (new Image(Javafx_BasicPlayStyle.class.getResource(URI_BASE + "棋子黑" + ".png").toString()));
                    ImageView pieceBlack = new ImageView();
                    root.getChildren().add(pieceBlack);

                    Image pieceImageWhite = (new Image(Javafx_BasicPlayStyle.class.getResource(URI_BASE + "棋子白" + ".png").toString()));
                    ImageView pieceWhite = new ImageView();
                    root.getChildren().add(pieceWhite);

                    while (startY <= boundary) {
                        while (startX <= boundary) {
                            if ((x <= startX + deviation && x >= startX - deviation) && (y <= startY + deviation && y >= startY - deviation)) {
                                tmp = 61;
                                if (toggleBlack) {
                                    placementsBlack += (locationToString(startX,startY) + "_");
                                    // black turn, next it's white hence false
                                    toggleBlack = false;
                                    //setup black pieces
                                    pieceBlack.setImage(pieceImageBlack);
                                    pieceBlack.setTranslateX(startX);
                                    pieceBlack.setTranslateY(startY);
                                    pieceBlack.setFitHeight(pieceSize);
                                    pieceBlack.setFitWidth(pieceSize);

                                    root.getChildren().removeAll(blackTurn);
                                    root.getChildren().removeAll(whiteBox);
                                    root.getChildren().add(whiteTurn);
                                    root.getChildren().add(blackBox);
                                }else{
                                    placementsWhite += locationToString(startX,startY) +  "_";
                                    pieceWhite.setImage(pieceImageWhite);
                                    pieceWhite.setTranslateX(startX);
                                    pieceWhite.setTranslateY(startY);
                                    pieceWhite.setFitHeight(pieceSize);
                                    pieceWhite.setFitWidth(pieceSize);

                                    root.getChildren().removeAll(whiteTurn);
                                    root.getChildren().removeAll(blackBox);
                                    root.getChildren().add(blackTurn);
                                    root.getChildren().add(whiteBox);

                                    toggleBlack = true;
                                }
                            }
                            startX += space;
                        }
                        startX = 24;
                        startY += 58;
                    }
                }
            });
        }

    }

    public class Clock extends Pane {
        private Timeline animation;
        private String S = "";

        Label label = new Label("60");


        private Clock() {
            label.setFont(javafx.scene.text.Font.font(40));
            label.setTranslateX(1030);
            label.setTranslateY(35);

            getChildren().add(label);
            animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> timelabel()));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();
        }

        private void timelabel() {
            if (tmp > 0) {
                tmp--;
            }
            S = tmp + "";
            label.setText(S);
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(root,VIEWER_Width,VIEWER_Height);
        root.getChildren().add(background);
        setup();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

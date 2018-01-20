import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

/**
 * Created by 万运泽 on 2018/1/17.
 */
public class Javafx_BasicPlayStyle extends Application {
    private static final int VIEWER_WIDTH = 900;
    private static final int VIEWER_HEIGHT = 900;
    private static final String URI_BASE = "Image/";
    private final Group root = new Group();
    private final Group background = new Group();

    public void setup(){
        board b = new board();
        background.getChildren().add(b);
    }
    
    class board extends ImageView{
        board(){
            setImage(new Image(Javafx_BasicPlayStyle.class.getResource(URI_BASE + "board"+".jpg").toString()));
            setFitHeight(900);
            setFitWidth(900);
            setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY){
                    double x = event.getSceneX();
                    double y = event.getSceneY();
                    ImageView piece = new ImageView(new Image(Javafx_BasicPlayStyle.class.getResource(URI_BASE + "piece"+".png").toString()));
                    piece.setTranslateX(x);
                    piece.setTranslateY(y);
                }
            });
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(root,VIEWER_HEIGHT,VIEWER_WIDTH);
        root.getChildren().add(background);
        setup();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

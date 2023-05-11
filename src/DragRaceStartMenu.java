import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.util.*;
import Classes.GridBuilder;
import Classes.SpawnPlayer;
import Classes.Collision;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class DragRaceStartMenu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private void playBackgroundMusic() {
        String musicFile = "src/intro.mp3";
        Media backgroundMusic = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(backgroundMusic);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Rhode Runna");

        Text title = new Text("Rhode Runna");
        title.setFont(Font.font("Impact", 85));
        title.setFill(Color.WHITE);

        Button startButton = new Button("Start Game");
        startButton.setOnAction(event -> {
            playBackgroundMusic();
            // Code to start the game goes here
            // public class test extends Application {

            // public static void main(String[] args) {
            // Application.launch(args);
            // }

            // @Override
            // public void start(Stage primaryStage) throws Exception {
            Stage stage = new Stage();
            Group root = new Group();
            Scene scene = new Scene(root, Color.BLACK); // Color.rgb(55, 209, 31)

            Image icon = new Image("Images/RoadRunnerLogo.png");
            stage.getIcons().add(icon);
            stage.setTitle("Rhode Runna");

            stage.setWidth(750);
            stage.setHeight(750);

            // Title
            Text displayTitle = new Text();
            displayTitle.setText("Rhode Runna");
            displayTitle.setX(20);
            displayTitle.setY(60);
            displayTitle.setFont(Font.font("Impact", 50));
            displayTitle.setFill(Color.PINK);

            // Base Box
            Rectangle rectangle = new Rectangle();
            rectangle.setX(500);
            rectangle.setY(6);
            rectangle.setWidth(825);
            rectangle.setHeight(825);
            rectangle.setFill(Color.rgb(55, 209, 31));
            rectangle.setStrokeWidth(5);
            rectangle.setStroke(Color.WHITE);

            // Logo
            Image image = new Image("Images/RoadRunnerLogo.png");
            ImageView imageView = new ImageView(image);
            imageView.setX(20);
            imageView.setY(100);
            // imageView.setRotate(0);

            // Button
            Button btn = new Button();
            btn.setLayoutX(75);
            btn.setLayoutY(375);
            btn.setMinWidth(150);
            btn.setMinHeight(50);
            btn.setText("Start/Restart");

            GridBuilder gameOne = new GridBuilder();
            SpawnPlayer spawner = new SpawnPlayer();
            Collision colide = new Collision();

            btn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    gameOne.createNextBackground(root, spawner, scene, gameOne, colide);
                }
            });

            root.getChildren().add(btn);
            // root.getChildren().add(deleteCar);
            root.getChildren().add(displayTitle);
            root.getChildren().add(rectangle);
            root.getChildren().add(imageView);

            stage.setResizable(true);
            stage.setFullScreen(true);
            stage.setScene(scene);
            stage.show();

            // random seed (using nanoTime)
            Random r = new Random();
            long seed = System.nanoTime();
            r.setSeed(seed);
        });

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> {
            System.exit(0);
        });

        VBox root = new VBox(20, title, startButton, exitButton);
        root.setAlignment(Pos.CENTER);



        Image backgroundImage = new Image("Images/skyline.jpeg");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
        BackgroundSize.DEFAULT);
        root.setBackground(new Background(background));

        Scene scene = new Scene(root, Color.BLACK);;

        //Icon
        Image icon = new Image("Images/RoadRunnerLogo.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Rhode Runna");
        

        primaryStage.setWidth(750);
        primaryStage.setHeight(750);
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
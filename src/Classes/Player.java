package Classes;

import javafx.animation.AnimationTimer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Player {
    //Player
    int hAndW = 75;
    int playerXCoord;
    int playerYCoord;
    Image player = new Image("Images/Car.png");
    ImageView playerView = new ImageView(player);

    int playerOffset = 12;
    int endCollisionOffest = 50;
    double movementVariableX = 0;
    double movementVariableY = 0;
    double movementChange = 1;
    int rotationVariable = 180;
    int rotationChange = 45;
    int speedDivisor = 5;
    int currCount = 0;

    BooleanProperty wPressed = new SimpleBooleanProperty();
    BooleanProperty aPressed = new SimpleBooleanProperty();
    BooleanProperty sPressed = new SimpleBooleanProperty();
    BooleanProperty dPressed = new SimpleBooleanProperty();

    Boolean inGrid = true;
    

    public Player(Group root, Scene scene, SpawnPlayer spawner, GridBuilder currGrid, Collision colider){
        sPressed.set(false);
        dPressed.set(false);
        aPressed.set(false);
        wPressed.set(false);
        playerView.setX(playerXCoord);
        playerView.setY(playerYCoord);
        playerView.setRotate(rotationVariable);
        playerView.setPreserveRatio(true);
        playerView.setFitHeight(hAndW);
        playerView.setFitWidth(hAndW);
        inGrid = true;
        root.getChildren().add(playerView);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                if(inGrid){
                    if(wPressed.get()) {
                        sPressed.set(false);
                        if(currCount % speedDivisor == 0){
                            playerYCoord += movementVariableY;
                            playerXCoord += movementVariableX;
                            playerView.setY(playerYCoord);
                            playerView.setX(playerXCoord);
                        }
                        currCount++;
                    }
                    if(sPressed.get()){
                        wPressed.set(false);
                        if(currCount % speedDivisor == 0){
                            playerYCoord += movementVariableY;
                            playerXCoord += movementVariableX;
                            playerView.setY(playerYCoord);
                            playerView.setX(playerXCoord);
                        }
                        currCount++;
                    }
                    if(aPressed.get()){
                        dPressed.set(false);
                        if(currCount % speedDivisor == 0){
                            playerYCoord += movementVariableY;
                            playerXCoord += movementVariableX;
                            playerView.setY(playerYCoord);
                            playerView.setX(playerXCoord);
                        }
                        currCount++;
                    }
                    if(dPressed.get()){
                        aPressed.set(false);
                        if(currCount % speedDivisor == 0){
                            playerYCoord += movementVariableY;
                            playerXCoord += movementVariableX;
                            playerView.setY(playerYCoord);
                            playerView.setX(playerXCoord);
                        }
                        currCount++;
                    }
    
                    if(playerYCoord >= spawner.endY - endCollisionOffest && 
                    playerYCoord <= spawner.endY + endCollisionOffest &&
                    playerXCoord >= spawner.endX - endCollisionOffest &&
                    playerXCoord <= spawner.endX + endCollisionOffest){
                        wPressed.set(false);
                        aPressed.set(false);
                        sPressed.set(false);
                        dPressed.set(false);
                        playerXCoord = -100;
                        playerYCoord = -100;
                        playerView.setX(playerXCoord);
                        playerView.setY(playerYCoord);
                        currGrid.createNextBackground(root, spawner, scene, currGrid, colider);  
                    }
    
                    inGrid = colider.setCellCollisions(playerXCoord, playerYCoord);
                
                }else{
                    stop();
                    wPressed.set(false);
                    aPressed.set(false);
                    sPressed.set(false);
                    dPressed.set(false);
                    playerXCoord = -100;
                    playerYCoord = -100;
                    playerView.setX(playerXCoord);
                    playerView.setY(playerYCoord);
                    System.out.println("Game Over");
                    Text endScreen = new Text("GAME OVER");
                    endScreen.setFont(Font.font("Impact", 187));
                    endScreen.setFill(Color.RED);
                    endScreen.setX(500);
                    endScreen.setY(500);
                    root.getChildren().add(endScreen);
                }
            }
        };
        movementSetup(scene);
        timer.start();
    }

    void movementSetup(Scene scene){
        scene.setOnKeyPressed(e -> {

            if(e.getCode() == KeyCode.W) {
                wPressed.set(true);
                sPressed.set(false);

                movementVariableY -= movementChange;
            
                if(rotationVariable % 360 != 90 && rotationVariable % 360 != -270){
                    if(Math.abs(rotationVariable % 360) > 90 && Math.abs(rotationVariable % 360) < 270){
                        rotationVariable -= rotationChange;
                    }
                    else{
                        rotationVariable += rotationChange;
                    }
                }
            }

            if(e.getCode() == KeyCode.D) {
                dPressed.set(true);
                aPressed.set(false);

                movementVariableX += movementChange;

                if(Math.abs(rotationVariable % 360) != 180){
                    if(Math.abs(rotationVariable % 360) >= 0 && Math.abs(rotationVariable % 360) < 180){
                        rotationVariable += rotationChange;
                    }
                    else{
                        rotationVariable -= rotationChange;
                    }
                }
            }

            if(e.getCode() == KeyCode.S) {
                sPressed.set(true);
                wPressed.set(false);

                    movementVariableY += movementChange;

                if(rotationVariable % 360 != 270 && rotationVariable % 360 != -90){
                    if(Math.abs(rotationVariable % 360) > 90 && Math.abs(rotationVariable % 360) < 270){
                        rotationVariable += rotationChange;
                    }
                    else{
                        rotationVariable -= rotationChange;
                    }
                }
            }

            if(e.getCode() == KeyCode.A) {
                aPressed.set(true);
                dPressed.set(false);
            
                movementVariableX -= movementChange;

                if(Math.abs(rotationVariable % 360) != 0){
                    if(Math.abs(rotationVariable % 360) > 180 && Math.abs(rotationVariable % 360) < 360){
                        rotationVariable += rotationChange;
                    }
                    else{
                        rotationVariable -= rotationChange;
                    }
                }
            }
            //System.out.println((rotationVariable % 360));
            if (rotationVariable == -45){
                rotationVariable = 315;
            }else if (rotationVariable == 405){
                rotationVariable = 45;
            }
            playerView.setRotate(rotationVariable);
        });
    }

    void setStartDirection(int startConnection){
        switch (startConnection){
            //From North so start facing down
            case 8:
                this.rotationVariable = 270;
                break;
            //From South so start facing up
            case 4:
                this.rotationVariable = 90;
                break;
            //From East so start facing left
            case 2:
                this.rotationVariable = 0;
                break;
            //From West so start facing right
            case 1:
                this.rotationVariable = 180;
                break;
        }
        playerView.setRotate(rotationVariable);
    }

    public void updateCoordinates(int startXCoord, int startYCoord){
        this.playerXCoord = startXCoord+playerOffset;
        this.playerYCoord = startYCoord-playerOffset;
        playerView.setX(playerXCoord);
        playerView.setY(playerYCoord);
    }
    
}

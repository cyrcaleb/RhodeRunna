package Classes;

import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Pair;


public class SpawnPlayer {
    Rectangle startLocation;
    public int xCoord;
    public int yCoord;
    
    int endX;
    int endY;
    Rectangle nextSpawnLocation;
    int endConnection;
    //Pair<Integer, Integer> nextStartPos;


    public SpawnPlayer(){
        this.startLocation = new Rectangle();
        startLocation.setWidth(100);
        startLocation.setHeight(50);
        startLocation.setFill(Color.RED);
        startLocation.setStrokeWidth(1);
        startLocation.setStroke(Color.WHITE);

        this.nextSpawnLocation = new Rectangle();
        nextSpawnLocation.setWidth(100);
        nextSpawnLocation.setHeight(50);
        nextSpawnLocation.setFill(Color.ORANGE);
        nextSpawnLocation.setStrokeWidth(1);
        nextSpawnLocation.setStroke(Color.WHITE);
    }


    public void displayStartLocation(Pair<Integer, Integer> startCoords, int connection, Group root){
        
        switch(connection){
            //North sets y to top of grid
            case 8:
                startLocation.setRotate(90);
                startLocation.setY(0);
                yCoord = 0;
                if(startCoords.getValue() == 0){//x Value
                    startLocation.setX(585);
                    xCoord = 585;
                }else if(startCoords.getValue() == 1){
                    startLocation.setX(863);
                    xCoord = 863;
                }else{
                    startLocation.setX(1140);
                    xCoord = 1140;
                }
                break;
            //South sets y to bottom of grid
            case 4:
                startLocation.setRotate(90);
                startLocation.setY(800);
                yCoord = 800;
                if(startCoords.getValue() == 0){//x Value
                    startLocation.setX(585);
                    xCoord = 585;
                }else if(startCoords.getValue() == 1){
                    startLocation.setX(863);
                    xCoord = 863;
                }else{
                    startLocation.setX(1140);
                    xCoord = 1140;
                }
                break;
            //East sets X to right of grid
            case 2:
                startLocation.setRotate(0);
                startLocation.setX(1275);
                xCoord = 1275;
                if(startCoords.getKey() == 0){//y Value
                    startLocation.setY(110);
                    yCoord = 110;
                }else if(startCoords.getKey() == 1){
                    startLocation.setY(393);
                    yCoord = 393;
                }else{
                    startLocation.setY(675);
                    yCoord = 675;
                }
                break;
            //West sets x to left of grid
            case 1:
                startLocation.setRotate(0);
                startLocation.setX(450);
                xCoord = 450;
                if(startCoords.getKey() == 0){//y Value
                    startLocation.setY(110);
                    yCoord = 110;
                }else if(startCoords.getKey() == 1){
                    startLocation.setY(393);
                    yCoord = 393;
                }else{
                    startLocation.setY(675);
                    yCoord = 675;
                }
                break;
        }
    }

    public void displayNextStartLocation(Pair<Integer, Integer> nextCoords, int connection, Group root){
        endX = nextCoords.getValue();
        endY = nextCoords.getKey();
        this.endConnection = connection;
        this.setEndPosition();
        switch(connection){
            //North sets y to top of grid
            case 8:
                nextSpawnLocation.setRotate(90);
                nextSpawnLocation.setY(0);
                if(nextCoords.getValue() == 0){//x Value
                    nextSpawnLocation.setX(585);
                }else if(nextCoords.getValue() == 1){
                    nextSpawnLocation.setX(863);
                }else{
                    nextSpawnLocation.setX(1140);
                }
                break;
            //South sets y to bottom of grid
            case 4:
            nextSpawnLocation.setRotate(90);
            nextSpawnLocation.setY(800);
                if(nextCoords.getValue() == 0){//x Value
                    nextSpawnLocation.setX(585);
                }else if(nextCoords.getValue() == 1){
                    nextSpawnLocation.setX(863);
                }else{
                    nextSpawnLocation.setX(1140);
                }
                break;
            //East sets X to right of grid
            case 2:
                nextSpawnLocation.setRotate(0);
                nextSpawnLocation.setX(1275);
                if(nextCoords.getKey() == 0){//y Value
                    nextSpawnLocation.setY(110);
                }else if(nextCoords.getKey() == 1){
                    nextSpawnLocation.setY(393);
                }else{
                    nextSpawnLocation.setY(675);
                }
                break;
            //West sets x to left of grid
            case 1:
                nextSpawnLocation.setRotate(0);
                nextSpawnLocation.setX(450);
                if(nextCoords.getKey() == 0){//y Value
                    nextSpawnLocation.setY(110);
                }else if(nextCoords.getKey() == 1){
                    nextSpawnLocation.setY(393);
                }else{
                    nextSpawnLocation.setY(675);
                }
                break;
        }
        //comment out the lines below to remove errors
        // root.getChildren().add(startLocation);
        //root.getChildren().add(nextSpawnLocation);
    }

    private void setEndPosition(){
        switch(this.endConnection){
            //North sets y to top of grid
            case 4:
                endY = 0;
                if(endX == 0){//x Value
                    endX = 585;
                }else if(endX == 1){
                    endX = 863;
                }else{
                    endX = 1140;
                }
                break;
            //South sets y to bottom of grid
            case 8:
                endY = 800;
                if(endX == 0){//x Value
                    endX = 585;
                }else if(endX == 1){
                    endX = 863;
                }else{
                    endX = 1140;
                }
                break;
            //East sets X to right of grid
            case 1:
                endX = 1275;
                if(endY == 0){//y Value
                    endY = 110;
                }else if(endY == 1){
                    endY = 393;
                }else{
                    endY = 675;
                }
                break;
            //West sets x to left of grid
            case 2:
                endX = 450;
                if(endY == 0){//y Value
                    endY = 110;
                }else if(endY == 1){
                    endY = 393;
                }else{
                    endY = 675;
                }
                break;
        }
    }
}

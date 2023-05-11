package Classes;
import java.util.*;

import javafx.scene.image.ImageView;
import javafx.util.Pair;
import java.lang.Math;
import javafx.scene.Group;
import javafx.scene.Scene;


public class GridBuilder{
    ArrayList<ArrayList<Road>> grid;
    RoadArray roadArray;
    StartBlock start;
    Pair<Integer, Integer> tempCoords;
    int tempConnection;
    SpeedDTO speedHolder = new SpeedDTO();

    public GridBuilder(){
        this.grid = resetGrid();

        this.roadArray = new RoadArray();

        this.start = new StartBlock();
    }

    private ArrayList<ArrayList<Road>> resetGrid(){
        ArrayList<ArrayList<Road>> grid = new ArrayList<ArrayList<Road>>();

        // One space allocated for R0
        grid.add(new ArrayList<Road>());

        Road emptyRoad = new Road(0, "Images/BlankRoad.jpg", 0, '0', 0, 0);

        for(int i = 0; i < 3; i++){
            grid.add(i, new ArrayList<>(Arrays.asList(emptyRoad,emptyRoad,emptyRoad)));
        }
        return grid;
    }
    
    // private void printGrid(ArrayList<ArrayList<Road>> grid){
    //     String result = "";
    //     for(int i = 0; i < 3; i++){
    //         for(int j = 0; j < 3; j++){
    //             result += grid.get(i).get(j).symbol;
    //             result += ' ';
    //         }
    //         result += "\n";
    //     }
    //     System.out.println(result);
    // }

    private ArrayList<Road> getComplementaryRoads(int connection, Road[] roadArr){
        ArrayList<Road> complements = new ArrayList<>();

        for(Road road: roadArr){
            if(road.connections.getKey() == connection || road.connections.getValue() == connection){
                complements.add(road);
            }
        }

        return complements;
    } 

    private Road getRandomRoad(ArrayList<Road> complements){
        // define the range

        int randIdx = (int)(Math.random() * complements.size());
        Road nextRoad = complements.get(randIdx);
        
        return nextRoad;
    }

    private Pair<Integer, Integer> updateCoordinates(int xCoord, int yCoord, int connection, Road nextRoad){
        int direction = Math.abs(nextRoad.value - connection);
        // System.out.println("direction: " + direction);
        Pair<Integer, Integer> result;

        switch (direction){
            //North
            case 8:
                result = new Pair<>(--xCoord, yCoord);
                break;
            //East
            case 2:
                result = new Pair<>(xCoord, ++yCoord);
                break;
            //South
            case 4:
                result = new Pair<>(++xCoord, yCoord);
                break;
            //West
            case 1:
                result = new Pair<>(xCoord, --yCoord);
                break;
            default:
                result = new Pair<>(-1, -1);
                System.out.println("Invalid direction given");
                break;
        }
        return result;
    }

    private int updateConnection(int connection, Road nextRoad){
        int roadLead = Math.abs(nextRoad.value - connection);

        //must return roadConnector (opposite of road lead)
        switch(roadLead){
            case 8:
                return 4;
            case 4:
                return 8;
            case 2:
                return 1;
            case 1:
                return 2;
            default:
                System.out.println("Invalid roadLead given");
                return -1;
        }
    }
    
    private ArrayList<ArrayList<Road>> createRecursiveGridMap(int xCoord, int yCoord, ArrayList<ArrayList<Road>> grid, int connection, Road[] roadArr, StartBlock start){

        ArrayList<ArrayList<Road>> tempGrid = grid;

        //get possible next roads
        ArrayList<Road> complements = getComplementaryRoads(connection, roadArr);

        while(true){
            //return old grid since no roads were possible
            if(complements.size() == 0){
                return grid;
            }
    
            //get the next road randomly
            Road nextRoad = getRandomRoad(complements);
    
            //replaces current spot with road
            tempGrid.get(xCoord).set(yCoord, nextRoad); 
    
            //updates to new coordinate
            Pair<Integer, Integer> coords = updateCoordinates(xCoord, yCoord, connection, nextRoad);
            int newXCoord = coords.getKey();
            int newYCoord = coords.getValue();
            start.updateCoordinates(xCoord, yCoord);
            //System.out.println("xCoord = " + xCoord + " yCoord = " + yCoord);
    
            //updates connection type
            int newConnection = updateConnection(connection, nextRoad);
            //System.out.println("Connection Needed = " + connection);
            start.updateEndBlockConnection(newConnection);
    
            //valid final grid
            if(newXCoord < 0 || newXCoord >= 3 || newYCoord < 0 || newYCoord >= 3){ 
                return tempGrid;
            }else if((newXCoord >= 0 && newXCoord < 3 && newYCoord >= 0 && newYCoord < 3) && tempGrid.get(newXCoord).get(newYCoord).symbol != '0'){     //within grid but spot is already used
                //remove road chosen from complement Arraylist and try again | and reset connection
                complements.remove(nextRoad);
                start.updateEndBlockConnection(connection);
                if (complements.size() == 0){
                    //impossible grid due to no possible roads
                    return createRecursiveGridMap(newXCoord, newYCoord, tempGrid, newConnection, roadArr, start);
                }
                continue;
            }
    
            //if not a valid Grid
            return createRecursiveGridMap(newXCoord, newYCoord, tempGrid, newConnection, roadArr, start);
        }
    }

    // public void createGameBackground(int numScreens, Group root){
    //     for(int i = 0; i < numScreens; i++){
    //         start.printValues();
    //         createRecursiveGridMap(start.currCoordPair.getKey(), start.currCoordPair.getValue(), grid, start.startConnection, roadArray.allRoads, start);
    //         //printGrid(grid);
    //         displayGameBackground(grid, root);
    //         start.updateStartBlock();
    //         grid = resetGrid();
    //     }
    // }
    
    private void displayGameBackground(ArrayList<ArrayList<Road>> grid, Group root){
        int heightAndWidth = 275;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                ImageView imageView = new ImageView(grid.get(i).get(j).image);
                imageView.setPreserveRatio(true);
                imageView.setFitHeight(heightAndWidth);
                imageView.setFitWidth(heightAndWidth);
                imageView.setX(heightAndWidth*j+500);
                imageView.setY(heightAndWidth*i+6);
                imageView.setRotate(grid.get(i).get(j).rotation);
                root.getChildren().add(imageView);
            }
        }
    }

    public void createNextBackground(Group root, SpawnPlayer spawner, Scene scene, GridBuilder currGrid, Collision colider){
        //start.printValues();
        tempCoords = start.currCoordPair;
        tempConnection = start.startConnection;
        createRecursiveGridMap(start.currCoordPair.getKey(), start.currCoordPair.getValue(), grid, start.startConnection, roadArray.allRoads, start);
        //printGrid(grid);
        displayGameBackground(grid, root);
        start.updateStartBlock();
        Player car = new Player(root, scene, spawner, currGrid, colider);
        //BREAKOFF POINT JUST NEXT TWO LINES
        colider.collisionGrid = grid;
        colider.activateCellCollisions();
        grid = resetGrid();
        spawner.displayStartLocation(tempCoords, tempConnection, root);
        spawner.displayNextStartLocation(start.currCoordPair, start.startConnection, root);
        car.updateCoordinates(spawner.xCoord, spawner.yCoord);
        car.setStartDirection(tempConnection);
    }

    
}

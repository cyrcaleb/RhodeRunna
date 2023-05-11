package Classes;
import javafx.util.Pair;
import java.lang.Math;

public class StartBlock {
    Pair<Integer, Integer> currCoordPair;
    int startConnection;
    int endConnection;

    //Edges are Even 2,4,6,8
    //Corners are odd 1,3,7,9

    //  1 2 3
    //  4   6
    //  7 8 9

    public StartBlock(){
        int[] cellBlockArray = {1,2,3,4,6,7,8,9};
        int randIdx = (int)(Math.random() * 8);  //0 - 7
        int startCell = cellBlockArray[randIdx];

        int cornerConnection = (int)(Math.random() * 2);  //0 - 1 
        
        switch (startCell){
            case 1:
                this.currCoordPair = new Pair<Integer,Integer>(0,0);
                if(cornerConnection == 0){
                    this.startConnection = 8;           
                    break;
                }
                this.startConnection = 1;
                break;
            case 2:
                this.currCoordPair = new Pair<Integer,Integer>(0,1);
                this.startConnection = 8;
                break;
            case 3:
                this.currCoordPair = new Pair<Integer,Integer>(0,2);
                if(cornerConnection == 0){
                    this.startConnection = 8;           
                    break;
                }
                this.startConnection = 2;
                break;
            case 4:
                this.currCoordPair = new Pair<Integer,Integer>(1,0);
                this.startConnection = 1;
                break;
            case 6:
                this.currCoordPair = new Pair<Integer,Integer>(1,2);
                this.startConnection = 2;
                break;
            case 7:
                this.currCoordPair = new Pair<Integer,Integer>(2,0);
                if(cornerConnection == 0){
                    this.startConnection = 4;           
                    break;
                }
                this.startConnection = 1;
                break;
            case 8:
                this.currCoordPair = new Pair<Integer,Integer>(2,1);
                this.startConnection = 4;
                break;
            case 9:
                this.currCoordPair = new Pair<Integer,Integer>(2,2);
                if(cornerConnection == 0){
                    this.startConnection = 4;           
                    break;
                }
                this.startConnection = 2;
                break;
        }
    }
    
    public void updateEndBlockConnection(int connectionValue){
        this.endConnection = connectionValue;
    }

    public void updateCoordinates(int xCoord, int yCoord){
        this.currCoordPair = new Pair<Integer,Integer>(xCoord,yCoord); 
    }

    public void updateStartBlock(){
        switch(this.endConnection){
            case 8:
                this.currCoordPair = new Pair<Integer,Integer>(currCoordPair.getKey()-2,currCoordPair.getValue()); 
                break;
            case 4:
                this.currCoordPair = new Pair<Integer,Integer>(currCoordPair.getKey()+2,currCoordPair.getValue()); 
                break;
            case 2:
                this.currCoordPair = new Pair<Integer,Integer>(currCoordPair.getKey(),currCoordPair.getValue()+2); 
                break;
            case 1:
                this.currCoordPair = new Pair<Integer,Integer>(currCoordPair.getKey(),currCoordPair.getValue()-2); 
                break;
        }
        this.startConnection = this.endConnection;
    }

    public void printValues(){
        System.out.println("Coordinates are (" + this.currCoordPair.getKey() + ", " + this.currCoordPair.getValue() + ")");
        System.out.println("Connection needed is " + startConnection);
    }
}

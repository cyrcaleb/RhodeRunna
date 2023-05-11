package Classes;

import java.util.ArrayList;
import java.util.Arrays;


public class Collision {
    ArrayList<ArrayList<Road>> collisionGrid;
    ArrayList<Boolean> cellCollision;


    public Collision(){
        this.collisionGrid = new ArrayList<ArrayList<Road>>();
        this.cellCollision = new ArrayList<Boolean>();

        this.collisionGrid.add(new ArrayList<Road>());

        Road emptyRoad = new Road(0, "Images/BlankRoad.jpg", 0, '0', 0, 0);

        for(int i = 0; i < 3; i++){
            this.collisionGrid.add(i, new ArrayList<>(Arrays.asList(emptyRoad,emptyRoad,emptyRoad)));
        }

        for(int i = 0; i < 9; i++){
            this.cellCollision.add(i, false);
        }


        // String result = "";
        // for(int i = 0; i < 3; i++){
        //     for(int j = 0; j < 3; j++){
        //         result += this.collisionGrid.get(i).get(j).symbol;
        //         result += ' ';     
        //     }
        //     result += "\n";
        // }
        // System.out.println(result);

        // String result = "";
        // for(int i = 0; i < 9; i++){
        //     result += this.cellCollision.get(i);
        //     result += ' ';  
        // }
        // System.out.println(result);

    }

    public void activateCellCollisions(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int value = this.collisionGrid.get(i).get(j).value;
                if (value != 0){
                    this.cellCollision.set(i*3+j, true);
                }else{
                    this.cellCollision.set(i*3+j, false);
                }
            }
        }
    }


    private boolean connectionExists(int xpos, int ypos, int connection){
        if(this.collisionGrid.get(xpos).get(ypos).connections.getKey() == connection || this.collisionGrid.get(xpos).get(ypos).connections.getValue() == connection){
            return true;
        }
        return false;
    }

    public boolean setCellCollisions(int playerXCoord, int playerYCoord){
        if(playerXCoord != -100 && playerYCoord != -100){
            System.out.println("Xcoord: "+ playerXCoord);
            System.out.println("Ycoord: "+ playerYCoord);
        }

        if (cellCollision.get(0) == true){
            if(!connectionExists(0, 0, 8)){
                if (playerYCoord <= -5 && playerXCoord >= 408 && playerXCoord <= 714){
                    System.out.println("Cell 1 is true");
                    System.out.println("    For North");
                    return false;
                }
            }
            if(!connectionExists(0, 0, 4)){
                if (playerYCoord >= 212 && playerYCoord <= 222 && playerXCoord >= 408 && playerXCoord <= 714){
                    System.out.println("Cell 1 is true");
                    System.out.println("    For South");
                    return false;
                }
            }
            if(!connectionExists(0, 0, 2)){
                if (playerXCoord >= 704 && playerXCoord <= 714 && playerYCoord >= -5 && playerYCoord <= 222){
                    System.out.println("Cell 1 is true");
                    System.out.println("    For East");
                    return false;
                }
            }
            if(!connectionExists(0, 0, 1)){
                if (playerXCoord <= 408 && playerYCoord >= -5 && playerYCoord <= 222){
                    System.out.println("Cell 1 is true");
                    System.out.println("    For West");
                    return false;
                }
            }
        }
        if (cellCollision.get(1) == true){
            if(!connectionExists(0, 1, 8)){
                if (playerYCoord <= -5 && playerXCoord >= 714 && playerXCoord <= 997){
                    System.out.println("Cell 2 is true");
                    System.out.println("    For North");
                    return false;
                }
            }
            if(!connectionExists(0, 1, 4)){
                if (playerYCoord >= 212 && playerYCoord <= 222 && playerXCoord >= 714 && playerXCoord <= 997){
                    System.out.println("Cell 2 is true");
                    System.out.println("    For South");
                    return false;
                }
            }
            if(!connectionExists(0, 1, 2)){
                if (playerXCoord >= 987 && playerXCoord <= 997 && playerYCoord >= -5 && playerYCoord <= 222){
                    System.out.println("Cell 2 is true");
                    System.out.println("    For East");
                    return false;
                }
            }
            if(!connectionExists(0, 1, 1)){
                if (playerXCoord >= 704 && playerXCoord <= 714 && playerYCoord >= -5 && playerYCoord <= 222){
                    System.out.println("Cell 2 is true");
                    System.out.println("    For West");
                    return false;
                }
            }
        }
        if (cellCollision.get(2) == true){
            if(!connectionExists(0, 2, 8)){
                if (playerYCoord <= -5 && playerXCoord >= 997 && playerXCoord <= 1268){
                    System.out.println("Cell 3 is true");
                    System.out.println("    For North");
                    return false;
                }
            }
            if(!connectionExists(0, 2, 4)){
                if (playerYCoord >= 212 && playerYCoord <= 222 && playerXCoord >= 997 && playerXCoord <= 1268){
                    System.out.println("Cell 3 is true");
                    System.out.println("    For South");
                    return false;
                }
            }
            if(!connectionExists(0, 2, 2)){
                if (playerXCoord >= 1268 && playerYCoord >= -5 && playerYCoord <= 222){
                    System.out.println("Cell 3 is true");
                    System.out.println("    For East");
                    return false;
                }
            }
            if(!connectionExists(0, 2, 1)){
                if (playerXCoord >= 987 && playerXCoord <= 997 && playerYCoord >= -5 && playerYCoord <= 222){
                    System.out.println("Cell 3 is true");
                    System.out.println("    For West");
                    return false;
                }
            }
        }
        if (cellCollision.get(3) == true){
            if(!connectionExists(1, 0, 8)){
                if (playerYCoord >= 252 && playerYCoord <= 262 && playerXCoord >= 408 && playerXCoord <= 714){
                    System.out.println("Cell 4 is true");
                    System.out.println("    For North");
                    return false;
                }
            }
            if(!connectionExists(1, 0, 4)){
                if (playerYCoord >= 495 && playerYCoord <= 505 && playerXCoord >= 408 && playerXCoord <= 714){
                    System.out.println("Cell 4 is true");
                    System.out.println("    For South");
                    return false;
                }
            }
            if(!connectionExists(1, 0, 2)){
                if (playerXCoord >= 714 && playerXCoord <= 724 && playerYCoord >= 222 && playerYCoord <= 495){
                    System.out.println("Cell 4 is true");
                    System.out.println("    For East");
                    return false;
                }
            }
            if(!connectionExists(1, 0, 1)){
                if (playerXCoord <= 408 && playerYCoord >= 222 && playerYCoord <= 495){
                    System.out.println("Cell 4 is true");
                    System.out.println("    For West");
                    return false;
                }
            }
        }
        if (cellCollision.get(4) == true){
            if(!connectionExists(1, 1, 8)){
                if (playerYCoord >= 252 && playerYCoord <= 262 && playerXCoord >= 714 && playerXCoord <= 997){
                    System.out.println("Cell 5 is true");
                    System.out.println("    For North");
                    return false;
                }
            }
            if(!connectionExists(1, 1, 4)){
                if (playerYCoord >= 495 && playerYCoord <= 505 && playerXCoord >= 714 && playerXCoord <= 997){
                    System.out.println("Cell 5 is true");
                    System.out.println("    For South");
                    return false;
                }
            }
            if(!connectionExists(1, 1, 2)){
                if (playerXCoord >= 997 && playerXCoord <= 1007 && playerYCoord >= 222 && playerYCoord <= 495){
                    System.out.println("Cell 5 is true");
                    System.out.println("    For East");
                    return false;
                }
            }
            if(!connectionExists(1, 1, 1)){
                if (playerXCoord >= 714 && playerXCoord <= 724 && playerYCoord >= 222 && playerYCoord <= 495){
                    System.out.println("Cell 5 is true");
                    System.out.println("    For West");
                    return false;
                }
            }
        }
        if (cellCollision.get(5) == true){
            if(!connectionExists(1, 2, 8)){
                if (playerYCoord >= 252 && playerYCoord <= 262 && playerXCoord >= 997 && playerXCoord <= 1268){
                    System.out.println("Cell 6 is true");
                    System.out.println("    For North");
                    return false;
                }
            }
            if(!connectionExists(1, 2, 4)){
                if (playerYCoord >= 495 && playerYCoord <= 505 && playerXCoord >= 997 && playerXCoord <= 1268){
                    System.out.println("Cell 6 is true");
                    System.out.println("    For South");
                    return false;
                }
            }
            if(!connectionExists(1, 2, 2)){
                if (playerXCoord >= 1268 && playerYCoord >= 222 && playerYCoord <= 495){
                    System.out.println("Cell 6 is true");
                    System.out.println("    For East");
                    return false;
                }
            }
            if(!connectionExists(1, 2, 1)){
                if (playerXCoord >= 997 && playerXCoord <= 1007 && playerYCoord >= 222 && playerYCoord <= 495){
                    System.out.println("Cell 6 is true");
                    System.out.println("    For West");
                    return false;
                }
            }
        }
        if (cellCollision.get(6) == true){
            if(!connectionExists(2, 0, 8)){
                if (playerYCoord >= 520 && playerYCoord <= 530 && playerXCoord >= 408 && playerXCoord <= 714){
                    System.out.println("Cell 7 is true");
                    System.out.println("    For North");
                    return false;
                }
            }
            if(!connectionExists(2, 0, 4)){
                if (playerYCoord >= 775 && playerXCoord >= 408 && playerXCoord <= 714){
                    System.out.println("Cell 7 is true");
                    System.out.println("    For South");
                    return false;
                }
            }
            if(!connectionExists(2, 0, 2)){
                if (playerXCoord >= 714  && playerXCoord <= 724 && playerYCoord >= 495 && playerYCoord <= 775){
                    System.out.println("Cell 7 is true");
                    System.out.println("    For East");
                    return false;
                }
            }
            if(!connectionExists(2, 0, 1)){
                if (playerXCoord <= 408 && playerYCoord >= 495 && playerYCoord <= 775){
                    System.out.println("Cell 7 is true");
                    System.out.println("    For West");
                    return false;
                }
            }
        }
        if (cellCollision.get(7) == true){
            if(!connectionExists(2, 1, 8)){
                if (playerYCoord >= 520 && playerYCoord <= 530 && playerXCoord >= 714 && playerXCoord <= 997){
                    System.out.println("Cell 8 is true");
                    System.out.println("    For North");
                    return false;
                }
            }
            if(!connectionExists(2, 1, 4)){
                if (playerYCoord >= 775 && playerXCoord >= 714 && playerXCoord <= 997){
                    System.out.println("Cell 8 is true");
                    System.out.println("    For South");
                    return false;
                }
            }
            if(!connectionExists(2, 1, 2)){
                if (playerXCoord >= 997 && playerXCoord <= 1007 && playerYCoord >= 495 && playerYCoord <= 775){
                    System.out.println("Cell 8 is true");
                    System.out.println("    For East");
                    return false;
                }
            }
            if(!connectionExists(2, 1, 1)){
                if (playerXCoord >= 704 && playerXCoord <= 714 && playerYCoord >= 495 && playerYCoord <= 775){
                    System.out.println("Cell 8 is true");
                    System.out.println("    For West");
                    return false;
                }
            }
        }
        if (cellCollision.get(8) == true){
            if(!connectionExists(2, 2, 8)){
                if (playerYCoord >= 520 && playerYCoord <= 530 && playerXCoord >= 997 && playerXCoord <= 1268){
                    System.out.println("Cell 9 is true");
                    System.out.println("    For North");
                    return false;
                }
            }
            if(!connectionExists(2, 2, 4)){
                if (playerYCoord >= 775 && playerXCoord >= 997 && playerXCoord <= 1268){
                    System.out.println("Cell 9 is true");
                    System.out.println("    For South");
                    return false;
                }
            }
            if(!connectionExists(2, 2, 2)){
                if (playerXCoord >= 1268 && playerYCoord >= 495 && playerYCoord <= 775){
                    System.out.println("Cell 9 is true");
                    System.out.println("    For East");
                    return false;
                }
            }
            if(!connectionExists(2, 2, 1)){
                if (playerXCoord >= 987 && playerXCoord <= 997 && playerYCoord >= 495 && playerYCoord <= 775){
                    System.out.println("Cell 9 is true");
                    System.out.println("    For West");
                    return false;
                }
            }
        }
        return true;
    } 

    
}

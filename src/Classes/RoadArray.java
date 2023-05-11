package Classes;

public class RoadArray{
    Road[] allRoads;

    RoadArray(){
        this.allRoads = createRoadArray();
    }

    private Road[] createRoadArray(){
        Road northSouthRoad = new Road(12, "Images/RoadTypeOne.jpg", 90, '|', 8, 4);
        Road northEastRoad = new Road(10, "Images/RoadTypeTwo.jpg", 90, 'L', 8, 2);
        Road northWestRoad = new Road(9, "Images/RoadTypeTwo.jpg", 0, 'J', 8, 1);
        Road southEastRoad = new Road(6, "Images/RoadTypeTwo.jpg", 180, 'F', 4, 2);
        Road southWestRoad = new Road(5, "Images/RoadTypeTwo.jpg", 270, '7', 4, 1);
        Road eastWestRoad = new Road(3, "Images/RoadTypeOne.jpg", 0, '-', 2, 1);
        Road blankRoad = new Road(0, "Images/BlankRoad.jpg", 0, '0', 0, 0);

        Road[] arr = {northSouthRoad, northEastRoad, northWestRoad, southEastRoad, southWestRoad, eastWestRoad, blankRoad};

        return arr;
    }
}


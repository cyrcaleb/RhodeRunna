package Classes;
import javafx.util.Pair;
import javafx.scene.image.Image;


public class Road {
    int value;
    char symbol;
    Image image;
    int rotation;
    Pair<Integer, Integer> connections;

    public Road(int value, String img, int rotation, char symbol, int connectionOne, int connectionTwo){
        this.value = value;
        this.image = new Image(img);
        this.rotation = rotation;
        this.symbol = symbol;
        this.connections = new Pair<Integer, Integer>(connectionOne, connectionTwo);
    }
}

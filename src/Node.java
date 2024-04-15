// Node class represents each square in the map
public class Node {
    private int x;
    private int y;
    // Additional properties as needed

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        // Initialize additional properties
    }

    // Getters and setters for properties


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public String getCoordinates() {
        return "(" + x + ", " + y + ")";
    }
}


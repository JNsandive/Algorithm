import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Example usage for testing
        Graph graph = MapParser.parseMap("C:\\Users\\chami\\IdeaProjects\\Algorithm_CW\\src\\input.txt");
        Node start = new Node(7, 0); // Replace with actual start node
        Node finish = new Node(1, 4); // Replace with actual finish node
        List<Node> shortestPath = DijkstraAlgorithm.shortestPath(graph, start, finish);

//        // Output the steps of the solution
//        int step = 1;
//        for (Node node : shortestPath) {
//            System.out.println(step + ". Move to " + node.getCoordinates());
//            step++;
        }
    }
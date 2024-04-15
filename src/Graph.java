import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<Node, List<Edge>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addNode(Node node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(Node source, Node destination, int weight) {
        if (!adjacencyList.containsKey(source)) {
            addNode(source);
        }
        if (!adjacencyList.containsKey(destination)) {
            addNode(destination);
        }
        adjacencyList.get(source).add(new Edge(source, destination, weight));
        // For undirected graph, add the reverse edge
        // adjacencyList.get(destination).add(new Edge(destination, source, weight));
    }

    public List<Edge> getNeighbors(Node node) {
        return adjacencyList.getOrDefault(node, new ArrayList<>());
    }

    public List<Node> getNodes() {
        return new ArrayList<>(adjacencyList.keySet());
    }
}

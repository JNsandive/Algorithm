import java.util.*;

public class DijkstraAlgorithm {
    public static List<Node> shortestPath(Graph graph, Node start, Node finish) {
        Map<Node, Integer> distance = new HashMap<>();
        Map<Node, Node> previous = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));

        for (Node node : graph.getNodes()) {
            distance.put(node, Integer.MAX_VALUE);
            previous.put(node, null);
        }

        distance.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.equals(finish)) {
                break;
            }

            for (Edge neighborEdge : graph.getNeighbors(current)) {
                Node neighbor = neighborEdge.getDestination();
                int newDistance = distance.get(current) + neighborEdge.getWeight();

                if (newDistance < distance.get(neighbor)) {
                    distance.put(neighbor, newDistance);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        List<Node> path = new ArrayList<>();
        Node current = finish;
        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }
        Collections.reverse(path);
        printSteps(start, finish, previous);
        return path;
    }
    private static void printSteps(Node start, Node finish, Map<Node, Node> previous) {
        List<Node> path = new ArrayList<>();
        Node current = finish;
        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }
        Collections.reverse(path);

        int step = 1;
        for (Node node : path) {
            System.out.println(step + ". Move to " + node.getCoordinates());
            step++;
        }
    }
}

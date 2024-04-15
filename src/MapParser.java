import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapParser {
    public static Graph parseMap(String filePath) {
        Graph graph = new Graph();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            List<Node[]> nodesInRows = new ArrayList<>();
            int y = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Node[] nodesInRow = new Node[line.length()];
                for (int x = 0; x < line.length(); x++) {
                    char symbol = line.charAt(x);
                    Node node = new Node(x, y);
                    nodesInRow[x] = node;
                    graph.addNode(node);
                    if (symbol == 'S' || symbol == 'F' || symbol == '.') {
                        // Connect to adjacent nodes (left and up)
                        if (x > 0 && (line.charAt(x - 1) == '.' || line.charAt(x - 1) == 'S' || line.charAt(x - 1) == 'F')) {
                            graph.addEdge(node, nodesInRow[x - 1], 1);
                        }
                        if (y > 0 && (nodesInRows.get(y - 1)[x] == null || nodesInRows.get(y - 1)[x] == node)) {
                            graph.addEdge(node, nodesInRows.get(y - 1)[x], 1);
                        }
                    }
                }
                nodesInRows.add(nodesInRow);
                y++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return graph;
    }
}

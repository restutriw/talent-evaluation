public class Node implements Comparable<Node> {
    int x, y, steps, priority;
    String path;
    String directionPath;

    public Node(int x, int y, int steps, int priority, String path, String directionPath) {
        this.x = x;
        this.y = y;
        this.steps = steps;
        this.priority = priority;
        this.path = path;
        this.directionPath = directionPath;
    }

    @Override
    public int compareTo(Node n) {
        return Integer.compare(this.priority, n.priority);
    }
}

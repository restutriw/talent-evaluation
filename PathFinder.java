import java.util.PriorityQueue;

public class PathFinder {
    private static final int[] dirX = {0, 1, 0, -1};
    private static final int[] dirY = {1, 0, -1, 0};
    private static final String[] dirNames = {"kanan", "bawah", "kiri", "atas"};

    // mencari posisi Anne dan target
    public String shortestPath(char[][] map) {
        int rows = map.length;
        int cols = map[0].length;
        int startX = -1, startY = -1;
        int endX = -1, endY = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] == '^') {
                    startX = i;
                    startY = j;
                }
                if (map[i][j] == '*') {
                    endX = i;
                    endY = j;
                }
            }
        }

        if (startX == -1 || startY == -1 || endX == -1 || endY == -1) {
            return "Anne atau target tidak ditemukan pada peta.";
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startX, startY, 0, heuristic(startX, startY, endX, endY), "", ""));

        boolean[][] visited = new boolean[rows][cols];
        visited[startX][startY] = true;

        String finalDirectionPath = "";

        // pencarian terus berjalan selama masih ada node yang harus diproses pada queue
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == endX && current.y == endY) {
                finalDirectionPath = current.directionPath;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = current.x + dirX[i];
                int newY = current.y + dirY[i];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && map[newX][newY] != '#' && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    int newSteps = current.steps + 1;
                    String newDirectionPath = PathFormatter.updateDirectionPath(current.directionPath, dirNames[i]);
                    int priority = newSteps + heuristic(newX, newY, endX, endY);
                    queue.add(new Node(newX, newY, newSteps, priority, current.path + "\n" + newSteps + " " + dirNames[i], newDirectionPath));
                }
            }
        }

        if (finalDirectionPath.isEmpty()) {
            return "tidak ada jalan";
        }

        return PathFormatter.formatOutput(finalDirectionPath);
    }

    private int heuristic(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}




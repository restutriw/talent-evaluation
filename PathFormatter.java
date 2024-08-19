public class PathFormatter {

    public static String updateDirectionPath(String currentPath, String newDirection) {
        if (currentPath.isEmpty()) {
            return newDirection + " 1";
        } else {
            String[] parts = currentPath.split("\n");
            String lastPart = parts[parts.length - 1];
            String[] lastPartParts = lastPart.split(" ");
            String lastDirection = lastPartParts[0];
            int lastCount = Integer.parseInt(lastPartParts[1]);

            if (lastDirection.equals(newDirection)) {
                return currentPath.substring(0, currentPath.length() - lastPart.length()) + lastDirection + " " + (lastCount + 1);
            } else {
                return currentPath + "\n" + newDirection + " 1";
            }
        }
    }

    public static String formatOutput(String path) {
        String[] parts = path.split("\n");
        StringBuilder result = new StringBuilder();
        int totalSteps = 0;

        for (String part : parts) {
            String[] tokens = part.split(" ");
            String direction = tokens[0];
            int steps = Integer.parseInt(tokens[1]);
            result.append(steps).append(" ").append(direction).append("\n");
            totalSteps += steps;
        }

        result.append(totalSteps).append(" langkah");
        return result.toString();
    }
}

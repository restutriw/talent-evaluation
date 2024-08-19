import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> mapLines = new ArrayList<>();
        String line;

        while (!(line = scanner.nextLine()).equals("OK")) {
            mapLines.add(line);
        }

        char[][] map = new char[mapLines.size()][mapLines.get(0).length()];

        for (int i = 0; i < map.length; i++) {
            map[i] = mapLines.get(i).toCharArray();
        }

        PathFinder pathfinder = new PathFinder();
        System.out.println(pathfinder.shortestPath(map));
    }
}


/* 

#######################
#                    *#
############ ##########
#       #     #       #
# ####### #############
#                     #
# #####################
#                 ^   #
#######################
OK


#######################
#                    *#
############ ######## #
#       #     #       #
# ####### ########### #
#                     #
# ################### #
#                 ^   #
#######################
OK

*/
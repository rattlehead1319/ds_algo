package problems.medium.logic;

public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {

        int x = 0;
        int y = 0;
        String direction = "north";

        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < instructions.length(); i++) {
                char instruction = instructions.charAt(i);
                if (direction == "north" && instruction == 'G') {
                    y = y + 1;
                }
                if (direction == "south" && instruction == 'G') {
                    y = y - 1;
                }
                if (direction == "east" && instruction == 'G') {
                    x = x + 1;
                }
                if (direction == "west" && instruction == 'G') {
                    x = x - 1;
                }
                if (direction == "north") {
                    if (instruction == 'L') {
                        direction = "west";
                    } else if (instruction == 'R') {
                        direction = "east";
                    }
                } else if (direction == "west") {
                    if (instruction == 'L') {
                        direction = "south";
                    } else if (instruction == 'R') {
                        direction = "north";
                    }
                } else if (direction == "south") {
                    if (instruction == 'L') {
                        direction = "east";
                    } else if (instruction == 'R') {
                        direction = "west";
                    }
                } else if (direction == "east") {
                    if (instruction == 'L') {
                        direction = "north";
                    } else if (instruction == 'R') {
                        direction = "south";
                    }
                }
            }
        }


        if (x == 0 && y == 0) {
            return true;
        }
        return false;
    }
}

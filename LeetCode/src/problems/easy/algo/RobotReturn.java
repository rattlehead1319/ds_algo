package problems.easy.algo;

public class RobotReturn {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char z: moves.toCharArray()) {
            switch(z) {
                case 'L':
                    x--;
                    break;
                case 'U':
                    y++;
                    break;
                case 'R':
                    x++;
                    break;
                case 'D':
                    y--;
            }
        }

        return x == 0 && y == 0;
    }
}

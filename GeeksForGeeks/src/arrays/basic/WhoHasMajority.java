package arrays.basic;

public class WhoHasMajority {
    public int majorityWins(int arr[],int n,int x,int y)
    {
        int countX = 0;
        int countY = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                countX++;
            }
            if (arr[i] == y) {
                countY++;
            }
        }
        if (countX == countY) {
            return x < y ? x : y;
        } else if (countX > countY) {
            return x;
        }
        return y;
    }
}

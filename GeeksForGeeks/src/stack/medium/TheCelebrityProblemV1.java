package stack.medium;

public class TheCelebrityProblemV1 {
    int celebrity(int M[][], int n){
        //Check whether 0 is celebrity
        boolean isZeroCelebrity = true;
        for (int j = 0; j < n; j++) {
            if (M[0][j] == 1) {
                isZeroCelebrity = false;
                break;
            }
        }
        if (isZeroCelebrity) {
            for (int i = 1; i < n; i++) {
                if (M[i][0] == 0) {
                    isZeroCelebrity = false;
                    break;
                }
            }
        }
        if (isZeroCelebrity) {
            return 0;
        }

        for (int j = 0; j < n; j++) {
            if (M[0][j] == 1) {
                int i = 1;
                for (i = 1; i < n; i++) {
                    if (i == j && M[i][j] != 0) {
                        break;
                    } else if (i != j && M[i][j] != 1) {
                        break;
                    }
                }
                if (i == n) {
                    int k = 0;
                    for (k = 0; k < n; k++) {
                        if (M[j][k] == 1) {
                            break;
                        }
                    }
                    if (k == n) {
                        return j;
                    }
                }
            }
        }
        return -1;
    }
}

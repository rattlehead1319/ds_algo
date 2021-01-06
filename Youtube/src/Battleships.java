public class Battleships {
    public int findNumberOfBattleships (char[][] board) {

        int numOfBattleships = 0;
        //We are going to use the fact that
        // if we are at continuing X we will be arriving at it from
        // either top X or left X
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (i > 0 && board[i-1][j] == 'X') {
                    continue;
                }
                if (j > 0 && board[i][j-1] == 'X') {
                    continue;
                }
                numOfBattleships++;
            }
        }
        return numOfBattleships;
    }
}

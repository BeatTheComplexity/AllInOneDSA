package backtracking;

public class NQueensBT {
    
    /*
        Objec­tive : In chess, a queen can move as far as she pleases, 
        hor­i­zon­tally, ver­ti­cally, or diag­o­nally. 
        A chess board has 8 rows and 8 columns. 
        The stan­dard 8 by 8 Queen’s prob­lem asks 
        how to place 8 queens on an ordi­nary chess board 
        so that none of them can hit any other in one move
    */

    int[][] solutions;

    public NQueensBT(int N) {
        solutions = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                solutions[i][j] = 0;
            }
        }
    }

    public void solve(int N) {
        if (placeQueens(0, N)) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(" " + solutions[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("NO SOLUTION EXISTS");
        }
    }

    private boolean placeQueens(int queen, int N) {
        // will place the Queens one at a time, for column wise
        if (queen == N) {
            //if we are here that means we have solved the problem
            return true;
        }

        for (int row = 0; row < N; row++) {
            // check if queen can be placed row,col
            if (canPlace(solutions, row, queen)) {
                // place the queen
                solutions[row][queen] = 1;
                // solve  for next queen
                if (placeQueens(queen + 1, N)) {
                    return true;
                }

                //if we are here that means above placement didn't work
                //BACKTRACK
                solutions[row][queen] = 0;
            }
        }
        //if we are here that means we haven't found solution
        return false;
    }

    private boolean canPlace(int[][] matrix, int row, int column) {
        // since we are filling one column at a time,
        // we will check if no queen is placed in that particular row

        for (int i = 0; i < column; i++) {
            if (matrix[row][i] == 1) {
                return false;
            }
        }

        // we are filling one column at a time,so we need to check the upper and
        // diagonal as well
        // check upper diagonal
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (matrix[i][j] == 1) {
                return false;
            }
        }

        // check lower diagonal
        for (int i = row, j = column; i < matrix.length && j >= 0; i++, j--) {
            if(matrix[i][j] == 1){
                return false;
            }
        }

        // if we are here that means we are safe to place Queen at row,column
        return true;
    }

}

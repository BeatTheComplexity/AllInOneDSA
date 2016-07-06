package backtracking;

import java.text.DecimalFormat;

public class KnightTour {

    int[][] solution;
    int path = 0;

    public KnightTour(int N) {
        solution = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                solution[i][j] = 0;
            }
        }
    }

    public void solve() {
        if (findPath(0, 0, 0, solution.length)) {
            printPath();
        } else {
            System.out.println("No Path found");
        }
    }

    private void printPath() {
        DecimalFormat twoDigit = new DecimalFormat("00");
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution.length; j++) {
                System.out.print(" " + twoDigit.format(solution[i][j]));
            }
            System.out.println();
        }
    }

    private boolean canMove(int row, int column, int N) {
        if (row >= 0 && row < N && column >= 0 && column < N) {
            return true;
        }
        return false;
    }

    private boolean findPath(int row, int colum, int index, int N) {
        // check if current is not used already
        if (solution[row][colum] != 0) {
            return false;
        }

        // mark the current cell is as used
        solution[row][colum] = path++;
        if (index == N * N - 1) {
            // if we are here means we have solved the problem
            return true;
        }

        // try to solve the rest of the problem recursively
        //go down and right
        if (canMove(row + 2, colum + 1, N) && findPath(row + 2, colum + 1, index + 1, N)) {
            return true;
        }

        //go right and down
        if (canMove(row + 1, colum + 2, N) && findPath(row + 1, colum + 2, index + 1, N)) {
            return true;
        }

        //go right and up
        if (canMove(row - 1, colum + 2, N) && findPath(row - 1, colum + 2, index + 1, N)) {
            return true;
        }

        //go up and right 
        if (canMove(row - 2, colum + 1, N) && findPath(row - 2, colum + 1, index + 1, N)) {
            return true;
        }

        //go up and left
        if (canMove(row - 2, colum - 1, N) && findPath(row - 2, colum - 1, index + 1, N)) {
            return true;
        }

        //go left and up
        if (canMove(row - 1, colum - 2, N) && findPath(row - 1, colum - 2, index + 1, N)) {
            return true;
        }

        //go left and down
        if (canMove(row + 1, colum - 2, N) && findPath(row + 1, colum - 2, index + 1, N)) {
            return true;
        }

        //go down and left
        if (canMove(row + 2, colum - 1, N) && findPath(row + 2, colum - 1, index + 1, N)) {
            return true;
        }

        // if we are here means nothing has worked , backtrack
        solution[row][colum] = 0;
        path--;
        return false;
    }

}

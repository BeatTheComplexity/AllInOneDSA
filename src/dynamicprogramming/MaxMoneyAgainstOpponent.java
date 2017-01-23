package dynamicprogramming;

public class MaxMoneyAgainstOpponent {

    /*
        Problem statement: Consider a row of 
        n coins of values v1 . . . vn, where n is even. 
        We play a game against an opponent by alternating turns. 
        In each turn, a player selects either 
        the first or last coin from the row, 
        removes it from the row permanently, 
        and receives the value of the coin. 
        Determine the maximum possible amount of money 
        we can definitely win if we move first.
    
        Following is recursive solution 
        that is based on above two choices. 
        We take the maximum of two choices.
    
        F(i, j)  represents the maximum value the user can collect from 
             i'th coin to j'th coin.

        F(i, j)  = Max(Vi + min(F(i+2, j), F(i+1, j-1) ), 
                       Vj + min(F(i+1, j-1), F(i, j-2) )) 
        Base Cases
        F(i, j)  = Vi           If j == i
        F(i, j)  = max(Vi, Vj)  If j == i+1
        
        ***The above solution will give u the max result***
    
        **Second Approach**
    
     */
    public static int getMaxMoneyAgainstOpponent(int[] arr) {
        int n = arr.length;
        int[][] table = new int[n][n];

        int x, y, z;

        for (int k = 0; k < n; ++k) {
            for (int i = 0, j = k; j < n; ++j) {
                // Here x is value of F(i+2, j), 
                //      y is F(i+1, j-1) and
                //      z is F(i, j-2) in above recursive formula

                x = ((i + 2) <= j) ? table[i + 2][j] : 0;
                y = ((i + 1) <= (j - 1)) ? table[i + 1][j - 1] : 0;
                z = (i <= (j - 2)) ? table[i][j - 2] : 0;

                table[i][j] = Math.max(arr[i] + Math.min(x, y),
                        arr[j] + Math.min(y, z));
            }
        }

        return table[0][n - 1];
    }

    public static int getMaxMoneyAgainstOpponent(int[] arr, int start, int end) {
        if (start > end) {
            return 0;
        }

        int a = arr[start]
                + Math.min(getMaxMoneyAgainstOpponent(arr, start + 2, end),
                        getMaxMoneyAgainstOpponent(arr, start + 1, end - 1));

        int b = arr[end]
                + Math.min(getMaxMoneyAgainstOpponent(arr, start + 1, end - 1),
                        getMaxMoneyAgainstOpponent(arr, start, end - 2));

        return Math.max(a, b);
    }
}

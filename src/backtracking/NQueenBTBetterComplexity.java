package backtracking;

import java.util.Arrays;

public class NQueenBTBetterComplexity {
    
    /*
        Objec­tive : In chess, a queen can move as far as she pleases, 
        hor­i­zon­tally, ver­ti­cally, or diag­o­nally. 
        A chess board has 8 rows and 8 columns. 
        The stan­dard 8 by 8 Queen’s prob­lem asks 
        how to place 8 queens on an ordi­nary chess board 
        so that none of them can hit any other in one move
    
        this solution will have O(n) space complexity
    
        Hint :
    
        Check if Queens placed at (x1, y1) and (x2,y2) are safe
        x1==x2 means same rows,
        y1==y2 means same columns
        |x2-x1|==|y2-y1| means they are placed in diagonals.
    */
    
    int[] results;
    
    public NQueenBTBetterComplexity(int N) {
        results = new int[N];
    }
    
    
    public void placeQueens(int x, int size){
        for (int i = 0; i < size; i++) {
            //check if queen at xth row can be placed at i-th column.
            if (canPlace(x, i)) {
                results[x] = i;
                if (x == size -1) {
                    System.out.println("Order of "+ size + " queens"
                            + Arrays.toString(results));
                }
                
                placeQueens(x +1, size);
            }
        }
    }

    private boolean canPlace(int x2, int y2) {
        for (int i = 0; i < x2; i++) {
            //result[i] == y2 => columns are same
	    //|i - x2| == |result[i] - y2| => in diagonals.
            
            if(results[i] == y2 || Math.abs(i - x2) == Math.abs(results[i] - y2)) 
                return false;
        }
        
        return true;
    }
}

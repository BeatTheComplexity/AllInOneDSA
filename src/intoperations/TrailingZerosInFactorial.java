package intoperations;

public class TrailingZerosInFactorial {

    /*
        Given an integer n, return the number of trailing zeroes in n!.
        Note: Your solution should be in logarithmic time complexity.
    
        Example
        n = 5
        n! = 120 
        Number of trailing zeros = 1
        So, return 1
     */
    public int findTrailingZeros(int n) {
        int count = 0;

        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }

        return count;
    }
}

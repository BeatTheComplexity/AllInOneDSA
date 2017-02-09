package intoperations;

import java.util.ArrayList;

public class PrimeSum {

    /*
    * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
    * 
    NOTE A solution will always exist. read Goldbach’s conjecture
    https://en.wikipedia.org/wiki/Goldbach%27s_conjecture

    Example:


    Input : 4
    Output: 2 + 2 = 4

    If there are more than one solutions possible, return the lexicographically smaller solution.

    If [a, b] is one solution with a <= b,
    and [c,d] is another solution with c <= d, then

    [a, b] < [c, d] 

    If a < c OR a==c AND b < d. 
     */
    public ArrayList<Integer> primeSum(int num) {

        ArrayList<Integer> results = new ArrayList<>();
        if (num <= 2 || num % 2 != 0) {
            return results;
        }

        int first = 2;
        int second = num - first;

        while (first <= second) {
            second = num - first;

            if (isPrime(first) && isPrime(second)) {
                results.add(first);
                results.add(second);
                break;
            }

            first++;
        }

        return results;
    }

    private boolean isPrime(int num) {
        if (num == 2) {
            return true;
        }

        int sqrt = (int) Math.sqrt(num);

        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}

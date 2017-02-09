package intoperations;

public class PalindromeInteger {

    /*
        Determine whether an integer is a palindrome. Do this without extra space.

        A palindrome integer is an integer x for which reverse(x) = x 
        where reverse(x) is x with its digit reversed.
        Negative numbers are not palindromic.

        Note: no extra space here means do not convert the integer to string, 
        since string will be a copy of the integer and take extra space. 
        The space take by div, left, and right can be ignored.
     */
    public boolean isPalindrome(int num) {

        if (num < 0) {
            return false;
        }

        int div = 1;

        while (num / div >= 10) {
            div *= 10;
        }

        while (num != 0) {
            int left = num / div;
            int right = num % 10;

            if (left != right) {
                return false;
            }

            num = (num % div) / 10;
            div /= 100;
        }
        return true;
    }

}

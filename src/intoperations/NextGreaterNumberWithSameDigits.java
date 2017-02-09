package intoperations;

import java.util.Arrays;

public class NextGreaterNumberWithSameDigits {

    /*
        Find next greater number with same set of digits
        Given a number n, find the smallest number that has same set of digits as n 
        and is greater than n. 
        If x is the greatest possible number with its set of digits, 
        then print “not possible”.
    
    Following is the algorithm for finding the next greater number.

    I)  Traverse the given number from rightmost digit, 
        keep traversing till you find a digit which is smaller 
        than the previously traversed digit. 
        For example, if the input number is “534976”, 
        we stop at 4 because 4 is smaller than next digit 9. 
        If we do not find such a digit, then output is “Not Possible”.

    II) Now search the right side of above found digit ‘d’ 
        for the smallest digit greater than ‘d’. For “534976″, 
        the right side of 4 contains “976”. The smallest digit greater than 4 is 6.

    III) Swap the above found two digits, 
        we get 536974 in above example.

    IV) Now sort all digits from position next to ‘d’ 
        to the end of number. The number that we get after sorting is the output. 
        For above example, we sort digits in bold 536974. 
        We get “536479” which is the next greater number for input 534976.
     */
    public static int getNextGreaterNumberWithSameDigits(int num) {

        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;
        int i, j;

        for (i = n - 1; i > 0; i--) {
            if (digits[i] > digits[i - 1]) {
                break;
            }
        }

        if (i == 0) {
            System.out.println("not possible");
            return num;
        }

        int x = getNumericValue(digits[i - 1]), smallest = i;
        for (j = i + 1; j < n; j++) {
            if (getNumericValue(digits[j]) > x
                    && getNumericValue(digits[j]) < getNumericValue(digits[smallest])) {
                smallest = j;
            }
        }

        char temp = digits[smallest];
        digits[smallest] = digits[i - 1];
        digits[i - 1] = temp;

        Arrays.sort(digits, i, n);

        int sum = 0;
        for (int k = 0; k < digits.length; k++) {
            sum = sum * 10 + Character.getNumericValue(digits[k]);
        }

        return sum;
    }

    public static int getNumericValue(char c) {
        return Character.getNumericValue(c);
    }
}

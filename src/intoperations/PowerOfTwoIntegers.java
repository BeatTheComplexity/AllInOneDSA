package intoperations;

public class PowerOfTwoIntegers {

    /*
    Given a positive integer which fits in a 32 bit signed integer, 
    find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

    Example

    Input : 4
    Output : True  
    as 2^2 = 4. 
     */
 /*
    For B = 2, number of possibilities = sqrt(INT_MAX) = sqrt(2^31 - 1) < 2^16.
    For B = 3, number of possibilities = INT_MAX**1/3 < 2^11
    For B = 4, number of possibilities = INT_MAX**1/4 < 2^8
    .
    .
    .
    For B = 32, number of possibilities = 0 ( Not considering 1 as its considered in the first case, and 2^32 exceeds INT_MAX ).
     */
    public static boolean isPower(int num) {
        if (num <= 1) {
            return true;
        }

        for (int i = 2; i < num && i < Integer.MAX_VALUE / i; i++) {
            int j = i;

            while (j <= num && j < Integer.MAX_VALUE / i) {
                j *= i;

                if (j == num) {
                    return true;
                }
            }

        }

        return false;
    }
}

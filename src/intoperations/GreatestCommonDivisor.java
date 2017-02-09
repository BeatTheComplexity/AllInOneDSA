package intoperations;

public class GreatestCommonDivisor {

    /*
        Given 2 non negative integers m and n, find gcd(m, n)

        GCD of 2 integers m and n is defined as the greatest integer g 
        such that g is a divisor of both m and n.
        Both m and n fit in a 32 bit signed integer.
     */
    public static int getGCD(int num1, int num2) {
        if (num1 > num2) {
            return gcd(num1, num2);
        }
        return getGCD(num2, num1);
    }

    public static int gcd(int num1, int num2) {
        int rem = 0;
        while (num2 != 0) {
            rem = num1 % num2;
            num1 = num2;
            num2 = rem;
        }

        return num1;
    }

}

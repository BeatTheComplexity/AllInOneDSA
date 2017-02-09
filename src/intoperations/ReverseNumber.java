package intoperations;

public class ReverseNumber {

    /*
        Reverse digits of an integer.

        Example1:
        x = 123,
        return 321
        Example2:
        x = -123,
        return -321

        Return 0 if the result overflows and does not fit in a 32 bit signed integer
     */
    public static int reverseNumber(int num) {
        int res = 0;
        int flag = 1;

        if (num < 0) {
            flag = -1;
            num = num * flag;
        }

        while (num != 0) {
            int digit = num % 10;

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE && digit > Integer.MAX_VALUE % 10)) {
                return 0;
            }

            res = (res * 10) + digit;
            num = num / 10;
        }

        return flag == -1 ? flag * res : res;
    }
}

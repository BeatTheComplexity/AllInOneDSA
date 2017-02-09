package intoperations;

public class Power {

    /*
        Determine x ^ y in O(log n) complexity
     */
    public static int power(int x, int y) {
        if (y == 0) {
            return 1;
        }
        int temp = power(x, y / 2);
        if (y % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }
}

package intoperations;

import java.util.Arrays;
import java.util.Collections;

public class NextSmallerNumberWithSameDigits {

    public static int getNextSmallerNumberWithSameDigits(int num) {
        char[] numChar = Integer.toString(num).toCharArray();

        Character[] digits = new Character[numChar.length];
        for (int i = 0; i < numChar.length; i++) {
            digits[i] = numChar[i];
        }

        int n = digits.length;
        int i, j;

        for (i = n - 1; i > 0; i--) {
            if (digits[i] < digits[i - 1]) {
                break;
            }
        }

        if (i == 0) {
            System.out.println("not possible");
            return num;
        }

        int x = getNumericValue(digits[i - 1]), largest = i;
        for (j = i + 1; j < n; j++) {
            if (x > getNumericValue(digits[j])
                    && getNumericValue(digits[j]) > getNumericValue(digits[largest])) {
                largest = j;
            }
        }

        char temp = digits[largest];
        digits[largest] = digits[i - 1];
        digits[i - 1] = temp;

        Arrays.sort(digits, i, n, Collections.reverseOrder());

        int sum = 0;

        for (int k = 0; k < digits.length; k++) {
            sum = sum * 10 + getNumericValue(digits[k]);
        }

        return sum;
    }

    public static int getNumericValue(char c) {
        return Character.getNumericValue(c);
    }
}

package intoperations;

public class ExcelColumnNumber {

    /*
        Given a column title as appears in an Excel sheet, return its corresponding column number.
    
        Example
        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28 
     */
    public static int titleToNumber(String str) {

        int result = 0;

        if (str == null || str.length() == 0) {
            return result;
        }

        int i = str.length() - 1;
        int t = 0;

        while (i >= 0) {
            char curr = str.charAt(i);

            result = result + (int) Math.pow(26, t) * (curr - 'A' + 1);

            t++;
            i--;
        }
        return result;
    }

    /*
        Given a positive integer, return its corresponding column title as appear in an Excel sheet
        
        1 -> A
        2 -> B
        3 -> C
        ...
        26 -> Z
        27 -> AA
        28 -> AB 
     */
    public static String intToTitle(int num) {
        StringBuilder result = new StringBuilder();

        if (num <= 0) {
            return result.toString();
        }

        while (num > 0) {
            int rem = num % 26;
            if (rem == 0) {
                result.append("Z");
                num = (num / 26) - 1;
            } else {
                result.append((char) (rem - 1 + 'A'));
                num = num / 26;
            }
        }

        return result.reverse().toString();
    }
}

package dynamicprogramming;

public class TinyURLorURLShortner {

    public static String idToShortURL(int id) {
        String keys = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        char[] map = keys.toCharArray();

        StringBuilder shortURL = new StringBuilder();

        while (id > 0) {
            shortURL.append(map[id % 62]);
            id /= 62;
        }

        shortURL.reverse();

        return shortURL.toString();
    }

    public static int stringToId(String url) {
        int id = 0;

        for (int i = 0; i < url.length(); i++) {
            if ('a' <= url.charAt(i) && url.charAt(i) <= 'z') {
                id = id * 62 + url.charAt(i) - 'a';
            } else if ('A' <= url.charAt(i) && url.charAt(i) <= 'Z') {
                id = id * 62 + url.charAt(i) - 'A' + 26;
            } else if ('0' <= url.charAt(i) && url.charAt(i) <= '9') {
                id = id * 62 + url.charAt(i) - '0' + 52;
            }
        }
        return id;
    }
}

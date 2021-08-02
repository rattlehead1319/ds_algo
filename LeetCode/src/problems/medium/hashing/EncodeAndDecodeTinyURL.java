package problems.medium.hashing;

import java.util.*;

public class EncodeAndDecodeTinyURL {
    private Map<String, String> codeDB = new HashMap<>();
    private Map<String, String> urlDB = new HashMap<>();
    private static final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    Random rand = new Random();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (urlDB.containsKey(longUrl)) {
            return urlDB.get(longUrl);
        }
        String code = getCode();
        while (codeDB.containsKey(code)) {
            code = getCode();
        }
        codeDB.put(code, longUrl);
        urlDB.put(code, longUrl);
        return code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlDB.get(shortUrl);
    }

    private String getCode() {
        char[] code = new char[6];
        for (int i = 0; i < 6; i++) {
            code[i] = chars.charAt(rand.nextInt(62));
        }
        return "https://tinyurl.com/" + String.valueOf(code);
    }
}

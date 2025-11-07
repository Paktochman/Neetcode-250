package Neetcode250;


import java.util.*;

public class EncodeDecodeStrings {

    // Encode list of strings into a single string
    public static String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) {
            encoded.append(s.length()).append('#').append(s);
        }
        return encoded.toString();
    }

    // Decode the encoded string back into a list of strings
    public static List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            // find the position of '#'
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }

            // extract the length before '#'
            int length = Integer.parseInt(s.substring(i, j));

            // extract the string of given length
            String str = s.substring(j + 1, j + 1 + length);
            result.add(str);

            // move to the next encoded string
            i = j + 1 + length;
        }

        return result;
    }

    // Test the solution
    public static void main(String[] args) {
        List<String> input1 = Arrays.asList("neet", "code", "love", "you");
        String encoded1 = encode(input1);
        System.out.println("Encoded: " + encoded1);
        System.out.println("Decoded: " + decode(encoded1));

        List<String> input2 = Arrays.asList("we", "say", ":", "yes");
        String encoded2 = encode(input2);
        System.out.println("Encoded: " + encoded2);
        System.out.println("Decoded: " + decode(encoded2));
    }
}

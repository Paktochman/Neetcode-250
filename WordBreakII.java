// WordBreakII.java

import java.util.*;

public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(0, s, dict, memo);
    }

    private List<String> dfs(int index, String s, Set<String> dict, Map<Integer, List<String>> memo) {
        if (memo.containsKey(index)) return memo.get(index);

        List<String> result = new ArrayList<>();

        // If we reached the end, return an empty sentence starter
        if (index == s.length()) {
            result.add("");
            memo.put(index, result);
            return result;
        }

        for (int end = index + 1; end <= s.length(); end++) {
            String word = s.substring(index, end);

            if (dict.contains(word)) {
                List<String> subs = dfs(end, s, dict, memo);
                for (String sub : subs) {
                    // If sub is empty, no space needed
                    if (sub.isEmpty()) {
                        result.add(word);
                    } else {
                        result.add(word + " " + sub);
                    }
                }
            }
        }

        memo.put(index, result);
        return result;
    }

    // Quick test
    public static void main(String[] args) {
        WordBreakII sol = new WordBreakII();
        List<String> dict = Arrays.asList("neet", "code");

        System.out.println(sol.wordBreak("neetcode", dict));
        // Output: ["neet code"]
    }
}

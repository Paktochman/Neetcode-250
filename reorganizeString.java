import java.util.*;

class SolutionReorganizeString {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) pq.offer(new int[]{freq[i], i});
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() >= 2) {
            int[] a = pq.poll();
            int[] b = pq.poll();

            sb.append((char)(a[1] + 'a'));
            sb.append((char)(b[1] + 'a'));

            if (--a[0] > 0) pq.offer(a);
            if (--b[0] > 0) pq.offer(b);
        }

        if (!pq.isEmpty()) {
            int[] last = pq.poll();
            if (last[0] > 1) return "";
            sb.append((char)(last[1] + 'a'));
        }

        return sb.toString();
    }
}


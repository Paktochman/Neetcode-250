import java.util.*;

class SolutionIPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Min-heap of projects sorted by required capital
        PriorityQueue<int[]> minCap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        // Max-heap of profits
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            minCap.offer(new int[]{capital[i], profits[i]});
        }

        int current = w;

        for (int i = 0; i < k; i++) {
            // Move all projects we can afford into profit heap
            while (!minCap.isEmpty() && minCap.peek()[0] <= current) {
                maxProfit.offer(minCap.poll()[1]);
            }

            if (maxProfit.isEmpty()) break;

            current += maxProfit.poll();
        }

        return current;
    }
}

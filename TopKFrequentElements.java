import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each number
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a max heap to sort elements by frequency
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(freqMap.entrySet());

        // Step 3: Extract the top k elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 3, 3};
        int k1 = 2;
        System.out.println(Arrays.toString(topKFrequent(nums1, k1))); // Output: [2, 3]

        int[] nums2 = {7, 7};
        int k2 = 1;
        System.out.println(Arrays.toString(topKFrequent(nums2, k2))); // Output: [7]
    }
}

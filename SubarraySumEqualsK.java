package Neetcode250;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); // to count subarrays that start from index 0
        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            // Check if there’s a prefix that leaves sum k
            if (prefixMap.containsKey(prefixSum - k)) {
                count += prefixMap.get(prefixSum - k);
            }

            // Update frequency of current prefixSum
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, -1, 1, 2};
        int k1 = 2;
        System.out.println(subarraySum(nums1, k1)); // Output: 4

        int[] nums2 = {4, 4, 4, 4, 4, 4};
        int k2 = 4;
        System.out.println(subarraySum(nums2, k2)); // Output: 6
    }
}

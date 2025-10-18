package Neetcode250;

import java.util.HashSet;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxLength = 0;

        for (int num : set) {
            // Only start counting if num is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int length = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 20, 4, 10, 3, 4, 5};
        System.out.println(longestConsecutive(nums1)); // Output: 4

        int[] nums2 = {0, 3, 2, 5, 4, 6, 1, 1};
        System.out.println(longestConsecutive(nums2)); // Output: 7
    }
}


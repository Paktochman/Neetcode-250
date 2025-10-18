package Neetcode250;

import java.util.*;

public class MajorityElementII {

    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0;
        Integer candidate1 = null, candidate2 = null;

        // 1️⃣ Find potential candidates
        for (int num : nums) {
            if (candidate1 != null && num == candidate1.intValue()) {
                count1++;
            } else if (candidate2 != null && num == candidate2.intValue()) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // 2️⃣ Verify the candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) count1++;
            if (candidate2 != null && num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3 && candidate2 != candidate1) result.add(candidate2);

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {5,2,3,2,2,2,2,5,5,5};
        System.out.println(majorityElement(nums1)); // Output: [2,5]

        int[] nums2 = {4,4,4,4,4};
        System.out.println(majorityElement(nums2)); // Output: [4]

        int[] nums3 = {1,2,3};
        System.out.println(majorityElement(nums3)); // Output: []
    }
}

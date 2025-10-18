package Neetcode250;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // Step 1: Left products
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // Step 2: Right products
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] = output[i] * right;
            right *= nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 6};
        int[] res1 = productExceptSelf(nums1);
        for (int val : res1) System.out.print(val + " ");  // Output: 48 24 12 8
        System.out.println();

        int[] nums2 = {-1, 0, 1, 2, 3};
        int[] res2 = productExceptSelf(nums2);
        for (int val : res2) System.out.print(val + " ");  // Output: 0 -6 0 0 0
    }
}

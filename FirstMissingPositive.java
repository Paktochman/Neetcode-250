public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its correct index (num -> index num-1)
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Step 2: Find the first index where nums[i] != i+1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all numbers are in the correct place
        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive obj = new FirstMissingPositive();

        int[] nums1 = {-2, -1, 0};
        System.out.println(obj.firstMissingPositive(nums1)); // Output: 1

        int[] nums2 = {1, 2, 4};
        System.out.println(obj.firstMissingPositive(nums2)); // Output: 3
    }
}

import java.util.Arrays;

public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                // Return 1-indexed positions
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // This line will never be reached because there is exactly one solution
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        int target = 3;
        int[] result = twoSum(numbers, target);
        System.out.println(Arrays.toString(result)); // Output: [1, 2]
    }
}

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1; // start from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) { // if nums2 still has elements
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {10,20,20,40,0,0};
        int[] nums2 = {1,2};
        merge(nums1, 4, nums2, 2);
        System.out.println(Arrays.toString(nums1)); // [1, 2, 10, 20, 20, 40]
    }
}

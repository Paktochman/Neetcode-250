class SolutionKthLargestArray {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, target);
    }

    private int quickSelect(int[] a, int l, int r, int k) {
        if (l == r) return a[l];

        int pivot = partition(a, l, r);
        if (pivot == k) return a[pivot];
        else if (pivot < k) return quickSelect(a, pivot + 1, r, k);
        else return quickSelect(a, l, pivot - 1, k);
    }

    private int partition(int[] a, int l, int r) {
        int pivot = a[r], p = l;
        for (int i = l; i < r; i++) {
            if (a[i] <= pivot) {
                int tmp = a[i]; a[i] = a[p]; a[p] = tmp;
                p++;
            }
        }
        int tmp = a[p]; a[p] = a[r]; a[r] = tmp;
        return p;
    }
}

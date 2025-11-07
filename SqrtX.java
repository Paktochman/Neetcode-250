public class SqrtX {
    public static int mySqrt(int x) {
        if (x < 2) return x;
        long left = 1, right = x / 2, ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(13)); // Output: 3
    }
}

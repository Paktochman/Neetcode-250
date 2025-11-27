class SolutionCarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];

        for (int[] t : trips) {
            int num = t[0], from = t[1], to = t[2];
            diff[from] += num;
            diff[to] -= num;
        }

        int curr = 0;
        for (int x : diff) {
            curr += x;
            if (curr > capacity) return false;
        }
        return true;
    }
}

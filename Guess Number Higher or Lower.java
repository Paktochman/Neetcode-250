class GuessGame {
    int pick = 3; // Example value
    int guess(int num) {
        if (num == pick) return 0;
        return num > pick ? -1 : 1;
    }
}

public class GuessNumberHigherOrLower extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == 0) return mid;
            else if (res < 0) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower game = new GuessNumberHigherOrLower();
        System.out.println(game.guessNumber(5)); // Output: 3
    }
}

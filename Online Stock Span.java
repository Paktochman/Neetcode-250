import java.util.*;

class StockSpanner {
    Stack<int[]> stack; // [price, span]
    public StockSpanner() {
        stack = new Stack<>();
    }
    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            span += stack.pop()[1];
        stack.push(new int[]{price, span});
        return span;
    }
}

public class OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int price = sc.nextInt();
            System.out.print(spanner.next(price) + " ");
        }
    }
}

import java.util.*;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) continue;
            else if (part.equals("..")) {
                if (!stack.isEmpty()) stack.removeLast();
            } else {
                stack.addLast(part);
            }
        }

        StringBuilder res = new StringBuilder();
        for (String dir : stack) res.append("/").append(dir);
        return res.length() == 0 ? "/" : res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.next();
        System.out.println(simplifyPath(path));
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Character> closeKey = new HashMap<>();
        closeKey.put(']', '[');
        closeKey.put(')', '(');

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            }
            boolean flag = true;
            Deque<Character> stack = new ArrayDeque<>();
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (closeKey.containsKey(ch)) {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }

                    char top = stack.peek();
                    if (top == closeKey.get(ch)) {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) {
                flag = false;
            }
            System.out.println(flag ? "yes" : "no");
        }

    }
}

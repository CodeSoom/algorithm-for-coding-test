import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        while (count-- > 0) {
            Deque<Character> stack = new ArrayDeque<>();
            char[] line = br.readLine().toCharArray();
            boolean flag = true;
            for (int i = 0; i < line.length; i++) {
                char ch = line[i];
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                flag = stack.isEmpty();
            }

            System.out.println(flag ? "YES" : "NO");
        }
    }
}

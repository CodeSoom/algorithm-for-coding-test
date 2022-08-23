import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        char[] line = br.readLine().toCharArray();
        char[] remove = br.readLine().toCharArray();

        for (int i = 0; i < line.length; i++) {
            stack.push(line[i]);
            if (stack.size() >= remove.length) {
                boolean flag = true;
                for (int j = 0; j < remove.length; j++) {
                    if (stack.get(stack.size() - remove.length + j) != remove[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < remove.length; j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String result = sb.reverse().toString();
        System.out.println(result.equals("") ? "FRULA" : result);
    }
}

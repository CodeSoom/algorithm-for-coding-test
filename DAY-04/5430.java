import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        loop: while (testCase-- > 0) {
            // 입력 처리
            char[] command = br.readLine().toCharArray();
            int lineSize = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String line = input.substring(1, input.length() - 1);
            String[] numbersStr = line.split(",");

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < lineSize; i++) {
                deque.offer(Integer.parseInt(numbersStr[i]));
            }

            // 명령
            boolean isHead = true;
            for (char ch : command) {
                if (ch == 'R') {
                    isHead = !isHead;
                    continue;
                }
                try {
                    if (isHead) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("error");
                    continue loop;
                }
            }

            // 출력 변수
            StringBuilder sb = new StringBuilder();
            StringJoiner sj = new StringJoiner(",");

            sb.append('[');
            while (!deque.isEmpty()) {
                if (isHead) {
                    sj.add(String.valueOf(deque.pollFirst()));
                    continue;
                }
                sj.add(String.valueOf(deque.pollLast()));
            }
            sb.append(sj);
            sb.append("]");

            System.out.println(sb);
        }
    }
}

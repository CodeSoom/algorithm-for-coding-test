import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringJoiner sj = new StringJoiner(", ");
        int size = Integer.parseInt(st.nextToken());
        int index = Integer.parseInt(st.nextToken());

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= size; i++) {
            queue.offer(i);
        }

        sb.append("<");
        while (size-- > 0) {
            for (int i = 0; i < index - 1; i++) {
                int tmp = queue.poll();
                queue.offer(tmp);
            }
            sj.add(String.valueOf(queue.poll()));
        }
        sb.append(sj).append(">");

        System.out.println(sb);
    }
}

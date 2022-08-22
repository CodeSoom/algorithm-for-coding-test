import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= size; i++) {
            queue.offer(i);
        }

        while (size-- > 1) {
            queue.poll();
            int out = queue.poll();
            queue.offer(out);
        }

        System.out.println(queue.poll());
    }
}

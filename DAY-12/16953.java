import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        long result = -1;
        Deque<long[]> queue = new ArrayDeque<>();
        queue.offer(new long[] { number, 1 });
        while (!queue.isEmpty()) {
            long[] now = queue.poll();
            if (now[0] == target) {
                result = (int) now[1];
                break;
            }

            long multi = now[0] * 2;
            long shift = now[0] * 10 + 1;
            if (multi <= target) {
                queue.offer(new long[] { multi, now[1] + 1 });
            }
            if (shift <= target) {
                queue.offer(new long[] { shift, now[1] + 1 });
            }
        }

        System.out.println(result);
    }
}

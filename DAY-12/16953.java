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
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { number, 1 });
        int MAX = (int) 1e9 + 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == target) {
                result = now[1];
                break;
            }

            int multi = now[0] * 2;
            long shift = (long) now[0] * 10 + 1;
            if (multi <= target) {
                queue.offer(new int[] { multi, now[1] + 1 });
            }
            if (shift < MAX && shift <= target) {
                queue.offer(new int[] { (int) shift, now[1] + 1 });
            }
        }

        System.out.println(result);
    }
}

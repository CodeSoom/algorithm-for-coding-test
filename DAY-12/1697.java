import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] moves = { 1, -1, 0 };
    static final int MAX = 200_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] checked = new boolean[MAX + 1];
        Deque<int[]> queue = new ArrayDeque<>();
        checked[N] = true;
        queue.offer(new int[] { N, 0 });

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == K) {
                System.out.println(now[1]);
                break;
            }
            // 1초 후 X - 1 , X + 1 , 2 * X
            for (int move : moves) {
                int dist;
                if (move == 0) {
                    dist = now[0] * 2;
                } else {
                    dist = now[0] + move;
                }

                if (dist >= 0 && dist <= 100_001 && !checked[dist]) {
                    checked[dist] = true;
                    queue.offer(new int[] { dist, now[1] + 1 });
                }
            }
        }
    }
}

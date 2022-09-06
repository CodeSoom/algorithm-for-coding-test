import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static int row, col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][col];

        for (int i = 0; i < row; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                map[i][j] = line[j] - 48;
            }
        }

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { 0, 0, 1 });
        map[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == row - 1 && now[1] == col - 1) {
                System.out.println(now[2]);
                break;
            }
            for (int[] move : dirs) {
                int moveX = now[0] + move[0];
                int moveY = now[1] + move[1];
                if (!isOutOfRange(moveX, moveY) && map[moveX][moveY] == 1) {
                    map[moveX][moveY] = 0;
                    queue.offer(new int[] { moveX, moveY, now[2] + 1 });
                }
            }
        }
    }

    public static boolean isOutOfRange(int x, int y) {
        return x >= row || x < 0 || y >= col || y < 0;
    }
}

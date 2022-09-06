import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static boolean[][] map;
    static int col, row;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            int positions = Integer.parseInt(st.nextToken());

            map = new boolean[row][col];

            for (int i = 0; i < positions; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = true;
            }

            // 배추 영역 찾기
            int areaCount = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j]) {
                        checkArea(i, j);
                        areaCount++;
                    }
                }
            }

            System.out.println(areaCount);
        }
    }

    public static void checkArea(int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { x, y });
        map[x][y] = false;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int[] moves : dirs) {
                int moveX = moves[0] + now[0];
                int moveY = moves[1] + now[1];
                if (!isOutOfRange(moveX, moveY) && map[moveX][moveY]) {
                    map[moveX][moveY] = false;
                    queue.offer(new int[] { moveX, moveY });
                }
            }
        }
    }

    public static boolean isOutOfRange(int x, int y) {
        return y >= col || y < 0 || x >= row || x < 0;
    }
}

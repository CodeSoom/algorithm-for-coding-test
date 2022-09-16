import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static int[][] map;
    static boolean[][] checked;
    static int N, M, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        checked = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                checked[i][j] = true;
                dfs(i, j, map[i][j], 1);
                checked[i][j] = false;
            }
        }
        System.out.println(result);
    }

    public static void dfs(int row, int col, int sum, int count) {
        if (count == 4) {
            result = Math.max(sum, result);
            return;
        }

        for (int[] dir : dirs) {
            int moveRow = row + dir[0];
            int moveCol = col + dir[1];
            if (!isOutOfRange(moveRow, moveCol) && !checked[moveRow][moveCol]) {
                if (count == 2) {
                    checked[moveRow][moveCol] = true;
                    dfs(row, col, sum + map[moveRow][moveCol], count + 1);
                    checked[moveRow][moveCol] = false;
                }
                checked[moveRow][moveCol] = true;
                dfs(moveRow, moveCol, sum + map[moveRow][moveCol], count + 1);
                checked[moveRow][moveCol] = false;
            }
        }
    }

    public static boolean isOutOfRange(int row, int col) {
        return row < 0 || row >= N || col < 0 || col >= M;
    }
}

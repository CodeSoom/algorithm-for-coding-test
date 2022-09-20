
import java.io.*;

class Main {
    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < size; j++) {
                map[i][j] = line[j] - 48;
            }
        }
        dfs(0, 0, size);

        System.out.println(sb);
    }

    public static void dfs(int row, int col, int size) {

        if (isPossible(row, col, size)) {
            sb.append(map[row][col]);
            return;
        }

        int half = size / 2;
        sb.append("(");
        // 1/4 분면
        dfs(row, col, half);
        // 2/4 분면
        dfs(row, col + half, half);
        // 3/4 분면
        dfs(row + half, col, half);
        // 4/4 분면
        dfs(row + half, col + half, half);
        sb.append(")");
    }

    public static boolean isPossible(int x, int y, int size) {
        int value = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (value != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

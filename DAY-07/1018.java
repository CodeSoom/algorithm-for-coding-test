import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        map = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                map[i][j] = line[j] == 'B';
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < row - 7; i++) {
            for (int j = 0; j < col - 7; j++) {
                int changeCount = findChangeCount(i, j);
                result = Math.min(result, changeCount);
            }
        }
        System.out.println(result);
    }

    public static int findChangeCount(int y, int x) {
        // B = true
        // W = false
        int tile1Count = 0;
        int tile2Count = 0;
        boolean tile1 = map[y][x];
        boolean tile2 = !map[y][x];
        for (int i = y; i < y + 8; i++) {
            for (int j = x; j < x + 8; j++) {
                boolean cell = map[i][j];
                if (tile1 == cell) {
                    tile1Count++;
                }
                if (tile2 == cell) {
                    tile2Count++;
                }
                tile1 = !tile1;
                tile2 = !tile2;
            }
            tile1 = !tile1;
            tile2 = !tile2;
        }
        return Math.min(tile1Count, tile2Count);
    }
}

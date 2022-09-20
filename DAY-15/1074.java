import java.io.*;
import java.util.*;

class Main {
    static int count, row, col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int shift = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        count = 0;
        int size = 1 << shift;

        dfs(0, 0, size);
        System.out.println(count);
    }

    public static void dfs(int r, int c, int size) {
        if (size == 1) {
            return;
        }

        int halfSize = size / 2;

        // 1/4 분면
        if (row < r + halfSize && col < c + halfSize) {
            dfs(r, c, halfSize);
        }
        // 2/4 분면
        else if (row < r + halfSize && col >= c + halfSize) {
            count += size * size / 4;
            dfs(r, c + halfSize, halfSize);
        }
        // 3/4 분면
        else if (row >= r + halfSize && col < c + halfSize) {
            count += size * size / 4 * 2;
            dfs(r + halfSize, c, halfSize);
        }
        // 4/4 분면
        else if (row >= r + halfSize && col >= c + halfSize) {
            count += size * size / 4 * 3;
            dfs(r + halfSize, c + halfSize, halfSize);
        }
    }
}

import java.io.*;
import java.util.*;

class Main {
    static int[][] map;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        map = new int[size][size];
        result = new int[2];
        StringTokenizer st;
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, size, 0, size);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static void dfs(int r, int mr, int c, int mc) {
        // System.out.println(r + " " + mr + " " + c + " " + mc);
        int tmp = map[r][c];
        if (r == mr && r == c && c == mc) {
            result[tmp]++;
            return;
        }
        boolean status = true;
        loop: for (int i = r; i < mr; i++) {
            for (int j = c; j < mc; j++) {
                if (tmp != map[i][j]) {
                    status = false;
                    break loop;
                }
            }
        }

        if (status) {
            result[tmp]++;
        } else {
            int rMid = (r + mr) / 2;
            int cMid = (c + mc) / 2;
            // 1/4 분면
            dfs(r, rMid, c, cMid);
            // 2/4 분면
            dfs(r, rMid, cMid, mc);
            // 3/4 분면
            dfs(rMid, mr, c, cMid);
            // 4/4 분면
            dfs(rMid, mr, cMid, mc);
        }
    }

}

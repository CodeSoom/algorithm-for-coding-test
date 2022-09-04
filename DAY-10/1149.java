import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int homeCount = Integer.parseInt(br.readLine());
        map = new int[homeCount][3];

        for (int i = 0; i < homeCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        // 대각선으로만 칠할 수 있다
        for (int i = 1; i < homeCount; i++) {
            map[i][0] = Math.min(map[i - 1][1], map[i - 1][2]) + map[i][0];
            map[i][1] = Math.min(map[i - 1][0], map[i - 1][2]) + map[i][1];
            map[i][2] = Math.min(map[i - 1][0], map[i - 1][1]) + map[i][2];
        }

        System.out.println(Math.min(map[homeCount - 1][2], Math.min(map[homeCount - 1][0], map[homeCount - 1][1])));
    }
}

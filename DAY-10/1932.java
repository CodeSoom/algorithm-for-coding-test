import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        map = new int[size][size * 2];
        dp = new int[size][size * 2];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                dp[i][j] = value;
            }
        }

        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int left = j;
                int right = j + 1;
                if (left >= 0) {
                    dp[i][j] = Math.max(dp[i][j], map[i][j] + dp[i + 1][left]);
                }
                if (right < size) {
                    dp[i][j] = Math.max(dp[i][j], map[i][j] + dp[i + 1][right]);
                }
            }
        }

        System.out.println(dp[0][0]);
    }
}

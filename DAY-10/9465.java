import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int size = Integer.parseInt(br.readLine());
            map = new int[2][size];
            int result = 0;
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < size; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    map[i][j] = value;
                    result = Math.max(result, value);
                }
            }
            if (size <= 1) {
                System.out.println(result);
                continue;
            }
            map[0][1] += map[1][0];
            map[1][1] += map[0][0];
            for (int i = 2; i < size; i++) {
                map[0][i] = Math.max(map[1][i - 2], map[1][i - 1]) + map[0][i];
                map[1][i] = Math.max(map[0][i - 2], map[0][i - 1]) + map[1][i];
            }
            System.out.println(Math.max(map[0][size - 1], map[1][size - 1]));
        }

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int blocks = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][col];

        int maxHeight = Integer.MIN_VALUE;
        int minHeight = Integer.MAX_VALUE;

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }

        // 제거 2초
        // 채우기 1초
        int resultTime = Integer.MAX_VALUE;
        int resultHeight = Integer.MIN_VALUE;
        for (int height = minHeight; height <= maxHeight; height++) {
            int tmpTime = 0;
            int tmpBlocks = blocks;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int diff = Math.abs(height - map[i][j]);
                    if (map[i][j] < height) {
                        tmpBlocks -= diff;
                        tmpTime += diff;
                        continue;
                    }
                    tmpBlocks += diff;
                    tmpTime += diff * 2;
                }
            }

            if (tmpBlocks < 0) {
                continue;
            }

            // 최소 시간과 땅의 높이
            if (resultTime >= tmpTime) {
                resultTime = tmpTime;
                resultHeight = height;
            }
        }
        System.out.println(resultTime + " " + resultHeight);
    }
}

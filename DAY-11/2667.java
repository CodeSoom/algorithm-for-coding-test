import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static int[][] map;
    static int size;
    static List<Integer> results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        map = new int[size][size];
        results = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < size; j++) {
                map[i][j] = line[j] - 48;
            }
        }

        // 단지 찾기
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 1) {
                    checkArea(i, j);
                }
            }
        }
        Collections.sort(results);
        System.out.println(results.size());
        results.forEach(System.out::println);
    }

    public static void checkArea(int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { x, y });
        map[x][y] = 0;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int[] moves : dirs) {
                int moveX = moves[0] + now[0];
                int moveY = moves[1] + now[1];
                if (!isOutOfRange(moveX, moveY) && map[moveX][moveY] == 1) {
                    map[moveX][moveY] = 0;
                    queue.offer(new int[] { moveX, moveY });
                    count++;
                }
            }
        }
        results.add(count);
    }

    public static boolean isOutOfRange(int x, int y) {
        return y >= size || y < 0 || x >= size || x < 0;
    }
}

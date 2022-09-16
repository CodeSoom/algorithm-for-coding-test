import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Fish implements Comparable<Fish> {
    int row;
    int col;
    int size;
    int eat;
    int dist;

    public Fish(int row, int col, int size, int eat, int dist) {
        this.row = row;
        this.col = col;
        this.size = size;
        this.eat = eat;
        this.dist = dist;
    }

    @Override
    public int compareTo(Fish o) {
        if (this.dist == o.dist) {
            if (this.row == o.row) {
                return this.col - o.col;
            }
            return this.row - o.row;
        }
        return this.dist - o.dist;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fish{");
        sb.append("row=").append(row);
        sb.append(", col=").append(col);
        sb.append(", size=").append(size);
        sb.append(", eat=").append(eat);
        sb.append(", dist=").append(dist);
        sb.append('}');
        return sb.toString();
    }
}

public class Main {
    static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static int[][] map;
    static Fish babyShark;
    static int size, feedCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        feedCount = 0;

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value > 0 && value <= 6) {
                    feedCount++;
                } else if (value == 9) {
                    babyShark = new Fish(i, j, 2, 0, 0);
                    map[i][j] = 0;
                }
            }
        }

        if (feedCount <= 0) {
            System.out.println(0);
        } else {
            System.out.println(bfs(babyShark));
        }
    }

    public static int bfs(Fish babyShark) {
        Queue<Fish> feeds = new PriorityQueue<>();
        Deque<Fish> shark = new ArrayDeque<>();
        shark.offer(babyShark);
        int result = 0;
        while (true) {
            boolean[][] checked = new boolean[size][size];
            while (!shark.isEmpty()) {
                Fish now = shark.poll();
                checked[now.row][now.col] = true;
                for (int[] dir : dirs) {
                    int moveRow = dir[0] + now.row;
                    int moveCol = dir[1] + now.col;
                    if (!isOutOfRange(moveRow, moveCol) && !checked[moveRow][moveCol]
                            && map[moveRow][moveCol] <= now.size) {
                        int fishSize = map[moveRow][moveCol];
                        checked[moveRow][moveCol] = true;
                        if (fishSize < now.size && fishSize != 0) {
                            feeds.offer(new Fish(moveRow, moveCol, now.size, now.eat + 1, now.dist + 1));
                        }
                        shark.offer(new Fish(moveRow, moveCol, now.size, now.eat, now.dist + 1));
                    }
                }
            }

            if (feeds.isEmpty()) {
                return result;
            }

            Fish feed = feeds.poll();
            if (feed.size <= feed.eat) {
                feed.size++;
                feed.eat = 0;
            }
            map[feed.row][feed.col] = 0;
            shark.offer(feed);
            feeds.clear();
            result += feed.dist;
            feed.dist = 0;
        }
    }

    public static boolean isOutOfRange(int row, int col) {
        return row < 0 || row >= size || col < 0 || col >= size;
    }
}

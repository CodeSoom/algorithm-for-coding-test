import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> resultList = new ArrayList<>();
    static int[] distArr;
    static boolean[] checked;
    static int cityCount, edgeCount, targetCost, startCity;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cityCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        targetCost = Integer.parseInt(st.nextToken());
        startCity = Integer.parseInt(st.nextToken());
        // distArr = new int[cityCount + 1];
        // checked = new boolean[cityCount + 1];
        distArr = new int[300001];
        checked = new boolean[300001];
        Arrays.fill(distArr, Integer.MAX_VALUE);
        for (int i = 0; i < 300001; i++)
            list.add(new ArrayList<Integer>());
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
        }

        bfs();
        if (resultList.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(resultList);
            for (int value : resultList)
                System.out.println(value);
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] { startCity, 0 });
        distArr[startCity] = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowCity = now[0];
            int cost = now[1];
            if (cost + 1 > targetCost)
                continue;
            for (int city : list.get(nowCity)) {
                if (distArr[city] > cost + 1) {
                    distArr[city] = cost + 1;
                    queue.offer(new int[] { city, cost + 1 });
                    if (cost + 1 == targetCost)
                        resultList.add(city);
                }
            }
        }
    }
}
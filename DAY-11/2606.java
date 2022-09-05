import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCount = Integer.parseInt(br.readLine());
        int edgeCount = Integer.parseInt(br.readLine());
        final int ROOT = 1;

        boolean[] visited = new boolean[nodeCount + 1];
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            edges.get(node1).add(node2);
            edges.get(node2).add(node1);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(ROOT);
        int count = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;
            for (int nearNode : edges.get(now)) {
                if (!visited[nearNode]) {
                    visited[nearNode] = true;
                    queue.offer(nearNode);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

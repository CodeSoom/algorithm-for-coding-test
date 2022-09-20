import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Move implements Comparable<Move> {
    int node;
    int cost;

    public Move(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Move o) {
        return (this.cost - o.cost);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        List<List<Move>> edges = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            edges.add(new ArrayList<>());
        }

        int startNode = Integer.parseInt(br.readLine()) - 1;

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            edges.get(start).add(new Move(end, cost));
        }

        int[] costs = new int[nodeCount];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[startNode] = 0;
        Queue<Move> queue = new PriorityQueue<>();
        queue.offer(new Move(startNode, 0));
        while (!queue.isEmpty()) {
            Move now = queue.poll();
            for (Move near : edges.get(now.node)) {
                if (costs[near.node] > near.cost + now.cost) {
                    costs[near.node] = near.cost + now.cost;
                    queue.offer(new Move(near.node, costs[near.node]));
                }
            }
        }

        for (int cost : costs) {
            System.out.println(cost == Integer.MAX_VALUE ? "INF" : cost);
        }
    }
}

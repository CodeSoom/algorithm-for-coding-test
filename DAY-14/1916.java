import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Move implements Comparable<Move> {
    int node;
    long cost;

    public Move(int node, long cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Move o) {
        return (int) (this.cost - o.cost);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCount = Integer.parseInt(br.readLine());
        int edgeCount = Integer.parseInt(br.readLine());

        List<List<Move>> edges = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            edges.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            edges.get(start).add(new Move(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        long[] costs = new long[nodeCount];
        Arrays.fill(costs, Long.MAX_VALUE);
        costs[start] = 0;
        Queue<Move> queue = new PriorityQueue<>();
        queue.offer(new Move(start, 0));
        long result = 0;
        while (!queue.isEmpty()) {
            Move now = queue.poll();
            if (now.node == end) {
                result = now.cost;
                break;
            }
            for (Move near : edges.get(now.node)) {
                if (costs[near.node] > near.cost + now.cost) {
                    costs[near.node] = near.cost + now.cost;
                    queue.offer(new Move(near.node, costs[near.node]));
                }
            }
        }

        System.out.println(result);
    }
}

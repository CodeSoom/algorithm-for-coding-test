import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int searchRange = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        int[][] costs = new int[nodeSize][nodeSize];
        int[] items = new int[nodeSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nodeSize; i++) {
            items[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(costs[i], 16);
            costs[i][i] = 0;
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()) - 1;
            int node2 = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            costs[node1][node2] = cost;
            costs[node2][node1] = cost;
        }

        for (int mid = 0; mid < nodeSize; mid++) {
            for (int start = 0; start < nodeSize; start++) {
                for (int end = 0; end < nodeSize; end++) {
                    costs[start][end] = Math.min(costs[start][end], costs[start][mid] + costs[mid][end]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < nodeSize; i++) {
            int tmp = 0;
            for (int j = 0; j < nodeSize; j++) {
                if (costs[i][j] <= searchRange) {
                    tmp += items[j];
                }
            }
            max = Math.max(tmp, max);
        }

        System.out.println(max);
    }
}

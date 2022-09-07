import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int MAX = 101;
        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        int[][] relation = new int[nodeSize][nodeSize];
        for (int i = 0; i < nodeSize; i++) {
            Arrays.fill(relation[i], MAX);
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()) - 1;
            int node2 = Integer.parseInt(st.nextToken()) - 1;
            relation[node1][node2] = 1;
            relation[node2][node1] = 1;
        }

        for (int mid = 0; mid < nodeSize; mid++) {
            for (int start = 0; start < nodeSize; start++) {
                for (int end = 0; end < nodeSize; end++) {
                    relation[start][end] = Math.min(relation[start][end], relation[start][mid] + relation[mid][end]);
                }
            }
        }

        int result = 1;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < nodeSize; i++) {
            int tmpCount = 0;
            for (int j = 0; j < nodeSize; j++) {
                tmpCount += relation[i][j];
            }
            if (count > tmpCount) {
                count = tmpCount;
                result = i + 1;
            }
        }

        System.out.println(result);
    }
}

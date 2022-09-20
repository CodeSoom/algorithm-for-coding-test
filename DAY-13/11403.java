import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[][] relations = new int[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                relations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int mid = 0; mid < size; mid++) {
            for (int start = 0; start < size; start++) {
                for (int end = 0; end < size; end++) {
                    if (relations[start][mid] == 1 && relations[mid][end] == 1) {
                        relations[start][end] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(relations[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

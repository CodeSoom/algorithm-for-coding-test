import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[] print;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        print = new int[M];

        dfs(1, 0);
    }

    public static void dfs(int number, int count) {
        if (count == M) {
            for (int val : print) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = number; i <= N; i++) {
            print[count] = i;
            dfs(i + 1, count + 1);
        }
    }
}

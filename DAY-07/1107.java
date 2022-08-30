import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int NOW = 100;
    static int target, min;
    static boolean[] broken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());
        int brokenSize = Integer.parseInt(br.readLine());
        broken = new boolean[10];

        if (brokenSize > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < brokenSize; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        min = Math.abs(target - NOW);
        if (min > 0) {
            dfs(0, "");
        }
        System.out.println(min);
    }

    public static void dfs(int index, String channel) {
        for (int i = 0; i < 10; i++) {
            if (!broken[i]) {
                String newChannel = channel + i;
                int cnt = Math.abs(target - Integer.parseInt(newChannel)) + newChannel.length();
                min = Math.min(min, cnt);
                if (index < 6) {
                    dfs(index + 1, newChannel);
                }
            }
        }
    }
}

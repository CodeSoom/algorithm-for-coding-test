import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        /**
         * https://kwanghyuk.tistory.com/5
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        dp = new int[size + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= size; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[size]);
    }
}

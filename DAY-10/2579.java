import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] scores;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        /**
         * https://st-lab.tistory.com/132
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        scores = new int[size + 1];
        dp = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = scores[1];

        if (size >= 2) {
            dp[2] = scores[1] + scores[2];
        }

        for (int i = 3; i <= size; i++) {
            // Max({이전 계단을 포함하지 않은 누적 점수} , {이전 계단을 포함한 누적 점수}) + 현재 계단 점수
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + scores[i - 1]) + scores[i];
        }

        System.out.println(dp[size]);
    }
}

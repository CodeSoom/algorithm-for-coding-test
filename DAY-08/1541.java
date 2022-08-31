import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 숫자와 기호를 다 분리하여 조합으로 다 계산해주는 방식으로 풀려고 했다
     *
     * https://st-lab.tistory.com/148
     * 이 블로그 글을 참고하여 풀었다
     * '+'연산을 먼저 하는 아이디어를 떠올린게 대단하다
     * 조합을 고민한게 창피할 정도로 간단하게 푼다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;
        StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
        while (sub.hasMoreTokens()) {
            int tmp = 0;

            StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");
            while (add.hasMoreTokens()) {
                tmp += Integer.parseInt(add.nextToken());
            }

            sum = sum == Integer.MAX_VALUE ? tmp : sum - tmp;
        }

        System.out.println(sum);
    }
}

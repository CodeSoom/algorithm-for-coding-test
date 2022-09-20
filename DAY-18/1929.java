import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        prime = setPrime(max);

        StringBuilder sb = new StringBuilder();
        for (int i = min; i <= max; i++) {
            if (!prime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean[] setPrime(int number) {
        boolean[] result = new boolean[number + 1];
        result[0] = true;
        result[1] = true;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (result[i]) {
                continue;
            }
            for (int j = i * i; j <= number; j += i) {
                result[j] = true;
            }
        }

        return result;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] sizes = new int[K];
        for (int i = 0; i < K; i++) {
            sizes[i] = Integer.parseInt(br.readLine());
        }

        long left = 0;
        long right = (long) 1e10;
        long result = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            int count = 0;
            for (int size : sizes) {
                count += size / mid;
                if (count >= N) {
                    break;
                }
            }
            if (count >= N) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}

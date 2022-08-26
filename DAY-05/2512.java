import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] budgets = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxBudget = 0;
        for (int i = 0; i < budgets.length; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            maxBudget = Math.max(budgets[i], maxBudget);
        }
        int max = Integer.parseInt(br.readLine());

        int left = 0;
        int right = max;

        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sumBudget = 0;
            for (int budget : budgets) {
                if (sumBudget > max) {
                    break;
                }
                sumBudget += Math.min(mid, budget);
            }
            if (sumBudget <= max) {
                result = Math.max(mid, result);
            }

            if (sumBudget > max) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(Math.min(result, maxBudget));
    }
}

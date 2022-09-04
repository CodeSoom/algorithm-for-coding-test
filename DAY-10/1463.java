import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] numbers = new int[number + 1];

        for (int i = 2; i <= number; i++) {
            numbers[i] = numbers[i - 1] + 1;
            if (i % 2 == 0) {
                numbers[i] = Math.min(numbers[i], numbers[i / 2] + 1);
            }
            if (i % 3 == 0) {
                numbers[i] = Math.min(numbers[i], numbers[i / 3] + 1);
            }
        }

        System.out.println(numbers[number]);
    }
}

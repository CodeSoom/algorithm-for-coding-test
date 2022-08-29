import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] numbers = new int[size];
        int[] sorting = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers[i] = number;
            sorting[i] = number;
        }

        Arrays.sort(sorting);

        Map<Integer, Integer> map = new HashMap<>();

        int number = sorting[0];
        int priority = 0;
        for (int i = 1; i < size; i++) {
            if (number != sorting[i]) {
                map.put(number, priority);
                priority++;
                number = sorting[i];
            }
        }

        map.put(number, priority);

        StringJoiner sj = new StringJoiner(" ");
        for (int key : numbers) {
            sj.add(String.valueOf(map.get(key)));
        }

        System.out.println(sj);
    }
}

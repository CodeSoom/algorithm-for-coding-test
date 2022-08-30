import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        char[] compare = br.readLine().toCharArray();

        int count = 0;
        main: for (int i = 0; i <= line.length - compare.length; i++) {
            int index = 0;
            if (line[i] != compare[index]) {
                continue;
            }
            for (index = 0; index < compare.length; index++) {
                if (line[i + index] != compare[index]) {
                    continue main;
                }
            }
            count++;
            i += compare.length - 1;
        }
        System.out.println(count);
    }
}

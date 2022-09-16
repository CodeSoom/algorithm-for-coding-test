import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int passwordSize, charSize;
    static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    static String[] chars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        passwordSize = Integer.parseInt(st.nextToken());
        charSize = Integer.parseInt(st.nextToken());

        chars = br.readLine().split(" ");
        Arrays.sort(chars);

        dfs(0, 0, "");
    }

    public static void dfs(int index, int count, String sum) {
        if (passwordSize == count) {
            if (alphabetCheck(sum)) {
                System.out.println(sum);
            }
            return;
        }

        for (int i = index; i < charSize; i++) {
            dfs(i + 1, count + 1, sum + chars[i]);
        }
    }

    public static boolean alphabetCheck(String line) {
        int vowelsCount = 0;
        int consonantsCount = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (vowels.contains(ch)) {
                vowelsCount++;
                continue;
            }
            consonantsCount++;
        }
        return vowelsCount >= 1 && consonantsCount >= 2;
    }
}

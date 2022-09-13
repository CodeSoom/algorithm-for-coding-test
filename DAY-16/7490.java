import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static List<String> results;
    static int max;
    static char[] operations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            results = new ArrayList<>();
            max = Integer.parseInt(br.readLine());
            operations = new char[] { ' ', '+', '-' };
            dfs(1, "1");

            for (String result : results) {
                System.out.println(result);
            }
            System.out.println();
        }
    }

    public static void dfs(int count, String express) {
        if (count == max) {
            if (isZero(express)) {
                results.add(express);
            }
            return;
        }

        for (char ch : operations) {
            dfs(count + 1, express + ch + (count + 1));
        }
    }

    public static boolean isZero(String express) {
        String replace = express.replaceAll(" ", "");
        StringTokenizer st = new StringTokenizer(replace, "+|-", true);
        int tmp = Integer.parseInt(st.nextToken());
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("+")) {
                tmp += Integer.parseInt(st.nextToken());
            } else if (token.equals("-")) {
                tmp -= Integer.parseInt(st.nextToken());
            }
        }
        return tmp == 0;
    }
}

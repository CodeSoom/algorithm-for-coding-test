import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (testcase-- > 0) {
            Map<String, Integer> items = new HashMap<String, Integer>();
            int itemCount = Integer.parseInt(br.readLine());

            while (itemCount-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String kind = st.nextToken();
                items.put(kind, items.getOrDefault(kind, 0) + 1);
            }

            int multi = 1;
            for (String key : items.keySet()) {
                multi *= items.get(key) + 1;
            }

            sb.append(multi - 1).append("\n");
        }
        System.out.println(sb.toString());
    }
}
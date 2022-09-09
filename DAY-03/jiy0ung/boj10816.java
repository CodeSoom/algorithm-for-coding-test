import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1. 숫자 카드에 적힌 수를 키로, 개수를 값으로 가지는 맵 만듦
        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            String key = st.nextToken();
            
            // 2. n개의 카드를 입력받아서 맵에 넣는다.
            if(map.get(key) == null) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        // 3. m개의 카드를 입력받아서 각 숫자키에 대한 값을 출력한다.
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            String key = st.nextToken();
            
            if(map.get(key) == null) {
                sb.append(0 + " ");
            } else {
                sb.append(map.get(key) + " ");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        // 1. n, m을 입력받는다.
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // 2. 이름을 key로, 개수를 값으로 가지는 맵을 만든다.
        HashMap<String, Integer> map = new HashMap<>();
        
        // 3. n명의 이름을 입력받아서 맵에서 해당 값을 증가시킨다.
        for(int i = 0; i < n; i++) {
            String key = br.readLine();
            
            if(map.get(key) == null) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        
        // 4. m명의 이름을 입력받아서 맵에서 해당 값을 증가시킨다.
        for(int i = 0; i < m; i++) {
            String key = br.readLine();

            if(map.get(key) == null) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        // 5. 맵의 키 값을 알파벳순으로 정렬한다.
        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort(Comparator.naturalOrder());
        
        // 6. 맵을 돌면서 값이 2 이상인 것을 찾으면 cnt를 증가시키고, 명단 문자열에 더한다.
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(String key : keyList) {
            int value = map.get(key);
            if(value >= 2) {
                cnt++;
                sb.append(key + "\n");
            }
        }
        
        // 6. cnt와 명단을 출력한다.
        System.out.println(cnt + "\n" + sb);
    }
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

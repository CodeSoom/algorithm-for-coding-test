import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    HashMap<String, Integer> map;
    
    // 의상을 입을 수 있는 모든 경우의 수 세기
    public int countAllCases() {
        int cnt = 1;
        
        for(int val : map.values()) {
            cnt *= (val + 1); // val = 옷을 각각 하나씩 선택하는 경우의 수, 1 = 한 종류를 전부 선택하지 않는 경우의 수
        }
        cnt -= 1; // 아무 종류도 선택하지 않는 경우 빼줌
        
        return cnt;
    }
    
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 입력
        
        for(int i = 0; i < testCase; i++) {
            map = new HashMap<>();
            
            int n = Integer.parseInt(br.readLine()); // n 입력
            
            for(int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken(); // (의상 이름은 필요 없음)
                String key = st.nextToken();

                // 맵에 특정 종류에 대한 옷 개수를 넣어줌
                if(map.get(key) == null) {
                    map.put(key, 1);
                } else {
                    map.put(key, map.get(key) + 1);
                }
            }
            
            int answer = countAllCases(); // 모든 경우의 수 세기
            System.out.println(answer);
        }
    }
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

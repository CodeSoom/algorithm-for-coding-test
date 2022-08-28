import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 큐에 N번까지의 사람 넣기
    public void addPeople(Queue<Integer> q, int n) {
        for(int i = 1; i <= n; i++) {
            q.add(i);
        }
    }

    // 요세푸스 순열 만들기
    public void makeJosephus(Queue<Integer> q, int k, ArrayList<Integer> josephus) {
        int cnt = 1; // 몇 번째 사람인지

        while(q.size() > 0) {
            int cur = q.peek(); // 첫 번째 값

            if(cnt == k) { // k번째 사람 제거
                josephus.add(cur); // 요세푸스 순열에 넣어주고
                q.remove(); // 제거
                cnt = 1;
            }
            else {
                q.remove(); // 첫 번째 값 제거하고
                q.add(cur); // 맨 뒤에 다시 넣어줌
                cnt++;
            }
        }
    }
    
    public void print(ArrayList<Integer> josephus) {
        System.out.print("<");
        for(int i = 0; i < josephus.size(); i++) {
            System.out.print(josephus.get(i));

            if(i != josephus.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(">");
    }
    
    public void solution(int n, int k) {
        // 1. 1 ~ N까지 큐에 넣는다.
        Queue<Integer> q = new LinkedList<>();
        addPeople(q, n);
        
        // 2. 요세푸스 순열을 만든다.
        ArrayList<Integer> josephus = new ArrayList<>();
        makeJosephus(q, k, josephus);
        
        // 3. 요세푸스 순열을 출력한다.
        print(josephus);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        new Main().solution(n, k);
    }
}

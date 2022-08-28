import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // 동작
    public void move(Queue<Integer> q) {
        while(q.size() != 1) {
            q.remove(); // 첫 번째 값 삭제
            int first = q.poll(); // 첫 번째 값 꺼낸 후 삭제
            q.offer(first); // 꺼낸 값을 큐에 추가
        }
    }

    // 큐에 카드 넣기
    public void addCard(Queue<Integer> q, int n) {
        for(int i = 1; i <= n; i++) {
            q.add(i);
        }
    }

    public int solution(int n) {
        // 1. 큐에 1 ~ N까지 넣는다.
        Queue<Integer> q = new LinkedList<>();
        addCard(q, n);

        // 2. 동작을 반복한다.
        move(q);

        // 3. 큐의 첫 번째 값을 return 한다.
        int answer = q.peek();
        return answer;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer = new Main().solution(n);
        System.out.println(answer);
    }
}

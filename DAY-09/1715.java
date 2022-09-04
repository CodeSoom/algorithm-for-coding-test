import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 참고 https://hyeyun.tistory.com/entry/%EB%B0%B1%EC%A4%80-BOJ-1715-%EC%B9%B4%EB%93%9C-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0-%EC%9E%90%EB%B0%94-JAVA
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> pq = new PriorityQueue<>();

        int size = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < size ; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            count += sum;
            pq.offer(sum);
        }

        System.out.println(count);
    }
}

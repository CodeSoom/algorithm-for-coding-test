import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        Queue<Integer> heap = new PriorityQueue<>();
        for(int i = 0 ; i < size ; i++){
            int number = Integer.parseInt(br.readLine());
            if(number == 0){
                Integer val = heap.poll();
                System.out.println(val == null ? "0" : val);;
                continue;
            }
            heap.offer(number);
        }
    }
}

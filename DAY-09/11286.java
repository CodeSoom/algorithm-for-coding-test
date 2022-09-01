import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Number implements Comparable<Number> {
    int number;
    int abs;

    public Number(int number) {
        this.number = number;
        this.abs = Math.abs(number);
    }

    @Override
    public int compareTo(Number o) {
        if(this.abs == o.abs){
            return this.number - o.number;
        }
        return this.abs - o.abs;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        Queue<Number> heap = new PriorityQueue<>();
        for(int i = 0 ; i < size ; i++){
            int number = Integer.parseInt(br.readLine());
            if(number == 0){
                Number val = heap.poll();
                System.out.println(val == null ? "0" : val.number);;
                continue;
            }
            heap.offer(new Number(number));
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

class Document {
    int number;
    int priority;

    public Document(int number, int priority) {
        this.number = number;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Document.class.getSimpleName() + "[", "]")
                .add("number=" + number)
                .add("priority=" + priority)
                .toString();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> priority = new PriorityQueue<>(Comparator.reverseOrder());
            Deque<Document> print = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                int pri = Integer.parseInt(st.nextToken());
                priority.offer(pri);
                print.offer(new Document(i, pri));
            }

            int count = 1;
            while (!priority.isEmpty()) {
                int pri = priority.peek();
                Document doc = print.poll();
                if (doc.priority == pri) {
                    priority.poll();
                    if (doc.number == index) {
                        break;
                    }
                    count++;
                } else {
                    print.offer(doc);
                }
            }
            System.out.println(count);
        }
    }
}

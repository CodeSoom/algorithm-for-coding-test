import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Doc {
    int importance;
    boolean isM;
}

public class Main {
    // 중요도가 더 큰 문서의 인덱스 반환
    public int getBiggerIdx(Queue<Doc> queue) {
        Queue<Doc> q = new LinkedList<>(queue);
        
        Doc front = q.poll(); // 맨 앞 문서
        int idx = 1; // 1번째 문서부터 비교할거임
        
        while(!q.isEmpty()) {
            Doc cur = q.poll();

            if(front.importance < cur.importance) { // 중요도가 더 큰 문서가 있는 경우
                return idx;
            }
            else {
                idx++;
            }
        }
        return -1; // 뒤에 중요도가 더 큰 문서가 없었으면 -1 반환
    }

    // 중요도가 더 큰 문서의 앞에 있는 문서들을 뒤로 다시 넣어줌
    public void addBack(Queue<Doc> queue, int biggerIdx) {
        int curIdx = 0;
        
        while(curIdx != biggerIdx) {
            queue.add(queue.poll()); // 맨 앞 문서를 빼서 뒤로 넣어줌
            curIdx++;
        }
    }
    
    // M 번째 문서가 몇 번째에 출력됐는지 반환
    public int printTask(Queue<Doc> queue) {
        int answer = 0;
        
        while(true) {
            Doc front = queue.peek();
            int biggerIdx = getBiggerIdx(queue);
            
            if(front.isM) { // 맨 앞 문서가 M 번째 문서인 경우
                if(biggerIdx == -1) { // 뒤에 중요도 더 큰 문서가 없으면
                    answer++; // 현재 문서까지 출력 횟수에 반영해야 하므로 증가
                    return answer; // 출력 횟수 반환
                } else {
                    addBack(queue, biggerIdx); // biggerIdx 전까지의 문서들을 뒤에 다시 넣어줌
                }
            } else {
                if(biggerIdx == -1) { // 뒤에 중요도 더 큰 문서가 없으면
                    queue.remove(); // 맨 앞 문서 출력
                    answer++; // 출력 횟수 증가
                } else {
                    addBack(queue, biggerIdx);
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력

        for(int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // n 입력
            int m = Integer.parseInt(st.nextToken()); // m 입력

            Queue<Doc> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            // 중요도 입력받고 큐에 넣기
            for(int j = 0; j < n; j++) {
                Doc inputDoc = new Doc();
                inputDoc.importance = Integer.parseInt(st.nextToken()); // 중요도 입력
                
                if(j == m) { // m번째 문서이면
                    inputDoc.isM = true;
                } else {
                    inputDoc.isM = false;
                }
                queue.add(inputDoc);
            }

            System.out.println(printTask(queue)); // 답 출력
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

import java.util.LinkedList;
import java.util.Scanner;

public class P1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            // Queue 연결 리스트
            LinkedList<int[]> q = new LinkedList<>();

            // {초기 위치, 중요도}
            for (int j = 0; j < N; j++) {
                q.offer(new int[] {j, sc.nextInt()});
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                // 가장 첫 번째 문서
                int[] front = q.poll();
                // front 가 가장 큰지 판별
                boolean isMax = true;

                // 큐에 남아 있는 문서들과 중요도 비교
                for (int k = 0; k < q.size(); k++) {

                    // 첫 번째 문서 보다 큐에 있는 k 번째 문서가 중요도가 클 경우
                    if (front[1] < q.get(k)[1]) {
                        // 뽑은 문서를 가장 뒤로 보냄
                        q.offer(front);

                        // 해당 k 번째 이전의 문서를 뒤로 보냄
                        for (int l = 0; l < k; l++) {
                            q.offer(q.poll());
                        }

                        // front 가 가장 큰 문서가 아니므로 false
                        isMax = false;
                        break;
                    }
                }

                // front 가 가장 큰 문서가 아닌 경우 반복
                if (!isMax) {
                    continue;
                }

                // front 가 가장 큰 문서이므로 poll 했으니 cnt++
                cnt++;

                // 찾는 문서라면 멈추고 저장
                if (front[0] == M) {
                    break;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}

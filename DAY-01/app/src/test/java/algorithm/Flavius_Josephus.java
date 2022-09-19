package algorithm;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * ## 미지의 것
 * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하라
 * ## 자료
 * - 요세푸스
 * >> 원에서 사람들이 제거되는 순서
 * >> n 명의 원을 이루면서 k번째 사람을 제거한다.
 * >> 모두 제거될 때까지 지속된다.
 * <p>
 * ## 조건
 * - 양의 정수 K(≤ N)
 * - (1 ≤ K ≤ N ≤ 5,000)
 *
 * ## 계획
 * - N 만큼의 수를 입력 받는다.
 * - queue에 N만큼 수를 채운다.
 * - k 자리에 수를 반환한다.
 * - StringBuilder '<', ", ", ">" 를 채운다.
 *
 * ## 반성
 * - StringBuilder를 사용해서 '<'를 하는 방법을 몰랏다.
 * - queue.offer(queue.poll()) 의미를 알아야 한다.
 */

public class Flavius_Josephus {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new ArrayDeque<>();

        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        while (queue.size() > 1) {

            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll()); //
            }

            sb.append(queue.poll()).append(", ");
        }

        sb.append(queue.poll()).append('>');
        System.out.println(sb);

    }
}

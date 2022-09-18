package algorithm;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * [백준]2164 - 카드2
 * ## 미지의 것
 * N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하라.
 * ## 자료
 * - 1 ~ N장의 카드
 * - 한 장 남을 때까지 반복한다.
 * - 제일 위에 잇는 카드를 버린다.
 * - 그 다음 위에 있는 카드를 제일 아래로 옮긴다.
 * <p>
 * ## 조건
 * - 정수 N(1 <= N <= 500,000)이다.
 * <p>
 * ## 계획
 * - n의 수를 입력 받는다.
 * - 큐를 생성한다.
 * - 1 ~ 6만큼 큐에 담는다.
 * - 맨 앞에 수를 버린다.
 * - 그 다음 수를 뒤로 보낸다.
 * - queue 크기가 1이 될 때까지 반복한다.
 * <p>
 * ## 반성
 * - Queue의 함수를 잘 알고 있으면 쉽게 풀 수 있는 문제 이다.
 * - add(), offer() 두 차이를 알고 있어야 한다.
 * - remove, poll() 두 차이를 알고 있어야 한다.
 * - LinkedList로 Queue를 호출하는 것보다 다른 방법으로 부르는 것이 더 좋다.
 * - offer는 queue 값 뒤에서부터 차례대로 채워진다.
 * - poll는 queue 값 앞에서부터 반환된다.
 */

public class Card2 {

    public static int card(int n) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            queue.poll(); // 맨 앞의 수를 반환한다.
            queue.offer(queue.poll()); // 그 다음 수를 맨 뒤로 보낸다.
        }

        return queue.poll();//맨 앞의 수를 반환한다.
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = card(n);

        System.out.println("result = " + result);
    }

    @Test
    void result() {
        assertThat(card(6)).isEqualTo(4);
    }
}

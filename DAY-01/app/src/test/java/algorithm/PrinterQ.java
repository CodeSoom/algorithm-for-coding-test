package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ## 미지의 것
 * 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내라.
 * ## 자료
 * - 문서의 수
 * >> N(1 ≤ N ≤ 100)
 * - 중요도
 * >> 중요도는 1 이상 9 이하의 정수
 * ## 조건
 * -
 * -
 * <p>
 * ## 계획
 * -
 * -
 * <p>
 * ## 반성
 * -
 * -
 */

public class PrinterQ {

    public int solution(int testcase, int ... importance) {
        Deque<int[]> queue = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < testcase; i++) {
            queue.add(new int[]{i});
            System.out.println("i = " + i);
        }

        return 0;
    }

    @Test
    void result() {

        assertThat(solution(3, 1,0)).isEqualTo(1);
    }
}

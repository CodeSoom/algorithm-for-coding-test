import java.io.*;

class Main {
    static int[] map;
    static int size, result;

    /**
     * 참고 https://st-lab.tistory.com/118
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        map = new int[size];
        placed(0);
        System.out.println(result);
    }

    public static void placed(int count) {
        if (count == size) {
            result++;
            return;
        }

        for (int i = 0; i < size; i++) {
            map[count] = i;
            if (isPossible(count)) {
                placed(count + 1);
            }
        }
    }

    public static boolean isPossible(int count) {
        for (int i = 0; i < count; i++) {
            // 해당 열의 행과 i열의 행이 일치할경우 (같은 행에 존재할 경우)
            if (map[i] == map[count]) {
                return false;
            }

            // 대각선상에 놓여있는 경우
            // (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
            else if (Math.abs(count - i) == Math.abs(map[count] - map[i])) {
                return false;
            }
        }

        return true;
    }
}

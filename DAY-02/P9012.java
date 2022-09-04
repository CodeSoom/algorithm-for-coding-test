import java.util.Scanner;
import java.util.Stack;

public class P9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            Stack<Character> st = new Stack<>();
            String s = sc.next();

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    st.push('(');
                } else if (s.charAt(j) == ')') {
                    if (!st.empty()) {
                        st.pop();
                    } else {
                        st.push(')');
                        break;
                    }
                }
            }
            if (st.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            st.clear();
        }
    }
}

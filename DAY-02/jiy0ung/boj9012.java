import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    // 문자열이 VPS인지 체크
    public boolean chkVps(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int j = 0; j < s.length(); j++) {
            if(s.charAt(j) == '(') {
                stack.push(s.charAt(j));
            } else {
                if(stack.isEmpty()) { // ')'인데 스택이 비어있으면
                    return false;
                }
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()) { // 문자열을 끝까지 돌았는데 스택이 비어있지 않으면
            return false;
        }
        return true;
    }
    
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            String s = br.readLine();

            if(chkVps(s)) { // VPS 체크
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

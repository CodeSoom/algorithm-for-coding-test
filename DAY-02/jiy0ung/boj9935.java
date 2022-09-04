import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String explodeStr = br.readLine();
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
            
            if(stack.size() >= explodeStr.length()) {
                Boolean isExplodeStr = true;
                for(int j = 0; j < explodeStr.length(); j++) {
                    char cur = stack.get(stack.size() - explodeStr.length() + j);
                    if(cur != explodeStr.charAt(j)) {
                        isExplodeStr = false;
                        break;
                    }
                }
                
                if(isExplodeStr) {
                    for(int j = 0; j < explodeStr.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : stack) {
            sb.append(c);
        }
        if(sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

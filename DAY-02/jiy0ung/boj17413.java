import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    // 스택 출력
    public void printStack(Stack<Character> stack) {
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
    
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            
            if(cur == '<') { // '<'를 만나면
                printStack(stack); // 혹시 스택에 쌓인게 있으면 출력
                
                while(cur != '>') { // '>'를 만날 때까지 뒤집지 않고 출력
                    cur = input.charAt(i);
                    System.out.print(cur);
                    
                    if(cur == '>') {
                        break;
                    }
                    i++;
                }
            } else if (cur == ' ') { // 공백을 만나면
                printStack(stack); // 스택 출력
                System.out.print(" ");
            } else {
                stack.push(cur); // 공백 만날때까지 스택에 쌓음
            }
        }
        printStack(stack); // 문자열 끝까지 다 돌았으면 스택 출력
    }
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

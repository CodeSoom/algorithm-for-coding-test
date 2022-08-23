1import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        char[] line = br.readLine().toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        boolean bracketOpen = false;
        for(int i = 0 ; i < line.length ; i++){
            char ch = line[i];

            if(ch == '>'){
                bracketOpen = false;
                result.append(ch);
            }
            else if(ch == '<' || bracketOpen){
                allElementPop(result , stack);
                bracketOpen = true;
                result.append(ch);
            }
            else if(ch == ' '){
                if(bracketOpen){
                    result.append(ch);
                }
                else{
                    allElementPop(result , stack);
                    result.append(ch);
                }
            }
            else{
                stack.push(ch);
            }
        }
        allElementPop(result , stack);
        System.out.println(result);
    }

    public static void allElementPop(StringBuilder result , Deque<Character> stack){
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
    }
}

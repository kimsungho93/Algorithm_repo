import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); 
        String bomb = br.readLine(); 

        int bombLength = bomb.length();
        Stack<Character> stack = new Stack<>();

        IntStream.range(0, input.length()).forEach(i -> {
            stack.push(input.charAt(i)); 

            if (stack.size() >= bombLength) {
                boolean isBomb = true;
                for (int j = 0; j < bombLength; j++) {
                    if (stack.get(stack.size() - bombLength + j) != bomb.charAt(j)) {
                        isBomb = false; 
                        break;
                    }
                }
                if (isBomb) {
                    IntStream.range(0, bombLength).forEach(j -> stack.pop());
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);
        System.out.println(sb.length() > 0 ? sb : "FRULA");
    }
}

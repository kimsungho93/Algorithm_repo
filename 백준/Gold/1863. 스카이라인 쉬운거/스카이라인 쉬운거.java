import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static int min = 0; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()); 
            int y = Integer.parseInt(st.nextToken()); 

            updateSkyline(y); 
        }
        System.out.println(min); 
    }

    private static void updateSkyline(int y) {
        while (!stack.isEmpty() && stack.peek() > y) {
            stack.pop();
        }
        if (stack.isEmpty() || stack.peek() < y) {
            stack.push(y); 
            if (y > 0) { 
                min++;
            }
        }
    }
}

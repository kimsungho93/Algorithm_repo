import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Tower> stack = new ArrayDeque<>();
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().height < height) {
                stack.pop();
            }

            answer[i] = stack.isEmpty() ? 0 : stack.peek().index + 1;
            stack.push(new Tower(i, height));
        }

        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

class Tower {
    int index;
    int height;

    public Tower(int index, int height) {
        this.index = index;
        this.height = height;
    }
}


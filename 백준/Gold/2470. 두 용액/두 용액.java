import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] solutions = new long[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            solutions[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(solutions);
        
        int left = 0, right = N - 1;
        long answerLeft = solutions[left], answerRight = solutions[right];
        long minDiff = Math.abs(answerLeft + answerRight);

        while (left < right) {
            long sum = solutions[left] + solutions[right];
            long diff = Math.abs(sum);
            
            if (diff < minDiff) {
                minDiff = diff;
                answerLeft = solutions[left];
                answerRight = solutions[right];
            }
            
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        
        System.out.println(answerLeft + " " + answerRight);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int x = Integer.parseInt(line) * 10000000; // 구멍의 너비(cm -> nm 변환)
            int n = Integer.parseInt(br.readLine()); // 레고 조각의 수
            int[] pieces = new int[n];
            
            for (int i = 0; i < n; i++) {
                pieces[i] = Integer.parseInt(br.readLine());
            }
            
            Arrays.sort(pieces); // 레고 조각 정렬
            
            boolean found = false;
            for (int i = 0; i < n; i++) {
                int target = x - pieces[i];
                if (binarySearch(pieces, target, i + 1, n - 1)) { // 이분 탐색
                    System.out.println("yes " + pieces[i] + " " + target);
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                System.out.println("danger");
            }
        }
    }
    
    // 이분 탐색 메소드
    private static boolean binarySearch(int[] pieces, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (pieces[mid] == target) {
                return true;
            } else if (pieces[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}

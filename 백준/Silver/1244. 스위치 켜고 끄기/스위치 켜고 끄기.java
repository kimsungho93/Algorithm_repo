import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int switchCount = Integer.parseInt(br.readLine()); // 스위치의 개수
        String[] switchStates = br.readLine().split(" "); // 스위치의 초기 상태
        int studentCount = Integer.parseInt(br.readLine()); // 학생의 수
        
        boolean[] switches = new boolean[switchCount + 1]; // 스위치 상태 배열 (1부터 시작)
        
        // 스위치 초기 상태 설정
        for (int i = 1; i <= switchCount; i++) {
            switches[i] = switchStates[i - 1].equals("1");
        }
        
        // 학생별로 스위치 조작
        for (int i = 0; i < studentCount; i++) {
            String[] input = br.readLine().split(" ");
            int gender = Integer.parseInt(input[0]); // 학생의 성별
            int num = Integer.parseInt(input[1]); // 학생이 받은 번호
            
            if (gender == 1) { // 남학생의 경우
                for (int j = num; j <= switchCount; j += num) {
                    switches[j] = !switches[j];
                }
            } else { // 여학생의 경우
                switches[num] = !switches[num];
                int left = num - 1;
                int right = num + 1;
                while (left >= 1 && right <= switchCount && switches[left] == switches[right]) {
                    switches[left] = !switches[left];
                    switches[right] = !switches[right];
                    left--;
                    right++;
                }
            }
        }
        
        // 결과 출력
        for (int i = 1; i <= switchCount; i++) {
            System.out.print(switches[i] ? "1 " : "0 ");
            if (i % 20 == 0) System.out.println(); // 20개의 스위치마다 줄바꿈
        }
    }
}
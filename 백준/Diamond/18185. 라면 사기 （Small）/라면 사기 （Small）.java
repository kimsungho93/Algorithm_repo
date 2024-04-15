import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int count = st.countTokens();
        int result = 0;
        int[] inputArr = new int[count+2];
        inputArr[inputArr.length -2] = 0;
        inputArr[inputArr.length -1] = 0;
 
        if (N != count){
            System.out.println("2번째 입력을 다시해주세요 개수가 일치하지 않습니다.");
            System.exit(0);
        }
        for (int i = 0; i < count; i++){
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
 
        for (int i = 0; i < N; i++){
            if (inputArr[i+1] > inputArr[i+2]){
                int twoCase = Math.min(inputArr[i], (inputArr[i+1] - inputArr[i+2]));
                result += 5 * twoCase;
                inputArr[i] -= twoCase;
                inputArr[i+1] -= twoCase;
 
                int threeCase = Math.min(inputArr[i],inputArr[i+1]);
                threeCase = Math.min(threeCase,inputArr[i+2]);
                result += 7 * threeCase;
                inputArr[i] -= threeCase;
                inputArr[i+1] -= threeCase;
                inputArr[i+2] -= threeCase;
            }
            else {
                int threeCase = Math.min(inputArr[i],inputArr[i+1]);
                threeCase = Math.min(threeCase,inputArr[i+2]);
                result += 7 * threeCase;
                inputArr[i] -= threeCase;
                inputArr[i+1] -= threeCase;
                inputArr[i+2] -= threeCase;
 
                int twoCase = Math.min(inputArr[i], inputArr[i+1]);
                result += 5 * twoCase;
                inputArr[i] -= twoCase;
                inputArr[i+1] -= twoCase;
            }
            result += 3 * inputArr[i];
        }
        System.out.println(result);
    }
}

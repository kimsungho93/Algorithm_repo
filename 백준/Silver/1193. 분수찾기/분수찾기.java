import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine()); // X번째 분수 입력 받기

        int count = 0; // 지나온 항의 수를 세기 위한 변수
        int line = 0; // 현재 대각선 라인을 나타내는 변수

        // X가 속한 대각선 라인 찾기
        while (count < X) {
            line++;
            count += line;
        }

        // X번째 항이 현재 라인에서 몇 번째에 위치하는지 계산
        int termIntoLine = X - (count - line);

        // 분자와 분모 계산
        int numerator, denominator;
        if (line % 2 == 0) { // 짝수 라인인 경우 분자는 증가하고 분모는 감소함
            numerator = termIntoLine;
            denominator = line + 1 - termIntoLine;
        } else { // 홀수 라인인 경우 분자는 감소하고 분모는 증가함
            numerator = line + 1 - termIntoLine;
            denominator = termIntoLine;
        }

        System.out.println(numerator + "/" + denominator); // 결과 출력
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int count = 0; 
        int line = 0; 

        while (count < X) {
            line++;
            count += line;
        }

        int termIntoLine = X - (count - line);

        int numerator, denominator;
        if (line % 2 == 0) { 
            numerator = termIntoLine;
            denominator = line + 1 - termIntoLine;
        } else {
            numerator = line + 1 - termIntoLine;
            denominator = termIntoLine;
        }
        System.out.println(numerator + "/" + denominator);
    }
}
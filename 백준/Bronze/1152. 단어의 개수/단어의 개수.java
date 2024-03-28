import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine().trim();
        int wordCount = 0;
        
        if (!input.isEmpty()) {
            wordCount = 1; 
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ' ') {
                    wordCount++;
                }
            }
        }
        
        bw.write(String.valueOf(wordCount));
        bw.flush();
        br.close();
        bw.close();
    }
}

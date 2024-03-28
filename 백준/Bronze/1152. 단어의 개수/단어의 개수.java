import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine().trim();
        StringTokenizer st = new StringTokenizer(input, " ");
        
        int wordCount = st.countTokens();
        
        bw.write(String.valueOf(wordCount));
        bw.flush();
        br.close();
        bw.close();
    }
}
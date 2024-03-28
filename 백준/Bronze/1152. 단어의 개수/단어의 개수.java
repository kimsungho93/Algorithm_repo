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
        
        if (input.isEmpty()) {
            bw.write("0");
        } else {
            bw.write(String.valueOf(input.split(" ").length));
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}
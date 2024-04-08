import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] alphabet = new int[26];
    public static void main(String[] args) throws Exception {
        String word = br.readLine();
        
        for (int i = 0; i < 26; i++) {
            alphabet[i] = -1;
        }
        
        for (char c : word.toCharArray()) {
            if (alphabet[c - 'a'] == -1) {
                alphabet[c - 'a'] = word.indexOf(c);
            }
        }

        for (int i = 0; i < alphabet.length; i++) {
            sb.append(alphabet[i]).append(" ");
        }
        System.out.println(sb);
    }
}
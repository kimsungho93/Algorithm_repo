import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] alphabet = new int[26];

        Arrays.fill(alphabet, -1);
        for (char c : word.toCharArray()) {
            if (alphabet[c - 'a'] == -1) {
                alphabet[c - 'a'] = word.indexOf(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alphabet.length; i++) {
            sb.append(alphabet[i]).append(" ");
        }
        System.out.println(sb);
    }
}
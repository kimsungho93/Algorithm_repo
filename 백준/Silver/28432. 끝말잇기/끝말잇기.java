import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int M = Integer.parseInt(br.readLine()); 
        String[] candidates = new String[M]; 
        for (int i = 0; i < M; i++) {
            candidates[i] = br.readLine();
        }

        int missingIndex = -1; 
        for (int i = 0; i < N; i++) {
            if ("?".equals(words[i])) {
                missingIndex = i;
                break;
            }
        }

        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            if (!"?".equals(word)) {
                wordSet.add(word);
            }
        }

        String beforeWord = missingIndex > 0 ? words[missingIndex - 1] : "";
        String afterWord = missingIndex < N - 1 ? words[missingIndex + 1] : "";

        for (String candidate : candidates) {
            if (!wordSet.contains(candidate) &&
                    (beforeWord.isEmpty() || beforeWord.charAt(beforeWord.length() - 1) == candidate.charAt(0)) &&
                    (afterWord.isEmpty() || candidate.charAt(candidate.length() - 1) == afterWord.charAt(0))) {
                System.out.println(candidate);
                break;
            }
        }
    }
}

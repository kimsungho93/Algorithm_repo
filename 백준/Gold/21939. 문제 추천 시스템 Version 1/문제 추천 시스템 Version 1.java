import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, TreeSet<Integer>> problems = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            problems.computeIfAbsent(L, k -> new TreeSet<>()).add(P);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "add":
                    int P = Integer.parseInt(st.nextToken());
                    int L = Integer.parseInt(st.nextToken());
                    problems.computeIfAbsent(L, k -> new TreeSet<>()).add(P);
                    break;
                case "solved":
                    int solvedP = Integer.parseInt(st.nextToken());
                    problems.entrySet().removeIf(entry -> entry.getValue()
                            .remove(solvedP) && entry.getValue().isEmpty());
                    break;
                case "recommend":
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 1) {
                        Map.Entry<Integer, TreeSet<Integer>> lastEntry = problems.lastEntry();
                        if (lastEntry != null) {
                            System.out.println(lastEntry.getValue().last());
                        }
                    } else {
                        Map.Entry<Integer, TreeSet<Integer>> firstEntry = problems.firstEntry();
                        if (firstEntry != null) {
                            System.out.println(firstEntry.getValue().first());
                        }
                    }
                    break;
            }
        }
    }
}

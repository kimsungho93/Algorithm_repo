import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    static int N, M, K; 
    static ArrayList<Fireball> fireballs = new ArrayList<>();
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(r, c, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            moveFireballs(); 
            mergeAndSplitFireballs(); 
        }

        System.out.println(calculateMass()); 
    }

    private static void moveFireballs() {
        for (Fireball fireball : fireballs) {
            fireball.r = (fireball.r + dx[fireball.d] * fireball.s % N + N) % N;
            fireball.c = (fireball.c + dy[fireball.d] * fireball.s % N + N) % N;
            if (fireball.r == 0) fireball.r = N;
            if (fireball.c == 0) fireball.c = N;
        }
    }

    private static void mergeAndSplitFireballs() {
        HashMap<String, List<Fireball>> map = new HashMap<>();
        for (Fireball fireball : fireballs) {
            String key = fireball.r + "," + fireball.c;
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(fireball);
        }

        fireballs.clear();
        for (List<Fireball> list : map.values()) {
            if (list.size() == 1) {
                fireballs.addAll(list);
            } else {
                int sumM = 0, sumS = 0;
                boolean even = true, odd = true;
                for (Fireball f : list) {
                    sumM += f.m;
                    sumS += f.s;
                    if (f.d % 2 == 0) odd = false;
                    else even = false;
                }
                int newM = sumM / 5;
                int newS = sumS / list.size();
                int[] newDs = even || odd ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};
                if (newM > 0) {
                    for (int d : newDs) {
                        fireballs.add(new Fireball(list.get(0).r, list.get(0).c, newM, newS, d));
                    }
                }
            }
        }
    }

    private static int calculateMass() {
        int totalMass = 0;
        for (Fireball fireball : fireballs) {
            totalMass += fireball.m;
        }
        return totalMass;
    }
}

class Fireball {
    int r, c, m, s, d; 

    Fireball(int r, int c, int m, int s, int d) {
        this.r = r;
        this.c = c;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}
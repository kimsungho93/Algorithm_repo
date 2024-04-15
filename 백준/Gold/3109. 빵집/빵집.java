import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static int dx [] = {- 1, 0, 1 };
    static int dy [] = { 1, 1, 1 };
    static int R, C;
    static char [] [] map;
    static boolean [] [] visit;
    static int cnt;
    static boolean check;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader ( new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer (br.readLine (), " " );

        R = Integer.parseInt (st.nextToken ());
        C = Integer.parseInt (st.nextToken ());

        map = new char [R] [C];
        visit = new boolean [R] [C];

        for ( int i = 0; i < R; i++) {
            String input = br.readLine ();
            for ( int j = 0; j < C; j++) {
                map [i] [j] = input.charAt (j);
            }
        }

        for ( int i = 0; i < R; i++) {
            check = false; 
            dfs ( new Node (i, 0 ));
        }

        System.out.println (cnt);
    }

    static void dfs(Node node) {
        if (node.y == C - 1) {
            check = true ;
            cnt++;
            return ; 
        }

        visit [node.x] [node.y] = true ;

        for ( int j = 0; j < 3; j++) {
            int newX = node.x + dx [j];
            int newY = node.y + dy [j];

            if (newX >= 0 && newY >= 0 && newX < R && newY < C && map [newX] [newY] == '.' && !visit [newX] [newY]) {
                if (check) return ; 
                dfs ( new Node (newX, newY));
            }
        }
    }
}

class Node {
    int x;
    int y;

    Node ( int x, int y) {
        this .x = x;
        this .y = y;
    }
}

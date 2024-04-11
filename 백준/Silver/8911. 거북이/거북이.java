import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String commands = br.readLine();
            simulate(commands);
        }
        System.out.println(sb);
    }

    private static void simulate(String commands) {
        int x = 0, y = 0;
        int minX = 0, minY = 0;
        int maxX = 0, maxY = 0;
        int direction = 0;

        for (char command : commands.toCharArray()) {
            if (command == 'F') {
                if (direction == 0) y++;
                else if (direction == 1) x++;
                else if (direction == 2) y--;
                else if (direction == 3) x--;
            } else if (command == 'B') {
                if (direction == 0) y--;
                else if (direction == 1) x--;
                else if (direction == 2) y++;
                else if (direction == 3) x++;
            } else if (command == 'L') {
                direction = (direction + 3) % 4;
            } else if (command == 'R') {
                direction = (direction + 1) % 4;
            }

            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }
        int area = (maxX - minX) * (maxY - minY);
        sb.append(area).append("\n");

    }
}


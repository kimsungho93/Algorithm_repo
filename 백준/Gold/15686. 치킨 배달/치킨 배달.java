import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Position {
    int r, c;

    Position(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int N, M;
    static List<Position> houses = new ArrayList<>();
    static List<Position> chickens = new ArrayList<>();
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) houses.add(new Position(i, j)); // 집 위치 저장
                else if (value == 2) chickens.add(new Position(i, j)); // 치킨 집 위치 저장
            }
        }

        selectChicken(0, new ArrayList<>());
        System.out.println(minDist);
    }

    // m개의 치킨집을 선택하는 모든 조합을 탐색
    static void selectChicken(int start, List<Position> selected) {
        if (selected.size() == M) {
            int dist = calculateChickenDistance(selected);
            minDist = Math.min(minDist, dist);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            selectChicken(i + 1, selected);
            selected.remove(selected.size() - 1); // 다음 조합을 위해 마지막에 추가된 치킨 집 제거
        }
    }

    // 선택된 치킨 집들로부터 도시의 치킨 거리 계산
    static int calculateChickenDistance(List<Position> selected) {
        int dist = 0;
        for (Position house : houses) {
            int houseDist = Integer.MAX_VALUE;
            for (Position chicken : selected) {
                int d = Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c);
                houseDist = Math.min(houseDist, d); // 가장 가까운 치킨 집까지의 거리
            }
            dist += houseDist; // 모든 집의 치킨 거리 합
        }
        return dist;
    }
}

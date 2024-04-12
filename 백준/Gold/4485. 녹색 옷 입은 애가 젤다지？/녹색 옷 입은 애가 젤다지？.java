import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, 1, -1}; // 상, 하, 좌, 우 방향으로 이동하기 위한 x좌표 변화량
    static int[] dy = {1, -1, 0, 0}; // 상, 하, 좌, 우 방향으로 이동하기 위한 y좌표 변화량

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder
        int problemCnt = 1; // 문제 번호 카운터

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 동굴의 크기
            if (N == 0) break; // 입력이 0이면 프로그램 종료

            int[][] map = new int[N][N];
            int[][] cost = new int[N][N]; // 최소 비용을 저장할 배열

            // 맵 정보 입력
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    cost[i][j] = Integer.MAX_VALUE; // 최소 비용을 매우 큰 값으로 초기화
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐를 사용하여 다익스트라 알고리즘 구현
            pq.offer(new Node(0, 0, map[0][0])); // 시작 위치 큐에 추가
            cost[0][0] = map[0][0]; // 시작 위치의 비용 초기화

            while (!pq.isEmpty()) {
                Node cur = pq.poll(); // 우선순위 큐에서 비용이 가장 작은 노드 추출

                if (cur.x == N - 1 && cur.y == N - 1) { // 도착 지점에 도달하면
                    sb.append("Problem ").append(problemCnt++).append(": ").append(cur.cost).append("\n");
                    break; // 결과 문자열에 추가하고 반복 종료
                }

                // 상하좌우 이동
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (canMove(nx, N, ny)) { // 이동 가능한 위치라면
                        int newCost = cur.cost + map[nx][ny];
                        if (cost[nx][ny] > newCost) { // 새로운 비용이 더 작은 경우에만 업데이트
                            cost[nx][ny] = newCost;
                            pq.offer(new Node(nx, ny, newCost)); // 업데이트된 위치 큐에 추가
                        }
                    }
                }
            }
        }
        System.out.println(sb); // 모든 결과 출력
    }

    // 지정된 위치가 이동 가능한 범위 내에 있는지 확인
    private static boolean canMove(int nx, int N, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}

// 노드 클래스, 위치와 비용 정보를 가짐
class Node implements Comparable<Node> {
    int x, y, cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) { // 우선순위 큐에서 비용 기준으로 정렬
        return this.cost - o.cost;
    }
}

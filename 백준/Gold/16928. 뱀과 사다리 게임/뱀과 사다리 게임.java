import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAX = 100;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] board = new int[MAX + 1];
        for (int i = 1; i <= MAX; i++) board[i] = i; // 기본적으로 자기 자신으로 이동하는 것으로 초기화

        int N = Integer.parseInt(st.nextToken()); // 사다리의 수
        int M = Integer.parseInt(st.nextToken()); // 뱀의 수

        // 사다리와 뱀 정보 입력 받기
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }

        System.out.println(findMinimumMoves(board));
    }

    private static int findMinimumMoves(int[] board) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[MAX + 1];
        queue.offer(1); // 시작 위치
        visited[1] = true;

        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == MAX) return moves; // 목표 지점 도달
                
                for (int j = 1; j <= 6; j++) { // 주사위를 굴린다
                    int next = current + j;
                    if (next <= MAX && !visited[next]) {
                        visited[next] = true;
                        queue.offer(board[next]); // 사다리나 뱀을 타고 이동
                    }
                }
            }
            moves++;
        }
        return -1; // 도달할 수 없는 경우
    }
}

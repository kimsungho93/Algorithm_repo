import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 집의 수
        int C = Integer.parseInt(input[1]); // 라우터의 수

        long[] houses = new long[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Long.parseLong(br.readLine());
        }

        // 집의 위치를 오름차순으로 정렬합니다.
        Arrays.sort(houses);

        // 이진 탐색을 위한 초기 설정
        long left = 1; // 가능한 최소 거리
        long right = houses[N - 1] - houses[0]; // 가능한 최대 거리
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2; // 중간값을 거리로 설정
            if (canPlaceRouters(houses, mid, C)) {
                result = mid; // 조건을 만족하면 결과 갱신
                left = mid + 1; // 더 큰 거리 탐색
            } else {
                right = mid - 1; // 더 작은 거리 탐색
            }
        }

        System.out.println(result);
    }

    // 주어진 거리로 라우터를 C개 이상 설치할 수 있는지 확인하는 메소드
    private static boolean canPlaceRouters(long[] houses, long distance, int C) {
        int count = 1; // 첫 번째 집에 라우터 설치
        long lastPlaced = houses[0];

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - lastPlaced >= distance) {
                count++;
                lastPlaced = houses[i];
                if (count >= C) return true;
            }
        }
        return false;
    }
}

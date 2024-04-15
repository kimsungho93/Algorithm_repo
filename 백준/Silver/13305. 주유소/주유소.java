import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] distance = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int[] price = new int[N];
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        
        long minCost = getMinCost(N, distance, price);
        System.out.println(minCost);
    }
    
    private static long getMinCost(int N, int[] distance, int[] price) {
        long totalDistance = 0;
        long minPrice = Long.MAX_VALUE;
        long totalCost = 0;
        
        for (int i = 0; i < N - 1; i++) {
            if (price[i] < minPrice) {
                totalCost += totalDistance * minPrice;
                minPrice = price[i];
                totalDistance = 0;
            }
            totalDistance += distance[i];
        }
        
        totalCost += totalDistance * minPrice;
        
        return totalCost;
    }
}

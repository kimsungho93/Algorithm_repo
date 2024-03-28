import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] fruitsCnt = new int[4];

        for (int i = 0; i < N; i++) {
            String[] cardInfo = br.readLine().split(" ");
            String fruit = cardInfo[0];
            int cnt = Integer.parseInt(cardInfo[1]);
            int index = findFruitIndex(fruit);
            fruitsCnt[index] += cnt;
        }

        for (int i = 0; i < fruitsCnt.length; i++) {
            if (fruitsCnt[i] == 5) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    private static int findFruitIndex(String fruit) {
        switch (fruit) {
            case "STRAWBERRY":
                return 0;
            case "BANANA":
                return 1;
            case "LIME":
                return 2;
            case "PLUM":
                return 3;
            default:
                return -1;
        }
    }
}
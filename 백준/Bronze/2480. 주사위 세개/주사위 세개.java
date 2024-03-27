import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[3];
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            nums[i] = scanner.nextInt();
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int max = -1;
        int sameNum = 0;
        for (Integer num : map.keySet()) {
            if (map.get(num) > max) {
                max = Math.max(max, map.get(num));
                sameNum = num;
            }
        }

        if (max == 3) {
            result = 10000 + sameNum * 1000;
        } else if (max == 2) {
            result = 1000 + sameNum * 100;
        } else {
            result = Arrays.stream(nums).max().getAsInt() * 100;
        }

        System.out.println(result);
    }
}
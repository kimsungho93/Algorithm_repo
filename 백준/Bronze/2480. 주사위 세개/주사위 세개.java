import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] nums = new int[3];

        for (int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(nums);
        int result;

        if (nums[0] == nums[2]) {
            result = 10000 + nums[0] * 1000;
        } else if (nums[0] == nums[1] || nums[1] == nums[2]) {
            result = 1000 + nums[1] * 100;
        } else {
            result = nums[2] * 100;
        }
        System.out.println(result);
        br.close();
    }
}

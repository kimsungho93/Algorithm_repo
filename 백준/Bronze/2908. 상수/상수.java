import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int num1 = Integer.parseInt(new StringBuilder(nums[0]).reverse().toString());
        int num2 = Integer.parseInt(new StringBuilder(nums[1]).reverse().toString());

        bw.write(String.valueOf(Math.max(num1, num2)));
        bw.flush();
        bw.close();
        br.close();
    }
}
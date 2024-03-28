import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int num1 = Integer.parseInt(new StringBuilder(String.valueOf(nums[0])).reverse().toString());
        int num2 = Integer.parseInt(new StringBuilder(String.valueOf(nums[1])).reverse().toString());

        if (num1 > num2) {
            bw.write(String.valueOf(num1));
        } else {
            bw.write(String.valueOf(num2));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
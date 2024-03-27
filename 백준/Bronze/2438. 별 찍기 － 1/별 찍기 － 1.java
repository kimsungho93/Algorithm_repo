import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            sb.append("*".repeat(i + 1)).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}

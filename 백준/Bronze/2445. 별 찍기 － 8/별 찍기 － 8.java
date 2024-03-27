import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            printStar(N, i);
        }
        for (int i = N - 1; i > 0; i--) {
            printStar(N, i);
        }
    }

    private static void printStar(int N, int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("*");
        }
        for (int j = 0; j < 2 * (N - i); j++) {
            System.out.print(" ");
        }
        for (int j = 0; j < i; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
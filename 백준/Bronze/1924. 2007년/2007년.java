import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(); 
        int y = scanner.nextInt(); 

        int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int totalDays = y;
        for (int i = 1; i < x; i++) {
            totalDays += daysOfMonth[i];
        }

        System.out.println(days[totalDays % 7]);
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<String> employees = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] record = br.readLine().split(" ");
            String name = record[0];
            String status = record[1];

            if ("enter".equals(status)) {
                employees.add(name);
            } else {
                employees.remove(name);
            }
        }

        ArrayList<String> sortedEmployees = new ArrayList<>(employees);
        Collections.sort(sortedEmployees, Collections.reverseOrder());

        for (String employee : sortedEmployees) {
            bw.write(employee);
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
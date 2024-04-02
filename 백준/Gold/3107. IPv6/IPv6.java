import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(":");
        int part = input.length;
        for (String tmp : input) {
            if(tmp.length() == 0) part--;
        }
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int cnt = 0;
        while ( idx < input.length ) {
            String tmp = input[idx];
            if ( tmp.length() == 0 && part < 8){
                sb.append("0000");
                sb.append(":");
                cnt++;
                part++;
            } else if ( tmp.length() == 0 ) {
                idx++;
                continue;
            } else if ( tmp.length() != 0) {
                for(int i = 0 ; i < 4 - tmp.length() ; i++){
                    sb.append("0");
                }
                sb.append(tmp);
                idx++;
                cnt++;
                if(cnt < 8) sb.append(":");
            }
        }
        while (cnt < 8) {
            sb.append("0000");
            cnt++;
            if(cnt < 8) sb.append(":");
        }
        System.out.println(sb);
    }
}
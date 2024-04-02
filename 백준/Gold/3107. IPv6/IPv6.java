import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip = br.readLine();
        StringBuilder sb = new StringBuilder();

        boolean hasEmpty = ip.contains("::");
        if (hasEmpty) {
            if (ip.equals("::")) {
                System.out.println("0000:0000:0000:0000:0000:0000:0000:0000");
                return;
            }
            String[] parts = ip.split("::", -1);
            String pre = parts[0];
            String post = parts.length > 1 ? parts[1] : "";
            int totalSegs = (pre.isEmpty() ? 0 : pre.split(":").length) + (post.isEmpty() ? 0 : post.split(":").length);
            int segsToFill = 8 - totalSegs;

            ip = pre + ":" + IntStream.range(0, segsToFill).mapToObj(i -> "0000").collect(Collectors.joining(":")) + ":" + post;
            if (ip.startsWith(":")) ip = ip.substring(1);
            if (ip.endsWith(":")) ip = ip.substring(0, ip.length() - 1);
        }

        String[] segs = ip.split(":", -1);
        for (int i = 0; i < segs.length; i++) {
            sb.append(String.format("%1$" + 4 + "s", segs[i]).replace(' ', '0'));
            if (i < segs.length - 1) sb.append(":");
        }

        System.out.println(sb);
    }
}

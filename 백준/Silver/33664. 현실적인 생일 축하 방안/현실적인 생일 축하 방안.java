import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long money = Long.parseLong(st.nextToken());
        int allItem = Integer.parseInt(st.nextToken());
        int buyItem = Integer.parseInt(st.nextToken());

        HashMap<String, Long> map = new HashMap<>();
        for (int i = 0; i < allItem; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            long price = Long.parseLong(st.nextToken());

            map.put(name, price);
        }

        long sum = 0L;
        for (int i = 0; i < buyItem; i++) {
            String name = br.readLine();
            sum += map.get(name);
        }

        bw.write(sum > money ? "unacceptable" : "acceptable");
        bw.close();
    }
}

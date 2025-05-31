import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] ch = new int[]{3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int len = Math.max(n, m);

        st = new StringTokenizer(br.readLine());
        String name1 = st.nextToken();
        String name2 = st.nextToken();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (i < name1.length()) list.add(ch[name1.charAt(i) - 'A']);
            if (i < name2.length()) list.add(ch[name2.charAt(i) - 'A']);
        }

        while (list.size() > 2) {
            ArrayList<Integer> next = new ArrayList<>();

            for (int i = 0; i < list.size() - 1; i++) {
                next.add((list.get(i) + list.get(i + 1)) % 10);
            }

            list = next;
        }

        int result = list.get(0) * 10 + list.get(1);
        if (result < 10) bw.write(result + "%");
        else bw.write(result + "%");

        bw.close();
    }
}

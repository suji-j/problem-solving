import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> aMap = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            aMap.put(Integer.parseInt(st.nextToken()), 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (aMap.containsKey(num)) {
                aMap.put(num, 0);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i : aMap.keySet()) {
            if (aMap.get(i) == 1) {
                list.add(i);
            }
        }

        if (list.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(list.size());
            Collections.sort(list);
            for (int i : list) {
                System.out.print(i + " ");
            }
        }
    }
}
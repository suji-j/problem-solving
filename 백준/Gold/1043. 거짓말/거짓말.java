import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static List<Integer> know;

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (know.contains(a)) {
            parent[b] = a;
        } else if (know.contains(b)) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = m;

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        know = new ArrayList<>();
        int knowCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowCnt; i++) {
            know.add(Integer.parseInt(st.nextToken()));
        }

        List<int[]> party = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[Integer.parseInt(st.nextToken())];
            arr[0] = Integer.parseInt(st.nextToken());

            if (arr.length > 1) {
                for (int j = 1; j < arr.length; j++) {
                    arr[j] = Integer.parseInt(st.nextToken());
                }

                int a = arr[0];
                for (int j = 1; j < arr.length; j++) {
                    int b = arr[j];
                    union(a, b);
                }
            }
            party.add(arr);
        }

        for (int i = 0; i < m; i++) {
            int[] currentParty = party.get(i);
            for (int j = 0; j < currentParty.length; j++) {
                if (know.contains(find(currentParty[j]))) {
                    ans--;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}

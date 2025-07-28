import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        String name;
        int score;

        public Node(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            list.add(new Node(name, score));
        }

        int minAns = 0, maxAns = 0;
        Set<String> knownName = new HashSet<>();
        for (int i = 0; i < k; i++) {
            String name = br.readLine();
            knownName.add(name);

            for (int j = 0; j < n; j++) {
                if (name.equals(list.get(j).name)) {
                    minAns += list.get(j).score;
                    maxAns += list.get(j).score;
                    break;
                }
            }
        }

        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.score - o2.score;
            }
        });

        int cnt = m - k;
        for (int i = 0; i < n && cnt > 0; i++) {
            if (!knownName.contains(list.get(i).name)) {
                minAns += list.get(i).score;
                cnt--;
            }
        }

        cnt = m - k;
        for (int i = n - 1; i >= 0 && cnt > 0; i--) {
            if (!knownName.contains(list.get(i).name)) {
                maxAns += list.get(i).score;
                cnt--;
            }
        }

        bw.write(minAns + " " + maxAns);
        bw.close();
    }
}

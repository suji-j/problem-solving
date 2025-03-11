import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Task implements Comparable<Task> {
        int day, point;

        public Task(int day, int point) {
            this.day = day;
            this.point = point;
        }

        @Override
        public int compareTo(Task o) {
            return o.point - this.point;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Task> q = new PriorityQueue<>();
        List<Task> list = new ArrayList<>();

        StringTokenizer st;
        int lastDay = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Task(d, w));
            lastDay = Math.max(lastDay, d);
        }
        Collections.sort(list, (o1, o2) -> o2.day - o1.day);

        int workDay = 0, result = 0;
        for (int i = lastDay; i > 0; i--) {
            while (workDay < n && i <= list.get(workDay).day) {
                q.add(list.get(workDay++));
            }

            if (!q.isEmpty()) result += q.poll().point;
        }

        System.out.println(result);
    }
}

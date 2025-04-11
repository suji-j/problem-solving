import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Person implements Comparable<Person> {
        int docu, inter;

        public Person(int docu, int inter) {
            this.docu = docu;
            this.inter = inter;
        }

        @Override
        public int compareTo(Person o) {
            return this.docu - o.docu;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int ans = 1;
            Person[] person = new Person[n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                person[j] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(person);
            int bestInter = person[0].inter;

            for (int j = 1; j < n; j++) {
                if (bestInter > person[j].inter) {
                    ans++;
                    bestInter = person[j].inter;
                }
            }

            bw.write(ans + "\n");
        }

        bw.close();
    }
}

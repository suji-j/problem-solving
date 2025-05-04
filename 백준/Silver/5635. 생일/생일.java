import java.io.*;
import java.util.*;

public class Main {
    static class Student {
        String name;
        int day, month, year;

        public Student(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Student> student = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            student.add(new Student(name, d, m, y));
        }

        Collections.sort(student, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.year != o2.year) {
                    return o2.year - o1.year;
                }

                if (o1.month != o2.month) {
                    return o2.month - o1.month;
                }

                return o2.day - o1.day;
            }
        });

        bw.write(student.get(0).name + "\n");
        bw.write(student.get(student.size() - 1).name);
        bw.flush();
        bw.close();
    }
}

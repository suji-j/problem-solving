import java.io.*;
import java.util.StringTokenizer;

public class baek_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        float[] credit = new float[20];
        String[] grade = new String[20];
        double score = 0;
        double sum = 0;
        double divide = 0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String obj = st.nextToken();
            credit[i] = Float.parseFloat(st.nextToken());
            grade[i] = st.nextToken();

            if (!(grade[i].equals("P"))) {
                switch (grade[i]) {
                    case "A+":
                        score = 4.5;
                        break;
                    case "A0":
                        score = 4.0;
                        break;
                    case "B+":
                        score = 3.5;
                        break;
                    case "B0":
                        score = 3.0;
                        break;
                    case "C+":
                        score = 2.5;
                        break;
                    case "C0":
                        score = 2.0;
                        break;
                    case "D+":
                        score = 1.5;
                        break;
                    case "D0":
                        score = 1.0;
                        break;
                    case "F":
                        score = 0.0;
                        break;
                }
                sum += credit[i] * score;
                divide += credit[i];
            } else {
                grade[i] = null;
            }
        }

        System.out.printf("%.6f", sum / divide);
    }
}

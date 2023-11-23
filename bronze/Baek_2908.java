package BaekJoon;
//2908
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Baek_2908 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] num1 = new String[3];
        String[] num2 = new String[3];
        String a = st.nextToken();
        String b = st.nextToken();
        int numA =0;
        int numB =0;

        for (int i =0; i<3; i++){
            num1[i] = String.valueOf(a.charAt(i) - 48);
            num2[i] = String.valueOf(b.charAt(i) - 48);
        }

        String save = num1[2];
        num1[2] = num1[0];
        num1[0] = save;

        save = num2[2];
        num2[2] = num2[0];
        num2[0] = save;

        a = Arrays.stream(num1).collect(Collectors.joining());
        b = Arrays.stream(num2).collect(Collectors.joining());

        numA = Integer.parseInt(a);
        numB = Integer.parseInt(b);

        if (numA > numB){
            bw.write(String.valueOf(numA));
        }
        else{
            bw.write(String.valueOf(numB));
        }

        br.close();
        bw.close();
    }
}

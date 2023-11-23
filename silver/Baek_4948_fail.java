package BaekJoon;
//4948
import java.io.*;
public class Baek_4948_fail {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count =0;
        int primeNum =0;

        while (true){
            int num = Integer.parseInt(br.readLine());
            if (num != 0){
                for (int i=(num+1) ; i<=(2*num); i++){
                    for (int j=1; j<=num;j++){
                        if (i%j ==0){
                            count +=1;
                        }
                    }
                    if (count == 2){
                        primeNum +=1;
                    }
                }
                bw.write(primeNum + "\n");
                count =0;
                primeNum =0;
            } else{
                break;
            }
        }

        bw.close();
        br.close();
    }
}

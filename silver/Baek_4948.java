package BaekJoon;

import java.io.*;
//4948 -베르트랑 공준
public class Baek_4948{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            int num = Integer.parseInt(br.readLine());

            if (num ==0){ //입력이 0이면 끝
                break;
            } else{
                bw.write(primeNum(num) + "\n");
            }
        }
        bw.close();
        br.close();
    }

    public static int primeNum(int num){
        int[] arr = new int[(num*2)+1];
        int count =0;

        for (int i=2; i<=(num*2) ; i++){ //배열 초기화
            arr[i] = i;
        }

        for (int i=2; i<=(num*2) ; i++){ //2부터 특정 수의 배수 지우기
            if (arr[i] == 0){ //이미 지워진 수는 건너뛰기
                continue;
            }
            for (int j=2*i; j<=num*2 ; j+=i){
                arr[j] = 0;
            }
        }

        for (int i=(num+1); i<=(num*2) ; i++){
            if (arr[i] != 0){
                count +=1;
            }
        }
        return count;
    }
}

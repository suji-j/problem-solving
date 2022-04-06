package BaekJoon;
//1181
import java.io.*;
import java.util.*;

public class Baek_1181_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        int sum =0;

        for (int i=0; i<num; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        //1.산술평균
        for (int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        double avg = (double)sum/num;
        if (avg < 0){
            bw.write(Math.round(avg)+ "\n");
        } else{
            bw.write(String.format("%.0f\n", avg));
        }


        //2. 중앙값
        int mid =0;
        if (arr.length % 2 == 0){
            mid = arr.length/2+1;
        } else{
            mid = arr.length/2 + 1/2;
        }
        bw.write(arr[mid] +"\n");

        //3. 최빈값
        List<Integer> cnt = new ArrayList<Integer>();
        int a =0;
        for (int i=0; i<arr.length; i++){
            int count =1 ;
            for (int j=i+1; j<arr.length-i ; j++){
                if (arr[i] == arr[j]){
                    count+=1;
                }
            }
            if (count >= 2){
                cnt.add(a, arr[i]);
                a++;
            }
        }
        cnt.sort(Comparator.naturalOrder());
        if (cnt.size() == 0){
            if (arr.length >= 2){
                bw.write(arr[1] + "\n");
            } else if(arr.length < 2){
                bw.write(arr[0] + "\n");
            }
        } else{
            if (cnt.size() >= 2){
                bw.write(cnt.get(1) + "\n");
            } else if (cnt.size()>0 && cnt.size()<2){
                bw.write(cnt.get(0) + "\n");
            }
        }

        //4. 범위
        bw.write(arr[arr.length-1]- arr[0] + "\n");

        br.close();
        bw.close();
    }
}

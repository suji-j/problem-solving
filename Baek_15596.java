package BaekJoon;
//15596
public class Baek_15596 {
    long sum(int [] a){
        long sum1= 0;

        for (int i=0; i<a.length ; i++){
            sum1 += a[i];
        }

        return sum1;
    }
}

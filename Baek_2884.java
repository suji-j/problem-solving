package BaekJoon;
//2884
import java.util.Scanner;

public class Baek_2884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int hour = scan.nextInt();
		int min = scan.nextInt();
		
		if (min-45 < 0) {
			min = min + 45 - 30;
			hour = hour - 1;
			if(hour < 0) {
				hour = 23;
			}
		} else {
			min = min - 45;
		}	
		
		System.out.print(hour + " ");
		System.out.print(min);	
		
		scan.close();
	}
}

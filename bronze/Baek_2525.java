package BaekJoon;
//2525
import java.util.Scanner;

public class Baek_2525 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int currentHour = scan.nextInt();
		int currentMin = scan.nextInt();		
		int cookTime = scan.nextInt();
		int div;
		
		if(currentMin + cookTime >= 60) {
			div = (currentMin + cookTime) / 60;
			currentMin = currentMin + cookTime - 60;			
			currentHour += div;
			if (currentMin % 60 == 0) {	
				currentMin = 0; 
			} else if(((currentMin % 60) != 0) && currentMin >= 60) {
				currentMin = currentMin % 60;
			}
			
		} else {
			currentMin += cookTime; 
		}
		
		if (currentHour >= 24) {
			currentHour -= 24 ;
		}
		
		System.out.print(currentHour + " ");
		System.out.print(currentMin);
		
		scan.close();
	}
}

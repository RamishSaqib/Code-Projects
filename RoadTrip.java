/* Program by Ramish Saqib
   Created on December 14, 2018
   The purpose of this program is to use a recursive call that ask "Are we there yet?" and 
   keeps running until the user enters "yes"
 */
import java.util.Scanner;

public class RoadTrip {
	static Scanner keyboard = new Scanner(System.in);
	public static String Q = "Are we there yet?";
	public String A = keyboard.nextLine();
	
	public static String Question(String Q) {
		Scanner keyboard = new Scanner(System.in);
		String Y = "YES";
		String A = keyboard.nextLine();
		return Q;
		if(A.toUpperCase().equals(Y)) {
			break;
		}
		else {
			return Question(Q);
		}
	}

	
	public static void main(String [] args) {
		System.out.println(Question(Q));
	}
}
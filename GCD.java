/* Program by Ramish Saqib
   Created on December 14, 2018
   The purpose of this program is to use a recursive call to find the GCD of two integers
 */
public class GCD {
		public static int gcd(int a, int b) {
			if (b == 0) {
				return a;
			}
			else {
				return gcd(b, a % b); 
			}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(gcd(9, 18));

	}

}

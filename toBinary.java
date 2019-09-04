/* Program by Ramish Saqib
   Created on December 14, 2018
   The purpose of this program is to use a recursive call to convert an integer to binary form
 */
public class toBinary {
	
	   public static String IntToBinary(int n){
	        int a;
	        if(n < 0) {
	        	throw new IllegalArgumentException();
	        }
	        if(n == 0) {
	        	return "0";
	        }
	        if(n > 0)
	        {
	            a = n % 2;
	            return (IntToBinary(n / 2) + "" + a);
	        }
	        return "";
	    }
	public static void main(String [] args) {
		System.out.println(IntToBinary(21));
	}
}
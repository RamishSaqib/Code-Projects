/* Program by Ramish Saqib
   Created on December 14, 2018
   The purpose of this program is to use a recursive call to test if an entered String is a palindrome
 */
public class Palindrome {

	    public static boolean palindrome(String phrase, int left, int right){
	    	left = 0;
	    	right = phrase.length()-1;
	        if(phrase.length() == 0 || phrase.length() == 1) {
	            return true;
	        }
	        if(phrase.toUpperCase().charAt(left) == phrase.toUpperCase().charAt(right)) {
	            return palindrome(phrase.substring(left+1, right), left+1, right-1);
	        }
	        return false;
	    }
}

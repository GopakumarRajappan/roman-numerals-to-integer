/**
 * @author Gopakumar Rajappan
 * @date   03-07-2021
 */

package ntt.roman.integer.conversion;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class RomanToIntegerConversion {


	public static void main(String[] args) {
		
		/**
		 * HashMap used to store the key-value pairs since speed of operation 
		 * is the constraint than order.
		 **/
		Map<String,Integer> romanIntegerMap = new HashMap<String, Integer>();
		romanIntegerMap.put("I", 1);
		romanIntegerMap.put("V", 5);
		romanIntegerMap.put("X", 10);
		romanIntegerMap.put("L", 50);
		romanIntegerMap.put("C", 100);
		romanIntegerMap.put("D", 500);
		romanIntegerMap.put("M", 1000);
		
		/**
		 * Accepting user input and closing scanner after use.
		 */
		System.out.print("Enter Roman numeral to be converted to integer: ");
		Scanner scan = new Scanner(System.in);
		String userRomanInput;
		try{
			userRomanInput = scan.next();
		}finally {
			scan.close();
		}
		System.out.print("User Roman Input : " + userRomanInput);
		
		

	}

}

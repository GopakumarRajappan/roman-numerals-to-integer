/**
 * @author Gopakumar Rajappan
 * @date   03-07-2021
 */

package ntt.roman.integer.conversion;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class RomanToIntegerConversion {


	public static void main(String[] args) {
		
		/**
		 * HashMap used to store the key-value pairs since speed of operation 
		 * is the constraint than order.
		 **/
		Map<String,Integer> romanIntegerMap = new TreeMap<String, Integer>();
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
		System.out.println("Enter Roman numeral to be converted to integer: ");
		Scanner scan = new Scanner(System.in);
		String userRomanInput;
		try{
			userRomanInput = scan.next();
		}finally {
			scan.close();
		}
		
		userRomanInput = userRomanInput.toUpperCase();
		/**
		 * Validating user input for allowable range of Roman letters.
		 * Range is from "I" to "MMMMM"
		 */
		try {
			if (userRomanInput.length() < 1 || userRomanInput.length() > 5) {
				throw new Exception();

			}
		
		/**
		 * Validating user input for invalid characters for Roman letters.
		 */
		boolean validValueCheck = false;		
		for (int iterator=0; iterator < userRomanInput.length(); iterator++) {
			System.out.print(userRomanInput.charAt(iterator));
			for (Map.Entry<String,Integer> romanIntegerMapEntry : romanIntegerMap.entrySet()) {
				if (userRomanInput.charAt(iterator) == romanIntegerMapEntry.getKey().charAt(0)) {
					validValueCheck = true;
					break;
				}else {
					validValueCheck = false;
				}
			}
			if (validValueCheck == false) {
				throw new Exception();	
			}
		}
		
		/**
		 * Valid user input received.
		 */
		}catch (Exception exception) {
			System.out.println("Please provide a valid Roman literal. " +
		         "Valid Range is from \"I\" to \"MMMMM\".  Valid Roman literals are I, V, X, L , C, D , M");
		}

	}

}

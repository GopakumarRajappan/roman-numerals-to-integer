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
			if (userRomanInput.length() < 1) {
				throw new Exception();

			}
		
		/**
		 * Validating user input for invalid characters for Roman letters.
		 */
		boolean validValueCheck = false;		
		for (int iterator=0; iterator < userRomanInput.length(); iterator++) {
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
		int integerEquivalent = 0;

		if (userRomanInput.length() == 1) {
			for (Map.Entry<String,Integer> romanIntegerMapEntry : romanIntegerMap.entrySet()) {
				if (userRomanInput.charAt(0) == romanIntegerMapEntry.getKey().charAt(0)) {
					System.out.println("Integer Rerepsentation of the Roman numeral is: " + romanIntegerMapEntry.getValue());
					break;
				}
			}
		}else if ((userRomanInput.length() > 1)) {
			String charAtFirstIndex = Character.toString(userRomanInput.charAt(0));
			integerEquivalent = romanIntegerMap.get(charAtFirstIndex);
			
			int temp1 = 0, temp2 =0;
			for (int iterator=1; iterator <= userRomanInput.length()-1; iterator+=2) {
				
				String charAtIterator = Character.toString(userRomanInput.charAt(iterator));
				
				if ((userRomanInput.length() % 2 == 0 ) && (iterator != userRomanInput.length()-1)) {
					String charAtIterator2 = Character.toString(userRomanInput.charAt(iterator+1));
					temp2 = romanIntegerMap.get(charAtIterator2);
				}
				else if ((userRomanInput.length() % 2 == 0 ) && (iterator == userRomanInput.length()-1)){
					temp2 = 0;
					temp1 = romanIntegerMap.get(charAtIterator);
					integerEquivalent = integerEquivalent + temp2 + temp1;
					break;
				}
				if ((userRomanInput.length() % 2 != 0 ) && (iterator != userRomanInput.length()-1)) {
					String charAtIterator2 = Character.toString(userRomanInput.charAt(iterator+1));
					temp2 = romanIntegerMap.get(charAtIterator2);
				}
				
				temp1 = romanIntegerMap.get(charAtIterator);

				if (temp2 <= temp1 && temp2 !=0) {
					
					integerEquivalent = integerEquivalent + temp1 + temp2;
				}
				else {

					integerEquivalent = integerEquivalent - temp1 + temp2;
				}
			}
			
			if (integerEquivalent <1 || integerEquivalent > 5000) {
				throw new Exception();
			}
			System.out.println("Integer Rerepsentation of the Roman numeral is: " +integerEquivalent );
		}
		
		}catch (Exception exception) {
			System.out.println("Please provide a valid Roman literal. " +
		         "Valid Range is from \"I\" to \"MMMMM\".  Valid Roman literals are I, V, X, L , C, D , M");
		}

	}

}

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
		
		int [] integerValues = {1, 5, 10, 50, 100, 500, 1000};
		String [] romanNumerals = {"I", "V", "X", "L", "C", "D", "M"};
		
		/**
		 * HashMap used to store the key-value pairs since speed of operation 
		 * is the constraint than order.
		 **/
		Map<String,Integer> romanIntegerMap = new HashMap<String, Integer>();
	
		/**
		 * 	romanIntegerMap is populated based on integer array and roman numeral array.
		 * This design change is done to make the code more generic and scalable by eliminating
		 * hard-coding of key-value pairs.
		 */		
		try {
			if (romanNumerals.length == integerValues.length) {
				for (int iterator = 0; iterator < integerValues.length; iterator++) {
					romanIntegerMap.put(romanNumerals[iterator], integerValues[iterator]);
				}
				System.out.println("romanIntegerMap: " + romanIntegerMap);
			}else {
				throw new Exception();
			}
		}catch (Exception except) {
			System.out.println("please make sure that the romanNumerals array and the integerValues array mapping is correct");
		}
		
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
			
		boolean validValueCheck = RomanToIntegerConversionHelper.validateRomanNumeric(userRomanInput, romanIntegerMap);
		if (validValueCheck == false) {
			throw new Exception();	
		}
		
		/**
		 * User input validated for invalid characters. Convert to Integer 
		 */
		int integerEquivalent = 0;	
		integerEquivalent = RomanToIntegerConversionHelper.convertRomanToNumeric(userRomanInput, romanIntegerMap);
		
		/**
		 * Check the range of the converted number. 
		 */
		boolean validRangeCheck = RomanToIntegerConversionHelper.rangeCheck(integerEquivalent);
			if (validRangeCheck == false) {
				throw new Exception();
			}
			else {
				System.out.println("Integer Rerepsentation of the Roman numeral is: " +integerEquivalent );
			}
		
		}catch (Exception exception) {
			System.out.println("Please provide a valid Roman literal. " +
		         "Valid Range is from \"I\" to \"MMMMM\".  Valid Roman literals are I, V, X, L , C, D , M");
		}

	}

}

/**
 * @author Gopakumar Rajappan
 * @date   03-07-2021
 */
package ntt.roman.integer.conversion;

import java.util.Map;

public class RomanToIntegerConversionHelper {

	/**
	 * Method to check the roman numerals for invalid literals
	 * @param userRomanInput
	 * @param romanIntegerMap
	 * @return
	 */
	protected static boolean validateRomanNumeric(String userRomanInput, Map<String,Integer> romanIntegerMap) {
		boolean validationResult = false;	
		for (int iterator=0; iterator < userRomanInput.length(); iterator++) {
			for (Map.Entry<String,Integer> romanIntegerMapEntry : romanIntegerMap.entrySet()) {
				if (userRomanInput.charAt(iterator) == romanIntegerMapEntry.getKey().charAt(0)) {
					validationResult = true;
					return validationResult;
				}else {
					validationResult = false;
				}
			}
		}
		return validationResult;
	}
	
	/**
	 * Method to convert Roman numerals into Integer
	 * @param userRomanInput
	 * @param romanIntegerMap
	 * @return
	 */
	protected static int convertRomanToNumeric(String userRomanInput, Map<String,Integer> romanIntegerMap) {
		int integerEquivalent = 0;
		
		if (userRomanInput.length() == 1) {
			for (Map.Entry<String,Integer> romanIntegerMapEntry : romanIntegerMap.entrySet()) {
				if (userRomanInput.charAt(0) == romanIntegerMapEntry.getKey().charAt(0)) {
					System.out.println("Integer Rerepsentation of the Roman numeral is: " + romanIntegerMapEntry.getValue());
					integerEquivalent = romanIntegerMapEntry.getValue();
					return integerEquivalent;
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
			return integerEquivalent;
		}	
		return integerEquivalent;
	}
	
	/**
	 * Method to check the range of converted integer
	 * @param integerEquivalent
	 * @return
	 */
	protected static boolean rangeCheck (int integerEquivalent) {
		boolean validRange = false;
		if (integerEquivalent <1 || integerEquivalent > 5000) {
			return validRange;
		}
		else {
			validRange = true;
		}
		return validRange;
	}
}

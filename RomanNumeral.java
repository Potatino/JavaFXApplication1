package javafxapplication1;

public class RomanNumeral{
	String romanNumeral;
	int arabicNumeral;
	
	RomanNumeral(String romanNumeral){
		this.romanNumeral = romanNumeral;
		this.arabicNumeral = romanToDecimal();
	}
	
    int romanToDecimal() {
        int decimal = 0;
        int previousNumber = 0;
        romanNumeral = romanNumeral.toUpperCase();
        for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, previousNumber, decimal);
                    previousNumber = 1000;
                    break;

                case 'D':
                    decimal = processDecimal(500, previousNumber, decimal);
                    previousNumber = 500;
                    break;

                case 'C':
                    decimal = processDecimal(100, previousNumber, decimal);
                    previousNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, previousNumber, decimal);
                    previousNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, previousNumber, decimal);
                    previousNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, previousNumber, decimal);
                    previousNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, previousNumber, decimal);
                    previousNumber = 1;
                    break;
            }
            
        }
        return decimal;
    }

    int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }
}
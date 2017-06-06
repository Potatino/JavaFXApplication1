package javafxapplication1;

public class RomanNumeralToArabicNumeralConverter{
	static final int I = 1,
					 V = 5,
					 X = 10,
					 L = 50,
					 C = 100,
					 D = 500,
					 M = 1000;
	
	RomanNumeralToArabicNumeralConverter(){
	}

    int romanToArabic(String romanNumeral) {
        int decimal = 0;
        int previousNumber = 0;
        romanNumeral = romanNumeral.toUpperCase();
        for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(M, previousNumber, decimal);
                    previousNumber = M;
                    break;

                case 'D':
                    decimal = processDecimal(D, previousNumber, decimal);
                    previousNumber = D;
                    break;

                case 'C':
                    decimal = processDecimal(C, previousNumber, decimal);
                    previousNumber = C;
                    break;

                case 'L':
                    decimal = processDecimal(L, previousNumber, decimal);
                    previousNumber = L;
                    break;

                case 'X':
                    decimal = processDecimal(X, previousNumber, decimal);
                    previousNumber = X;
                    break;

                case 'V':
                    decimal = processDecimal(V, previousNumber, decimal);
                    previousNumber = V;
                    break;

                case 'I':
                    decimal = processDecimal(I, previousNumber, decimal);
                    previousNumber = I;
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
package javafxapplication1;

public class ArabicNumeralToRomanNumeralConverter {
	
	ArabicNumeralToRomanNumeralConverter(){
	}
	
	String convertArabicToRoman(int arabicNumeral){
		String romanNumeral = "";
		
		while(arabicNumeral >= 1000){
			romanNumeral += "M";
			arabicNumeral -= 1000;
		}
		
		while(arabicNumeral >= 900){
			romanNumeral += "CM";
			arabicNumeral -= 900;
		}
		while(arabicNumeral >= 500){
			romanNumeral += "D";
			arabicNumeral -= 500;
		}
		
		while(arabicNumeral >= 400){
			romanNumeral += "CD";
			arabicNumeral -= 400;
		}
		
		while(arabicNumeral >= 100){
			romanNumeral += "C";
			arabicNumeral -= 100;
		}
		
		while(arabicNumeral >= 90){
			romanNumeral += "XC";
			arabicNumeral -= 90;
		}
		
		while(arabicNumeral >= 50){
			romanNumeral += "L";
			arabicNumeral -= 50;
		}
		
		while(arabicNumeral >= 40){
			romanNumeral += "XL";
			arabicNumeral -= 40;
		}
		
		while(arabicNumeral >= 10){
			romanNumeral += "X";
			arabicNumeral -= 10;
		}
		
		while(arabicNumeral >= 9){
			romanNumeral += "IX";
			arabicNumeral -= 9;
		}
		
		while(arabicNumeral >= 5){
			romanNumeral += "V";
			arabicNumeral -= 5;
		}
		
		while(arabicNumeral >= 4){
			romanNumeral += "IV";
			arabicNumeral -= 4;
		}
		
		while(arabicNumeral >= 1){
			romanNumeral += "I";
			arabicNumeral -= 1;
		}
		return romanNumeral;
	}
	
}

package javafxapplication1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Converter {
        static final int MAX_POSSIBLE_VALUE = 3999,
                         MIN_POSSIBLE_VALUE = 1;
    
        PrintStream out;
	Scanner in;
        RomanNumeralToArabicNumeralConverter romanNumeralToArabicNumeral;
	ArabicNumeralToRomanNumeralConverter arabicNumeralToRomanNumeral;
        
        Converter(){
        out = new PrintStream(System.out);
	in = new Scanner(System.in);
        romanNumeralToArabicNumeral = new RomanNumeralToArabicNumeralConverter();
	arabicNumeralToRomanNumeral = new ArabicNumeralToRomanNumeralConverter();
        }
        
        char getOperator(String x){
		return x.charAt(0);
	}
        
        void exitProgram(){
		out.printf("Exiting");
		System.exit(1);
	}
        
        void print(int number){
		out.printf("%s\n", arabicNumeralToRomanNumeral.convertArabicToRoman(number));
	}
        
        boolean readInRange(int value, int min, int max){ out = new PrintStream(System.out);
	in = new Scanner(System.in);
		if(value > max){
			//out.printf("ERROR: Overflow\n"); //make this appear on screen
			return false;
                    }
		else if(value < min){
			//out.printf("ERROR: Underflow\n");//make this appear on screen
			return false;
                    }
                    return true;
                }
                
                int oneRomanNumeral(String lineString, int total){
		char operator = lineString.charAt(0);
		int result, finalResult;
		result = romanNumeralToArabicNumeral.romanToArabic(lineString);
		if(total != 0){
			finalResult = calculateResult(total, result, operator);
		}else{
                    finalResult = result;
		}   if (readInRange(finalResult, MIN_POSSIBLE_VALUE-1, MAX_POSSIBLE_VALUE)){
			if(finalResult == MIN_POSSIBLE_VALUE){
				out.printf("\n");
				return total;
			}else{
				//out.printf("%d\n", finalResult);
				return finalResult;
			}
                    }
		return total;
            }
                
                
                int twoRomanNumerals(String lineString){
		Scanner currentLineScanner = new Scanner(lineString);
		int finalResult;
		int firstNumber, 
                    secondNumber;
		
		firstNumber = romanNumeralToArabicNumeral.romanToArabic(currentLineScanner.next());
		char operator = getOperator(currentLineScanner.next());
		secondNumber = romanNumeralToArabicNumeral.romanToArabic(currentLineScanner.next());
		
		finalResult = calculateResult(firstNumber, secondNumber, operator);
		finalResult = calculateResult(finalResult, 0, operator);
		
		if (readInRange(finalResult, MIN_POSSIBLE_VALUE, MAX_POSSIBLE_VALUE)){
			if(finalResult == 0){
				out.printf("\n");
				out.printf("Error, out of range");
				return 0;
			} else{
				return finalResult;
			}
                    }
		return 0;
            }
                boolean endError(){
            out.printf("Unable to display in Roman Numerals\n");
            return false;
        }
                int calculateResult(int number1, int number2, char operator){
		int finalResult;
		
		switch(operator){
		case '+':
			finalResult = number1 + number2;
			return finalResult;
		case '-':
			finalResult = number1 - number2;
			return finalResult;
		case '*':
			if(number1 == 0) number1 = 1;
			if(number2 == 0) number2 = 1;
			finalResult = number1 * number2;
			return finalResult;
		case '/':
			if(number1 == 0) number1 = 1;
			if(number2 == 0) number2 = 1;
			finalResult = number1 / number2;
                        if(finalResult == 0){ 
                            endError();
                        } else;
			return finalResult;
		default:
			finalResult = -1;
			return finalResult;
                    }
                }
                
        void start(Stage stage){

        Group root = new Group();
        Scene scene = new Scene(root, 300, 100);
        stage.setScene(scene);
        stage.setTitle("Roman Calculator");
        stage.show();
                
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        scene.setRoot(grid);

        final TextField name = new TextField();
        name.setPromptText("Enter the calculation.");
        name.setPrefColumnCount(10);
        name.getText();
        GridPane.setConstraints(name, 0, 0);
        grid.getChildren().add(name);

        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 1, 0);
        grid.getChildren().add(submit);
        
        Button back = new Button("Back");
        GridPane.setConstraints(back, 2, 0);
        grid.getChildren().add(back);

        final Label label = new Label();
        GridPane.setConstraints(label, 0, 3);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);
        
        back.setOnAction((ActionEvent) -> {
        new JavaFXApplication1().start(stage);
        });
        
        submit.setOnAction((ActionEvent) -> {
            try{
            if (name.getText() == null || name.getText().isEmpty()) {
            label.setText("Is empty");
            } 
            } catch(Throwable e){
                Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, e);
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("History.txt", true))) {
            writer.append((name.getText()));
            writer.append(" \r\n");
        }   catch (IOException ex) {
                Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            String Calc = name.getText();
            char FirstNum = Calc.charAt(0);
            char SecondNum = Calc.charAt(4);
                int FinalO = twoRomanNumerals(Calc);
                label.setText("" + FinalO);
        });
        stage.show();
                }
            }

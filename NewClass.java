package javafxapplication1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewClass extends Application {
        @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 100);
        stage.setScene(scene);
        stage.setTitle("Arabic Calculator");
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
            String[]words = Calc.split(" ");
            float FirstNum = Float.parseFloat(words[0]);
            float SecondNum = Float.parseFloat(words[2]);
            float FinalNum = 0;
            if("+".equals(words[1])){
                FinalNum = FirstNum + SecondNum;
                label.setText("The answer is " + FinalNum);
            } else if ("-".equals(words[1])){
                FinalNum = FirstNum - SecondNum;
                label.setText("The answer is " + FinalNum);
            } else if ("*".equals(words[1])){
                FinalNum = FirstNum * SecondNum;
                label.setText("The answer is " + FinalNum);
            } else if ("/".equals(words[1])){
                FinalNum = FirstNum / SecondNum;
                label.setText("The answer is " + FinalNum);
            }
        });
        stage.show();
    }
    public static void main() {
    }
}
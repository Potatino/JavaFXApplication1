package javafxapplication1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ReadHistory {
     public void ReadHistory(Stage stage) throws FileNotFoundException, IOException{
    try (BufferedReader br = new BufferedReader(new FileReader("History.txt"))) {
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();

    while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
    }
    
        String everything = sb.toString();
        
        Group root = new Group();
        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);
        stage.setTitle("Calculation History");
        stage.show();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        scene.setRoot(grid);
        
        final Label label = new Label();
        GridPane.setConstraints(label, 0, 0);
        GridPane.setColumnSpan(label, 1);
        grid.getChildren().add(label);
        label.setText(everything);
        
        Button back = new Button("Back");
        GridPane.setConstraints(back, 1, 0);
        grid.getChildren().add(back);
        
        back.setOnAction((ActionEvent) -> {
        new JavaFXApplication1().start(stage);
        });
        }
    }
}
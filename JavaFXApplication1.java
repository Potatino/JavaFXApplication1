package javafxapplication1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXApplication1 extends Application {
             
    private static final String History = "‪C:\\Users\\Potatino\\Desktop\\JavaFXApplication1\\History.txt";
    @Override
    public void start(Stage stage) {
        
        Button btn = new Button();
        Button btt = new Button();
        Button bnn = new Button();
        btn.setText("View History");
        btt.setText("Arabic Calculator");
        bnn.setText("Roman Calculator");
        
        btn.setOnAction((ActionEvent event) -> {
            try {
                new ReadHistory().ReadHistory(stage);
            } catch (IOException ex) {
                Logger.getLogger(JavaFXApplication1.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btt.setOnAction((ActionEvent event) -> {
            String str = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("History.txt"))) {
            writer.write(str);
        }   catch (IOException ex) {
                Logger.getLogger(JavaFXApplication1.class.getName()).log(Level.SEVERE, null, ex);
            }
        new NewClass().start(stage);
        });
        
        bnn.setOnAction((ActionEvent event) -> {
        new Converter().start(stage);
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(btt);
        root.getChildren().add(bnn);
        btt.setTranslateX(-65);
        btt.setTranslateY(-50);
        bnn.setTranslateX(65);
        bnn.setTranslateY(-50);
        
        
        
        Scene scene = new Scene(root, 300, 150);
        stage.setTitle("The Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

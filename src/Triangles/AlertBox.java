package Triangles;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AlertBox {
    public static void display(String title, String message, String buttonText){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        //previous window will not be closed before closing of this window
        window.setTitle(title);
        window.setMaxWidth(300);

        Label label = new Label(message);
        Button closeButton = new Button(buttonText);
        closeButton.setOnAction(e -> window.close());

        VBox root = new VBox(30);
        // Creation new VBox with spacing 10 between label and closeButton with text
        root.getChildren().addAll(label, closeButton);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.showAndWait();
        //previous window will not be reached before closing of this window
    }
}

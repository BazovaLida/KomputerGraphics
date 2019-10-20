package Astroida;

import Triangles.AlertBox;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;

public class L2 extends Application{
    public static void main(String[] args) { launch(args); }

    private static Double A = 4.0;
    private static Double B = 3.0;
    private static Double R = 50.0;
    private static Double N = 2.0;
    private static Double dist = 130.0;
    private static Double num = 30.0;
    private static Double density = 1.5;
    
    private static int width = 1920;
    private static int height = 1060;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Лабороторна робота № 2. Базова Л.Г. ІВ-81");
        Label labl = new Label("Астроїда: ");
        Label labl1 = new Label("X = A*R*sin^3(t)");
        Label labl2 = new Label("X = B*R*cos^3(t)");
        Label labl3 = new Label("0 < t < N*pi");

        Label l1 = new Label("A");
        Label l2 = new Label("B");
        Label l3 = new Label("R");
        Label l4 = new Label("N");
        Label l5 = new Label("Відстань");
        Label l6 = new Label("Кількість повторень у муарі");
        Label l7 = new Label("Щільність муару");


        TextField aInput = new TextField(Double.toString(A));
        TextField bInput = new TextField(Double.toString(B));
        TextField rInput = new TextField(Double.toString(R));
        TextField nInput = new TextField(Double.toString(N));
        TextField distInput = new TextField(Double.toString(dist));
        TextField numInput = new TextField(Double.toString(num));
        TextField dInput = new TextField(Double.toString(density));


        String title1 = "Початкова фігура";
        String title2 = "Орнамент";
        String title3 = "Муар";

        Button button = new Button("Змінити");
        Button button1 = new Button(title1);
        Button button2 = new Button(title2);
        Button button3 = new Button(title3);

        button.setOnAction(e -> rightValue(aInput, rInput, bInput, nInput, distInput, numInput, dInput));
        button1.setOnAction(e -> first(title1));
        button2.setOnAction(e -> second(title2));
        button3.setOnAction(e -> third(title3));

        GridPane grid = new GridPane();
        grid.setVgap(50);
        grid.setHgap(20);
        GridPane.setConstraints(aInput, 2, 1);
        GridPane.setConstraints(bInput, 2, 2);
        GridPane.setConstraints(rInput, 2, 3);
        GridPane.setConstraints(nInput, 2, 4);
        GridPane.setConstraints(distInput, 4, 1);
        GridPane.setConstraints(numInput, 4, 2);
        GridPane.setConstraints(dInput, 4, 3);
        GridPane.setConstraints(labl, 5, 1);
        GridPane.setConstraints(labl1, 5, 2);
        GridPane.setConstraints(labl2, 5, 3);
        GridPane.setConstraints(labl3, 5, 4);


        GridPane.setConstraints(l1, 1, 1);
        GridPane.setConstraints(l2, 1, 2);
        GridPane.setConstraints(l3, 1, 3);
        GridPane.setConstraints(l4, 1, 4);
        GridPane.setConstraints(l5, 3, 1);
        GridPane.setConstraints(l6, 3, 2);
        GridPane.setConstraints(l7, 3, 3);


        GridPane.setConstraints(button, 5, 5);
        GridPane.setConstraints(button1, 2, 5);
        GridPane.setConstraints(button2, 3, 5);
        GridPane.setConstraints(button3, 4, 5);

        grid.getChildren().addAll(aInput, rInput, bInput, nInput, distInput, numInput, dInput,
                l1, l2, l3, l4, l5, l6, l7, button, button1, button2, button3, labl, labl1, labl2, labl3);

        Scene scene = new Scene(grid, width-920, height-560);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static Path graphic(Color color, Double w, Double h){
        Path path = new Path();
        path.setStroke(color);
        Double t = 0.0;
        MoveTo moveTo = new MoveTo(A*R+w, h);
        path.getElements().add(moveTo);
        while (t <= N*Math.PI){
            LineTo line1= new LineTo(w+A*R*pow(sin(t), 3.0)+A*R, h-B*R*pow(cos(t), 3.0)+B*R);
            t = t + 0.01;
            path.getElements().add(line1);
        }
        return path;
    }

    private static void first(String title){
        Path graph = graphic(Color.DARKORCHID, 0.0, 0.0);
        Group group = new Group(graph);
        Scene scene = new Scene(group, width-920, height-560);
        Stage window = new Stage();
        window.setScene(scene);
        window.setTitle(title);
        window.show();
    }
    private static void second(String title){
        Group group = new Group();
        Path astroids;
        for (int i = 0; i*dist+2*A*R < width; i++) {
            for (int j = 0; j*dist+2*B*R < height; j++) {
                astroids = graphic(Color.WHITE, dist*i, dist*j);
                group.getChildren().addAll(astroids);
            }
        }
        Scene scene = new Scene(group, width, height, Color.BLACK);
        Stage window = new Stage();
        window.setScene(scene);
        window.setTitle(title);
        window.show();
    }
    private static void third(String title){
        Group group = new Group();
        Path astroids;
        for  (int i = 0; i*dist+3*A*R < width; i++) {
            for (int j = 0; j*dist+3*B*R < height; j++) {
                for (int k = 0; k < num; k++) {
                    Point3D points = new Point3D(width, height, 0);
                    Rotate rotate = new Rotate(k* density, points);
                    astroids = graphic(Color.WHITE, dist*i, dist*j);
                    astroids.getTransforms().add(rotate);
                    group.getChildren().add(astroids);
                }
            }
        }
        Scene scene = new Scene(group, width, height, Color.BLACK);
        Stage window = new Stage();
        window.setScene(scene);
        window.setTitle(title);
        window.show();
    }

    private void rightValue(TextField i1, TextField i2, TextField i3, TextField i4, TextField i5, TextField i6, TextField i7){
        try {
            A = parseDouble(i1.getText());
            R = parseDouble(i2.getText());
            B = parseDouble(i3.getText());
            N = parseDouble(i4.getText());
            dist = parseDouble(i5.getText());
            num = parseDouble(i6.getText());
            density = parseDouble(i7.getText());

        }catch (NumberFormatException e){
            AlertBox.display("Помилка", "Введіть числа.", "Змінити значення");
        }
    }
}

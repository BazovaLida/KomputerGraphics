package Triangles;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import static java.lang.Double.parseDouble;
import static java.lang.Math.abs;
import static java.lang.Math.random;


public class Main extends Application{
    public static void main(String[] args) { launch(args); }
    private static Double x1 = 100.0;
    private static Double y1 = 0.0;
    private static Double x2 = 0.0;
    private static Double y2 = 170.0;
    private static Double x3 = 200.0;
    private static Double y3 = 170.0;
    private static Double number = 0.0;
    private static Double a = 500.0;
    private static Double s = 50000.0;

    //creation of values

    private static int width = 1920;
    private static int height = 1060;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Лабороторна робота № 1. Базова Л.Г. ІВ-81");
//        Label label = new Label("Фігура за варіантом - тикутник." +
//                "Щоб змінити параметри трикутника, введіть нові значення та натисніть кнопку 'Змінити'");
        Label l1 = new Label("X1");
        Label l2 = new Label("X2");
        Label l3 = new Label("X3");
        Label l4 = new Label("Y1");
        Label l5 = new Label("Y2");
        Label l6 = new Label("Y3");
        Label l7 = new Label("Відступ у орнаменті");
        Label l8 = new Label("Трвалість анімації");
        Label l9 = new Label("Швидкість анімації");


        TextField x1Input = new TextField(Double.toString(x1));
        TextField x2Input = new TextField(Double.toString(x2));
        TextField x3Input = new TextField(Double.toString(x3));
        TextField y1Input = new TextField(Double.toString(y1));
        TextField y2Input = new TextField(Double.toString(y2));
        TextField y3Input = new TextField(Double.toString(y3));
        TextField numInput = new TextField(Double.toString(number));
        TextField aInput = new TextField(Double.toString(a));
        TextField sInput = new TextField(Double.toString(s));


        String title1 = "Початкова фігура";
        String title2 = "Орнамент";
        String title3 = "Анімація";
        String title4 = "Додаткова анімація";

        Button button = new Button("Змінити");
        Button button1 = new Button(title1);
        Button button2 = new Button(title2);
        Button button3 = new Button(title3);
        Button button4 = new Button(title4);

        button.setOnAction(e -> rightValue(x1Input, x2Input, x3Input, y1Input, y2Input, y3Input, numInput, aInput, sInput));
        button1.setOnAction(e -> first(title1));
        button2.setOnAction(e -> second(title2, false));
        button3.setOnAction(e -> second(title2, true));
        button4.setOnAction(e -> four(title4));


        GridPane grid = new GridPane();
        grid.setVgap(50);
        grid.setHgap(20);
        GridPane.setConstraints(x1Input, 2, 1);
        GridPane.setConstraints(x2Input, 2, 2);
        GridPane.setConstraints(x3Input, 2, 3);
        GridPane.setConstraints(y1Input, 4, 1);
        GridPane.setConstraints(y2Input, 4, 2);
        GridPane.setConstraints(y3Input, 4, 3);
        GridPane.setConstraints(numInput, 6, 1);
        GridPane.setConstraints(aInput, 6, 2);
        GridPane.setConstraints(sInput, 6, 3);


        GridPane.setConstraints(l1, 1, 1);
        GridPane.setConstraints(l2, 1, 2);
        GridPane.setConstraints(l3, 1, 3);
        GridPane.setConstraints(l4, 3, 1);
        GridPane.setConstraints(l5, 3, 2);
        GridPane.setConstraints(l6, 3, 3);
        GridPane.setConstraints(l7, 5, 1);
        GridPane.setConstraints(l8, 5, 3);
        GridPane.setConstraints(l9, 5, 2);


        GridPane.setConstraints(button, 3, 4);
        GridPane.setConstraints(button1, 2, 5);
        GridPane.setConstraints(button2, 3, 5);
        GridPane.setConstraints(button3, 4, 5);
        GridPane.setConstraints(button4, 5, 5);

        grid.getChildren().addAll(x1Input, x2Input, x3Input,y1Input, y2Input, y3Input, numInput, aInput, sInput,
                l1, l2, l3, l4, l5, l6, l7, l8, l9, button, button1, button2, button3, button4);

        Scene scene = new Scene(grid, width-920, height-560);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private static void first(String title){
        Polygon triangle = new Polygon(400+x1, 100+y1, 400+x2, 100+y2, 400+x3, 100+y3);
        triangle.setFill(Color.MEDIUMSLATEBLUE);
        Group group = new Group(triangle);
        Scene scene = new Scene(group, width-920, height-560);
        Stage window = new Stage();
        window.setScene(scene);
        window.setTitle(title);
        window.show();
    }
    private static void second(String title, boolean flag) {
        Group group = new Group();
        Scene scene = new Scene(group, width, height, Color.LIGHTCYAN);
        Stage window = new Stage();
        window.setScene(scene);
        int i = 0;
        int j;
        Polygon triangle1;
        Polygon triangle2;
        while (x1+i*x3 <= width){
            j= 0;
            while (y1+j*2*y2 <=height){
                Double p = i*(x3+number);
                Double d = j*(2*y2+ number);
                triangle1 = new Polygon(p+x1, d+y1, p+x2, d+y2, p+x3, d+y3);
                triangle2 = new Polygon(p+x1, d+y1+y2*2, p+x2, d+y2, p+x3, d+y3);
                if(abs(i-j) % 4 == 0 ){
                    triangle1.setFill(Color.AQUA);
                    triangle2.setFill(Color.TEAL);
                } else if(abs(i-j) % 4 == 1){
                    triangle1.setFill(Color.AQUAMARINE);
                    triangle2.setFill(Color.TURQUOISE);
                } else if (abs(i-j) % 4 == 2){
                    triangle1.setFill(Color.SEAGREEN);
                    triangle2.setFill(Color.DARKTURQUOISE);
                }else{
                    triangle1.setFill(Color.MEDIUMAQUAMARINE);
                    triangle2.setFill(Color.LIGHTSEAGREEN);
                } j++;
                group.getChildren().addAll(triangle1, triangle2);
            }
            i++;
        }
        if(flag){
            Timeline timeline = new Timeline();
            for (Node pol: group.getChildren()) {
                timeline.getKeyFrames().addAll(
                        new KeyFrame(new Duration(s), // set end position at s seconds
                                new KeyValue(pol.translateXProperty(), random() * a),
                                new KeyValue(pol.translateYProperty(), random() * a)
                        )
                );
            }
            timeline.play();
        }
        window.setTitle(title);
        window.show();
    }

    private static void four(String title){

        Group group = new Group();
        Scene scene = new Scene(group, width-720, height-360, Color.BLACK);
        Stage window = new Stage();
        window.setScene(scene);
        Group polygons = new Group();
        for (int i = 0; i < 25; i++) {

            Polygon polygon = new Polygon(20+2*x1, 15+2*y1, 20+2*x2, 15+2*y2, 20+2*x3, 15+2*y3);
            polygon.setFill(Color.web("white", 0.1));
            polygons.getChildren().add(polygon);
        }
        Rectangle colors = new Rectangle(width, height,
                new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.REPEAT,
                        new Stop(0, Color.TAN),
                        new Stop(0.14, Color.NAVAJOWHITE),
                        new Stop(0.28, Color.BISQUE),
                        new Stop(0.43, Color.SEASHELL),
                        new Stop(0.57, Color.MEDIUMTURQUOISE),
                        new Stop(0.71, Color.LIGHTSEAGREEN),
                        new Stop(0.85, Color.DARKCYAN),
                        new Stop(1, Color.TEAL)));
        colors.widthProperty().bind(scene.widthProperty());
        colors.heightProperty().bind(scene.heightProperty());

        Group blendModeGroup =
                new Group(new Group(new Rectangle(scene.getWidth(), scene.getHeight(), Color.BLACK), polygons), colors);
        colors.setBlendMode(BlendMode.OVERLAY);
        group.getChildren().add(blendModeGroup);

        polygons.setEffect(new BoxBlur(10, 10, 3));
        Timeline timeline = new Timeline();
        for (Node pol: polygons.getChildren()) {
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO, // set start position at 0
                            new KeyValue(pol.translateXProperty(), (random()-0.3) * 900),
                            new KeyValue(pol.translateYProperty(), (random()+0.3) * 200)
                    ),
                    new KeyFrame(new Duration(s), // set end position at 40s
                            new KeyValue(pol.translateXProperty(), (random()+0.3) * 900),
                            new KeyValue(pol.translateYProperty(), (random()-0.3) * 300)
                    )
            );
        }
        timeline.play();
        window.setTitle(title);
        window.show();
    }
    private void rightValue(TextField i1, TextField i2, TextField i3, TextField i4, TextField i5, TextField i6,
                            TextField i7, TextField i8, TextField i9){
        try {
            x1 = parseDouble(i1.getText());
            x2 = parseDouble(i2.getText());
            x3 = parseDouble(i3.getText());
            y1 = parseDouble(i4.getText());
            y2 = parseDouble(i5.getText());
            y3 = parseDouble(i6.getText());
            number = parseDouble(i7.getText());
            a = parseDouble(i8.getText());
            s = parseDouble(i9.getText());
        }catch (NumberFormatException e){
            AlertBox.display("Помилка", "Введіть числа.", "Змінити значення");
        }
    }
}
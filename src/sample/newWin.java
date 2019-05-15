package sample;


import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class newWin {

    public static void display (int gen, Stage prev)
    {
        final int generation = gen + 1;

        java.util.Random rnd = new java.util.Random();

        Stage win = new Stage();
        win.initModality(Modality.APPLICATION_MODAL);

        win.setTitle("Close me as well now");

        Button btn = new Button("Shut me up");

        Label msg = new Label("Ha!");
        VBox layout = new VBox(10);
        layout.getChildren().addAll(msg, btn);
        Scene s = new Scene(layout, 100, 100);

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double x = screenBounds.getWidth() * rnd.nextDouble();
        double y = screenBounds.getHeight() * rnd.nextDouble();

        win.setX(x);
        win.setY(y);

        win.setScene(s);
        win.show();

        btn.setOnAction( e -> {
            for (int i = 0; i < generation; i++) {
                newWin.display(generation, win);
            }
        });

        win.setOnCloseRequest(e -> {
            e.consume();
            display(generation, win);
        });
    }

}

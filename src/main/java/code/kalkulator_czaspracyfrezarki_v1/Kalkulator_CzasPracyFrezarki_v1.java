package code.kalkulator_czaspracyfrezarki_v1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Kalkulator_CzasPracyFrezarki_v1 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Kalkulator_CzasPracyFrezarki_v1.class.getResource("Szablon.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Kalkulator - czas pracy frezarki!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
package bennyngo.hwcs151javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class JavaFXApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Demo");

        // Create UI components
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Button submitButton = new Button("Submit");

        // Create a layout and add components
        VBox vbox = new VBox(10); // 10 is the spacing between elements
        vbox.getChildren().addAll(nameLabel, nameField, submitButton);
        vbox.setAlignment(Pos.CENTER);

        // Create a TranslateTransition for the button
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), submitButton);

        // Set the target position for the button (move 150 pixels to the right)
        translateTransition.setFromX(0);
        translateTransition.setToX(150);

        // Set the cycle count for the animation (infinite in this case)
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);

        // Set auto-reverse to true (the button will move back and forth)
        translateTransition.setAutoReverse(true);

        // Set the event handler for the button click
        submitButton.setOnAction(event -> {
            showAlert("Your name is " + nameField.getText());
            // Start the animation when the button is clicked
            translateTransition.play();
        });

        // Create a scene
        Scene scene = new Scene(vbox, 300, 300);

        // Set the scene to the stage
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}
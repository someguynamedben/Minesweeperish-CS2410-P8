package cs2410.assn8;

import cs2410.assn8.Controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
    Controller controller = new Controller();
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Controller/gameboard.fxml"));
        primaryStage.setTitle("Minesweeperish");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
    
        Alert additionalRequirements = new Alert(Alert.AlertType.INFORMATION);
        additionalRequirements.setTitle("Additional Requirements");
        additionalRequirements.setGraphic(null);
        additionalRequirements.setHeaderText(null);
        additionalRequirements.setContentText("I implemented the following features:\n\n10pts - Difficulty.\n15pts - Sounds. This is fully functional.\n5pts - Reporting. I haven't implemented this yet.");
        //additionalRequirements.showAndWait();
        
        primaryStage.setOnCloseRequest(this::handleClose);
        
        primaryStage.show();
    }
    
    private void handleClose(WindowEvent windowEvent){
        System.exit(0);
        controller.timer.cancel();
    }
    
    public static void main(String[] args) { launch(args); }
}

package cs2410.assn8.View;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.text.Text;

public class Scoreboard{
    @FXML
    private Text timeText;
    @FXML
    private Text minesText;
    @FXML
    private CheckMenuItem easyBtn;
    @FXML
    private CheckMenuItem mediumBtn;
    @FXML
    private CheckMenuItem hardBtn;

    @FXML
    private void selectedEasy(){
        System.out.println("you selected easy");
        mediumBtn.setSelected(false);
        hardBtn.setSelected(false);
    }
    
    @FXML
    private void selectedMedium(){
        System.out.println("you selected medium");
        easyBtn.setSelected(false);
        hardBtn.setSelected(false);
    }
    
    @FXML
    private void selectedHard(){
        System.out.println("you selected hard");
        easyBtn.setSelected(false);
        mediumBtn.setSelected(false);
    }
    
    @FXML
    private void handleStartBtn(){
        System.out.println("you pressed start");
        //controller.startGame();
        //timeText.setText(String.valueOf(time));
        //minesText.setText(String.valueOf(numMines));
    }
    
    @FXML
    private void handleScoreboardBtn(){
        Alert scoreboard = new Alert(Alert.AlertType.INFORMATION);
        scoreboard.setTitle("High Scores");
        scoreboard.setGraphic(null);
        scoreboard.setHeaderText(null);
        scoreboard.setContentText("[insert high scores here]");
        scoreboard.showAndWait();
    }
    
    @FXML
    private void handleDelScores(){
        ButtonType result = confirmDel();
        if(result == ButtonType.OK){
            System.out.println("you hit ok");
        }
    }
    
    private ButtonType confirmDel(){
        Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDelete.setTitle(null);
        confirmDelete.setGraphic(null);
        confirmDelete.setHeaderText(null);
        confirmDelete.setContentText("Do you really want to delete all the high scores?");
        confirmDelete.showAndWait();
        
        return confirmDelete.getResult();
    }
    
    @FXML
    private void handleExitBtn(){ System.exit(0); }
    
    public void setTimeText(int tempTime){
        timeText.setText(String.valueOf(tempTime));
    }
    public void setMinesText(int tempNumMines){
        minesText.setText(String.valueOf(tempNumMines));
    }
}

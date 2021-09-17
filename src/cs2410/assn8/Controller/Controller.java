package cs2410.assn8.Controller;

import cs2410.assn8.View.Assets;
import cs2410.assn8.View.Cell;
import cs2410.assn8.View.Scoreboard;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class Controller{
    private ArrayList<ArrayList<Cell>> gameBoard = new ArrayList<>();
    private Assets assets = Assets.getInstance();
    private Scoreboard scoreboard = new Scoreboard();
    private boolean isPlaying;
    private boolean isGameOver;
    private Cell cell;
    @FXML
    private GridPane gridPane;
    Random rand = new Random();
    int randI, randJ;
    int numMines = 40;
    public Timer timer = new Timer();
    private GameTimer gameTimer = new GameTimer();
    private int timeCount;
    private boolean didPlayerWin;
    
    public Controller(){
        isPlaying = false;
        isGameOver = false;
        int tempNumMines = 0;
        timeCount = 0;
        
        for(int i = 0; i < 20; i++){
            ArrayList<Cell> boardCol = new ArrayList<>();
            gameBoard.add(i, boardCol);
            
            for(int j = 0; j < 20; j++){
                cell = new Cell(i, j);
                handleMouseClick(cell);
                boardCol.add(j, cell);
            }
        }
    
        while(numMines > 0){
            randI = rand.nextInt(20);
            randJ = rand.nextInt(20);
        
            if(!gameBoard.get(randI).get(randJ).getIsMine()){
                gameBoard.get(randI).get(randJ).setIsMine();
                numMines--;
            }
        }
        
        numMines = 40;
    
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                if(gameBoard.get(i).get(j).getPosX() == 0){
                    if(gameBoard.get(i).get(j).getPosY() == 0){
                        if(gameBoard.get(i + 1).get(j).getIsMine()){
                            tempNumMines++;
                        }
                        if(gameBoard.get(i + 1).get(j + 1).getIsMine()){
                            tempNumMines++;
                        }
                        if(gameBoard.get(i).get(j + 1).getIsMine()){
                            tempNumMines++;
                        }
                    }else if(gameBoard.get(i).get(j).getPosY() == 19){
                        if(gameBoard.get(i).get(j - 1).getIsMine()){
                            tempNumMines++;
                        }
                        if(gameBoard.get(i + 1).get(j - 1).getIsMine()){
                            tempNumMines++;
                        }
                        if(gameBoard.get(i +1).get(j).getIsMine()){
                            tempNumMines++;
                        }
                    }else{
                        if(gameBoard.get(i).get(j - 1).getIsMine()){
                            tempNumMines++;
                        }
                        if(gameBoard.get(i + 1).get(j - 1).getIsMine()){
                            tempNumMines++;
                        }
                        if(gameBoard.get(i + 1).get(j).getIsMine()){
                            tempNumMines++;
                        }
                        if(gameBoard.get(i + 1).get(j + 1).getIsMine()){
                            tempNumMines++;
                        }
                        if(gameBoard.get(i).get(j + 1).getIsMine()){
                            tempNumMines++;
                        }
                    }
                }else if(gameBoard.get(i).get(j).getPosX() == 19){
                    if(gameBoard.get(i).get(j).getPosY() == 0){
                        if(gameBoard.get(i - 1).get(j).getIsMine()){
                            tempNumMines++;
                        }
                        if(gameBoard.get(i - 1).get(j + 1).getIsMine()){
                            tempNumMines++;
                        }
                        if(gameBoard.get(i).get(j + 1).getIsMine()){
                            tempNumMines++;
                        }
                    }else if(gameBoard.get(i).get(j).getPosY() == 19){
                        if(gameBoard.get(i).get(j - 1).getIsMine()){
                            tempNumMines++;
                        }
                        if(gameBoard.get(i - 1).get(j - 1).getIsMine()){
                            tempNumMines++;
                        }
                        if(gameBoard.get(i - 1).get(j).getIsMine()){
                            tempNumMines++;
                        }
                    }else{
                        if(gameBoard.get(i).get(j - 1).getIsMine()){
                            tempNumMines++;
                        }
                        if(gameBoard.get(i - 1).get(j - 1).getIsMine()){
                            tempNumMines++;
                        }
                        if(gameBoard.get(i - 1).get(j).getIsMine()){
                            tempNumMines++;
                        }
                        if(gameBoard.get(i - 1).get(j + 1).getIsMine()){
                            tempNumMines++;
                        }
                        if(gameBoard.get(i).get(j + 1).getIsMine()){
                            tempNumMines++;
                        }
                    }
                }else if(gameBoard.get(i).get(j).getPosY() == 0){
                    if(gameBoard.get(i - 1).get(j).getIsMine()){
                        tempNumMines++;
                    }
                    if(gameBoard.get(i - 1).get(j + 1).getIsMine()){
                        tempNumMines++;
                    }
                    if(gameBoard.get(i).get(j + 1).getIsMine()){
                        tempNumMines++;
                    }
                    if(gameBoard.get(i + 1).get(j + 1).getIsMine()){
                        tempNumMines++;
                    }
                    if(gameBoard.get(i + 1).get(j).getIsMine()){
                        tempNumMines++;
                    }
                }else if(gameBoard.get(i).get(j).getPosY() == 19){
                    if(gameBoard.get(i - 1).get(j).getIsMine()){
                        tempNumMines++;
                    }
                    if(gameBoard.get(i - 1).get(j - 1).getIsMine()){
                        tempNumMines++;
                    }
                    if(gameBoard.get(i).get(j - 1).getIsMine()){
                        tempNumMines++;
                    }
                    if(gameBoard.get(i + 1).get(j - 1).getIsMine()){
                        tempNumMines++;
                    }
                    if(gameBoard.get(i + 1).get(j).getIsMine()){
                        tempNumMines++;
                    }
                }else{
                    if(gameBoard.get(i - 1).get(j).getPosX() >= 0){        //left
                        if(gameBoard.get(i - 1).get(j).getIsMine()){
                            tempNumMines++;
                        }
                    }
                    if(gameBoard.get(i + 1).get(j).getPosX() < 20){      //right
                        if(gameBoard.get(i + 1).get(j).getIsMine()){
                            tempNumMines++;
                        }
                    }
                    if(gameBoard.get(i).get(j - 1).getPosY() >= 0){      //up
                        if(gameBoard.get(i).get(j - 1).getIsMine()){
                            tempNumMines++;
                        }
                    }
                    if(gameBoard.get(i).get(j + 1).getPosY() < 20){      //down
                        if(gameBoard.get(i).get(j + 1).getIsMine()){
                            tempNumMines++;
                        }
                    }
                    if(gameBoard.get(i - 1).get(j - 1).getPosX() >= 0 && gameBoard.get(i - 1).get(j - 1).getPosY() >= 0){    //top left
                        if(gameBoard.get(i - 1).get(j - 1).getIsMine()){
                            tempNumMines++;
                        }
                    }
                    if(gameBoard.get(i + 1).get(j - 1).getPosX() < 20 && gameBoard.get(i + 1).get(j - 1).getPosY() >= 0){    //top right
                        if(gameBoard.get(i + 1).get(j - 1).getIsMine()){
                            tempNumMines++;
                        }
                    }
                    if(gameBoard.get(i - 1).get(j + 1).getPosX() >= 0 && gameBoard.get(i - 1).get(j + 1).getPosY() < 20){    //bottom left
                        if(gameBoard.get(i - 1).get(j + 1).getIsMine()){
                            tempNumMines++;
                        }
                    }
                    if(gameBoard.get(i + 1).get(j + 1).getPosX() < 20 && gameBoard.get(i + 1).get(j + 1).getPosY() < 20){    //bottom right
                        if(gameBoard.get(i + 1).get(j + 1).getIsMine()){
                            tempNumMines++;
                        }
                    }
                }
                
                gameBoard.get(i).get(j).setNumMinesNear(tempNumMines);
                tempNumMines = 0;
            }
        }
    }
    
    @FXML
    public void initialize(){
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                gridPane.add(gameBoard.get(i).get(j), i, j);
            }
        }
    }
    
    private void startGame(){
        isPlaying = true;
        
        //gameTimer.startTimer();
        
        //scoreboard.setMinesText(numMines);                    //this doesn't work for some reason

        timer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                timeCount++;
                //scoreboard.setTimeText(timeCount);            //this also doesn't work for some reason
            }
        }, 0, 1000);
    }
    
    private void gameOver(boolean playerWon){
        timer.cancel();
        timer.purge();
        isPlaying = false;
        isGameOver = true;
        Alert gameOverAlert = new Alert(Alert.AlertType.INFORMATION);
        gameOverAlert.setTitle(null);
        gameOverAlert.setGraphic(null);
        gameOverAlert.setHeaderText(null);
        
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                if(gameBoard.get(i).get(j).getIsMine()){
                    if(gameBoard.get(i).get(j).getChildren().contains(gameBoard.get(i).get(j).getCoveredCell())){     //?????????
                        gameBoard.get(i).get(j).getChildren().remove(gameBoard.get(i).get(j).getCoveredCell());
                        gameBoard.get(i).get(j).getChildren().add(gameBoard.get(i).get(j).getMineCell());
                        gameBoard.get(i).get(j).setStyle("-fx-background-color: red");
                    }else if(gameBoard.get(i).get(j).getChildren().contains(gameBoard.get(i).get(j).getFlagCell())){
                        gameBoard.get(i).get(j).getChildren().remove(gameBoard.get(i).get(j).getFlagCell());
                        gameBoard.get(i).get(j).getChildren().add(gameBoard.get(i).get(j).getMineCell());
                        gameBoard.get(i).get(j).setStyle("-fx-background-color: green");
                    }else if(gameBoard.get(i).get(j).getChildren().contains(gameBoard.get(i).get(j).getQuestionCell())){
                        gameBoard.get(i).get(j).getChildren().remove(gameBoard.get(i).get(j).getQuestionCell());
                        gameBoard.get(i).get(j).getChildren().add(gameBoard.get(i).get(j).getMineCell());
                        gameBoard.get(i).get(j).setStyle("-fx-background-color: yellow");
                    }
                }
            }
        }
        
        if(playerWon){
            assets.playWinSong();
            gameOverAlert.setContentText("Game Over! You Won!!!");
        }else{
            assets.playLoseSong();
            gameOverAlert.setContentText("Game Over! You lost...");
        }
        
        gameOverAlert.showAndWait();
    }
    
    private void checkNeighbors(Cell currentCell){
        if(currentCell.getChildren().contains(currentCell.getCoveredCell())){
            currentCell.getChildren().remove(currentCell.getCoveredCell());
            
            if(currentCell.getNumMinesNear() == 0){
                if(currentCell.getPosX() > 0){
                    checkNeighbors(gameBoard.get(currentCell.getPosX() - 1).get(currentCell.getPosY()));
                }
                if(currentCell.getPosX() < 19){
                    checkNeighbors(gameBoard.get(currentCell.getPosX() + 1).get(currentCell.getPosY()));
                }
                if(currentCell.getPosY() > 0){
                    checkNeighbors(gameBoard.get(currentCell.getPosX()).get(currentCell.getPosY() - 1));
                }
                if(currentCell.getPosY() < 19){
                    checkNeighbors(gameBoard.get(currentCell.getPosX()).get(currentCell.getPosY() + 1));
                }
            }
    
            if(currentCell.getNumMinesNear() > 0){
                if(currentCell.getNumMinesNear() == 1 && !currentCell.getChildren().contains(currentCell.getOneMine())){
                    currentCell.getChildren().add(currentCell.getOneMine());
                }else if(currentCell.getNumMinesNear() == 2 && !currentCell.getChildren().contains(currentCell.getTwoMine())){
                    currentCell.getChildren().add(currentCell.getTwoMine());
                }else if(currentCell.getNumMinesNear() == 3 && !currentCell.getChildren().contains(currentCell.getThreeMine())){
                    currentCell.getChildren().add(currentCell.getThreeMine());
                }else if(currentCell.getNumMinesNear() == 4 && !currentCell.getChildren().contains(currentCell.getFourMine())){
                    currentCell.getChildren().add(currentCell.getFourMine());
                }else if(currentCell.getNumMinesNear() == 5 && !currentCell.getChildren().contains(currentCell.getFiveMine())){
                    currentCell.getChildren().add(currentCell.getFiveMine());
                }else if(currentCell.getNumMinesNear() == 6 && !currentCell.getChildren().contains(currentCell.getSixMine())){
                    currentCell.getChildren().add(currentCell.getSixMine());
                }else if(currentCell.getNumMinesNear() == 7 && !currentCell.getChildren().contains(currentCell.getSevenMine())){
                    currentCell.getChildren().add(currentCell.getSevenMine());
                }else if(currentCell.getNumMinesNear() == 8 && !currentCell.getChildren().contains(currentCell.getEightMine())){
                    currentCell.getChildren().add(currentCell.getEightMine());
                }
            }
        }
    }
    
    private boolean checkIfWon(){
        int tempMines = 0;
        
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                if(gameBoard.get(i).get(j).getIsMine() && gameBoard.get(i).get(j).getChildren().contains(gameBoard.get(i).get(j).getFlagCell())){
                    tempMines++;
                }
            }
        }
        
        if(tempMines == 40){
            return true;
        }
        else {
            return false;
        }
    }
    
    private void handleMouseClick(Cell cell){
        cell.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY && !isGameOver){      //left click
                if(!isPlaying){
                    startGame();
                }
                
                assets.stopMineSound();
                assets.stopEmptySound();
        
                if(cell.getChildren().contains(cell.getCoveredCell()) && cell.getIsMine()){
                    cell.getChildren().remove(cell.getCoveredCell());
                    cell.getChildren().add(cell.getMineCell());
                    assets.playMineSound();
                    gameOver(false);
                }else if(cell.getChildren().contains(cell.getCoveredCell()) && !cell.getIsMine()){
                    assets.playEmptySound();
                    checkNeighbors(cell);
                }
            }else if(event.getButton() == MouseButton.SECONDARY && isPlaying && !isGameOver){      //right click
                assets.stopToggleSound();
        
                if(cell.getChildren().contains(cell.getCoveredCell())){
                    cell.getChildren().remove(cell.getCoveredCell());
                    cell.getChildren().add(cell.getFlagCell());
                    assets.playToggleSound();
                    numMines--;
                    
                    didPlayerWin = checkIfWon();
                    if(didPlayerWin){
                        gameOver(checkIfWon());
                    }
                }else if(cell.getChildren().contains(cell.getFlagCell())){
                    cell.getChildren().remove(cell.getFlagCell());
                    cell.getChildren().add(cell.getQuestionCell());
                    assets.playToggleSound();
                }else if(cell.getChildren().contains(cell.getQuestionCell())){
                    cell.getChildren().remove(cell.getQuestionCell());
                    cell.getChildren().add(cell.getCoveredCell());
                    assets.playToggleSound();
                    numMines++;
                }
            }
        });
    }
}

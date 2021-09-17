package cs2410.assn8.View;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Cell extends Pane{
    private boolean isMine;
    private ImageView coveredCell;
    private ImageView flagCell;
    private ImageView questionCell;
    private ImageView mineCell;
    private ImageView oneMine;
    private ImageView twoMine;
    private ImageView threeMine;
    private ImageView fourMine;
    private ImageView fiveMine;
    private ImageView sixMine;
    private ImageView sevenMine;
    private ImageView eightMine;
    private int numMinesNear;
    private int posX, posY;
    
    public Cell(int x, int y){
        super();        //calls the constructor for pane
        coveredCell = new ImageView("file:data/assets/Images/Cell.png");
        flagCell = new ImageView("file:data/assets/Images/FlaggedCell.png");
        questionCell = new ImageView("file:data/assets/Images/QuestionCell.png");
        mineCell = new ImageView("file:data/assets/Images/Mine.png");
        oneMine = new ImageView("file:data/assets/Images/one.png");
        twoMine = new ImageView("file:data/assets/Images/two.png");
        threeMine = new ImageView("file:data/assets/Images/three.png");
        fourMine = new ImageView("file:data/assets/Images/four.png");
        fiveMine = new ImageView("file:data/assets/Images/five.png");
        sixMine = new ImageView("file:data/assets/Images/six.png");
        sevenMine = new ImageView("file:data/assets/Images/seven.png");
        eightMine = new ImageView("file:data/assets/Images/eight.png");
        this.getChildren().add(coveredCell);
        this.setMaxSize(20, 20);
        isMine = false;
        posX = x;
        posY = y;
    }
    
    public void setIsMine(){
        isMine = true;
    }
    
    public boolean getIsMine(){
        return isMine;
    }
    
    public ImageView getCoveredCell(){ return coveredCell; }
    
    public ImageView getFlagCell(){ return flagCell; }
    
    public ImageView getMineCell(){ return mineCell; }
    
    public ImageView getQuestionCell(){ return questionCell; }
    
    public int getNumMinesNear(){ return numMinesNear; }
    
    public void setNumMinesNear(int numMinesNear){ this.numMinesNear = numMinesNear; }
    
    public int getPosX(){ return posX; }
    
    public int getPosY(){ return posY; }
    
    public ImageView getOneMine(){ return oneMine; }
    
    public ImageView getTwoMine(){ return twoMine; }
    
    public ImageView getThreeMine(){ return threeMine; }
    
    public ImageView getFourMine(){ return fourMine; }
    
    public ImageView getFiveMine(){ return fiveMine; }
    
    public ImageView getSixMine(){ return sixMine; }
    
    public ImageView getSevenMine(){ return sevenMine; }
    
    public ImageView getEightMine(){ return eightMine; }
}

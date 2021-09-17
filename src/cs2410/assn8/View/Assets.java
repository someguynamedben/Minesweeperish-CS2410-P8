package cs2410.assn8.View;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Assets{
    private static Assets ourInstance = new Assets();
    private Media winSong;
    private Media loseSong;
    private Media toggleSound;
    private Media emptySound;
    private Media mineSound;
    private MediaPlayer winPlayer;
    private MediaPlayer losePlayer;
    private MediaPlayer togglePlayer;
    private MediaPlayer emptyPlayer;
    private MediaPlayer minePlayer;
    
    public static Assets getInstance(){ return ourInstance; }
    
    private Assets(){
        winSong = new Media(new File("data/assets/Sounds/WinSong.mp3").toURI().toString());
        loseSong = new Media(new File("data/assets/Sounds/LoseSong.mp3").toURI().toString());
        toggleSound = new Media(new File("data/assets/Sounds/ToggleMark.mp3").toURI().toString());
        emptySound = new Media(new File("data/assets/Sounds/EmptyCell.mp3").toURI().toString());
        mineSound = new Media(new File("data/assets/Sounds/MineCell.mp3").toURI().toString());
        winPlayer = new MediaPlayer(winSong);
        losePlayer = new MediaPlayer(loseSong);
        togglePlayer = new MediaPlayer(toggleSound);
        emptyPlayer = new MediaPlayer(emptySound);
        minePlayer = new MediaPlayer(mineSound);
        togglePlayer.setVolume(0.25);
        minePlayer.setVolume(0.75);
    }
    
    public void playWinSong(){ winPlayer.play(); }
    
    public void playLoseSong(){ losePlayer.play(); }
    
    public void playToggleSound(){ togglePlayer.play(); }
    
    public void playEmptySound(){ emptyPlayer.play(); }
    
    public void playMineSound(){ minePlayer.play(); }
    
    public void stopWinSong(){ winPlayer.stop(); }
    
    public void stopLoseSong(){ losePlayer.stop(); }
    
    public void stopToggleSound(){ togglePlayer.stop(); }
    
    public void stopEmptySound(){ emptyPlayer.stop(); }
    
    public void stopMineSound(){ minePlayer.stop(); }
}

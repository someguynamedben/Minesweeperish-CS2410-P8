package cs2410.assn8.Controller;

import cs2410.assn8.View.Scoreboard;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer{
    private Timer timer = new Timer();
    private int timeCount = 0;
    private Scoreboard scoreboard = new Scoreboard();
    
    public void startTimer(){
        timer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                timeCount++;
                //scoreboard.setTimeText(timeCount);
            }
        }, 0, 1000);
    }
    
    public void stopTimer(){
        timer.cancel();
    }
    
    public int getTimeCount(){
        return timeCount;
    }
}

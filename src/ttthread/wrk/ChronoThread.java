/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttthread.wrk;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Waebela
 */
public class ChronoThread extends ThreadEmf {

    public static final String PATTERN = "mm:ss.SSS";

    public ChronoThread(String nom, Wrk refWrk) {
        super(nom);
        this.refWrk = refWrk;
        this.pattern = PATTERN;
        formateur = new SimpleDateFormat(pattern);
        started = false;
    }

    public void startUp() {
        timeStart = new Date();
        started = true;
    }
    
    public void stopIt(){
        timeStart = null;
        started = false;
    }
    
    public boolean pause(){
        pause = !pause;
        return pause;
    }

    public void reset() {
        timeStart = null;
        timeStamp = new Date(0);
        String temps = formateur.format(timeStamp);
        refWrk.recoitTemps(temps);
    }

    @Override
    public void executeAction() {
        if (timeStart != null) {
            timeEnd = new Date();
            long time = timeEnd.getTime() - timeStart.getTime();
            timeStamp = new Date(time);
            String temps = formateur.format(timeStamp);
            refWrk.recoitTemps(temps);
        }
    }
    
    @Override
    public void initialise(){
        started = true;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
        formateur = new SimpleDateFormat(pattern);
    }

    public boolean isStarted() {
        return started;
    }

    private Wrk refWrk;
    private Date timeStart;
    private Date timeEnd;
    private Date timeStamp;
    private String pattern;
    private SimpleDateFormat formateur;
    public boolean started;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttthread.wrk;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Waebela
 */
public abstract class ThreadEmf extends Thread {
    
    public static final int ATTENTE = 10; // 10 milisecondes

    public ThreadEmf(String nom) {
        super(nom); // setName(nom);
        running = true;
        pause = true;
        attente = ATTENTE;
    }

    /**
     * Cette méthode permet de simplifier la lecture lors d'attente avec sleep
     * @param mili : int le nombre de milisecondes à attendre
     */
    public void attend(int mili) {
        try {
            sleep(mili);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadEmf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        running = true;
        initialise();
        while (running) {
            if (!pause) {
                executeAction();
            }else{
                attend(10);
            }
        }
    }
    
    public abstract void initialise();

    public abstract void executeAction();

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public int getAttente() {
        return attente;
    }

    public void setAttente(int attente) {
        this.attente = attente;
    }

    protected volatile boolean running;
    protected volatile boolean pause;
    private int attente;
}

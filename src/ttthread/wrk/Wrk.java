/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttthread.wrk;

import java.util.logging.Level;
import java.util.logging.Logger;
import ttthread.ctrl.Ctrl;

/**
 * Classe worker
 * @author Waebela
 */
public class Wrk {

    public void setRefCtrl(Ctrl refCtrl) {
        this.refCtrl = refCtrl;
    }

    public boolean demarreThreads() {
        boolean ok = false;
        if (chrono == null) {
            chrono = new ChronoThread("Chrono", this);
            chrono.start();
            ok = true;
        }
        if (ok) {
            if (activity == null) {
                activity = new ActivityThread("Activity", this);
                activity.start();
                activity.startActivity();
                ok = true;
            }
        }
        return ok;
    }

    private boolean arreteChrono() {
        boolean ok = false;
        if (chrono != null) {
            chrono.setRunning(false);
            try {
                chrono.join();
                chrono = null;
                ok = true;
            } catch (InterruptedException ex) {
                ok = false;
            }
        }
        return ok;
    }

    private boolean arreteActivity() {
        boolean ok = false;
        if (activity != null) {
            activity.stopActivity();
            activity.setRunning(false);
            try {
                activity.join();
                activity = null;
                ok = true;
            } catch (InterruptedException ex) {
                ok = false;
            }
        }
        return ok;
    }

    public boolean arreteThreads() {
        boolean ok = false;
        if (arreteChrono()){
            ok = arreteActivity();
        }
        if (ok) {
            System.gc();
        }
        return ok;
    }

    public boolean startChrono() {
        boolean ok = false;
        if (chrono != null) {
            chrono.startUp();
            chrono.setPause(false);
            ok = chrono.isStarted();
        }
        return ok;
    }

    public int pauseChrono() {
        int codeRetour = -1;
        if (chrono != null) {
            chrono.pause();
            if (chrono.pause) {
                codeRetour = 1;
            } else {
                codeRetour = 0;
            }
        }
        return codeRetour;
    }

    public boolean stopChrono() {
        boolean ok = false;
        if (chrono != null) {
            chrono.stopIt();
            ok = !chrono.isStarted();
        }
        return ok;
    }

    public boolean resetChrono() {
        boolean ok = false;
        if (chrono != null) {
            chrono.reset();
            ok = true;
        }
        return ok;
    }

    public void recoitTemps(String temps) {
        refCtrl.recoitTemps(temps);
    }
    
    public void recoitActivityValeur(int valeur, String texte){
        refCtrl.recoitValeurActivity(valeur, texte);
    }

    private ChronoThread chrono;
    private ActivityThread activity;
    private Ctrl refCtrl;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttthread.ctrl;

import ttthread.ihm.Ihm;
import ttthread.wrk.Wrk;

/**
 *
 * @author Waebela
 */
public class Ctrl {

    public void startUp() {

    }

    public void demarreThread() {
        boolean ok = refWrk.demarreThreads();
        if (ok) {
            refIhm.afficheMsg("Les Threads sont démarrés");
        } else {
            refIhm.afficheErr("Problème lors du démarrage du Thread");
        }
    }

    public void arreteThread() {
         boolean ok = refWrk.arreteThreads();
        if (ok) {
            refIhm.afficheMsg("Les Threads sont arrêtés");
        } else {
            refIhm.afficheErr("Problème lors de l'arrêt du Thread");
        }
    }

    public void startChrono() {
        boolean ok = refWrk.startChrono();
        if (ok) {
            refIhm.afficheMsg("Start chrono");
        } else {
            refIhm.afficheErr("Start chrono pas effectué");
        }
    }

    public void pauseChrono() {
        int codeRetour = refWrk.pauseChrono();
        switch(codeRetour){
            case -1: refIhm.afficheErr("Pause non autorisée");break;
            case 0: refIhm.afficheMsg("Chrono pas en pause");break;
            case 1: refIhm.afficheMsg("Chrono en pause");break;
            default: refIhm.afficheErr("Code retour non valide");
        }
    }

    public void stopChrono() {
        boolean ok = refWrk.stopChrono();
        if (ok){
        refIhm.afficheMsg("Stop chrono");
        }else{
        refIhm.afficheErr("Stop chrono pas effectué");
        }
    }

    public void resetChrono() {
         boolean ok = refWrk.resetChrono();
        if (ok){
        refIhm.afficheMsg("Reset chrono");
        }else{
        refIhm.afficheErr("Reset chrono pas effectué");
        }
    }

    public void recoitTemps(String temps) {
        refIhm.afficheChrono(temps);
    }
    
    public void recoitValeurActivity(int valeur, String texte){
        refIhm.afficheActivity(valeur, texte);
    }

    public void setRefIhm(Ihm refIhm) {
        this.refIhm = refIhm;
    }

    public void setRefWrk(Wrk refWrk) {
        this.refWrk = refWrk;
    }

    private Ihm refIhm;
    private Wrk refWrk;
}

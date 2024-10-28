/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttthread;

import ttthread.wrk.Wrk;
import ttthread.ihm.Ihm;
import ttthread.ctrl.Ctrl;

/**
 * Classe principale
 * @author Waebela
 */
public class TTThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ctrl ctrl = new Ctrl();
        Ihm ihm = new Ihm();
        Wrk wrk = new Wrk();
        ctrl.setRefIhm(ihm);
        ctrl.setRefWrk(wrk);
        ihm.setRefCtrl(ctrl);
        wrk.setRefCtrl(ctrl);
        ctrl.startUp();
    }
    
}

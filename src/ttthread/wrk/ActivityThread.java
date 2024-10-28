/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttthread.wrk;

/**
 * Activity Thread
 * @author Waebela
 */
public class ActivityThread extends ThreadEmf{
    
    public static final int DELAIS = 30;
    public static final String TEXTE = "Thread(s) en ACTION";

    public ActivityThread(String nom, Wrk refWrk) {
        super(nom);
        this.refWrk = refWrk;
        valeur = 0;
    }

    public void startActivity(){
        valeur = 0;
        texte = TEXTE;
        pause = false;
    }
    
    public void stopActivity(){
        texte = "";       
        refWrk.recoitActivityValeur(valeur, texte);
        attend(DELAIS + 10);
         pause = true;
    }
    
    @Override
    public void initialise() {
        
    }

    @Override
    public void executeAction() {
       valeur++;
       valeur = valeur % 100;
       refWrk.recoitActivityValeur(valeur, texte);
       attend(DELAIS);
    }
    
    private Wrk refWrk;
    private int valeur;
    private String texte;
}


package utils;

import java.util.ArrayList;
import modelo.Esquimal;
import modelo.Foca;
import modelo.OsoPolar;
import modelo.Pez;
import modelo.SerVivo;

/**
 *
 * @author JORCH
 */
public class MenorMasaMuscular {

    private double masaMuscularOsoPolar;
    private double masaMuscularFoca;
    private double masaMuscularPez;
    private SerVivo osoPolar;
    private SerVivo foca;
    private SerVivo pez;
    
    public MenorMasaMuscular() {
        this.masaMuscularOsoPolar = 100.0;
        this.masaMuscularFoca = 100.0;
        this.masaMuscularPez = 100.0;
        this.osoPolar = null;
        this.foca = null;
        this.pez = null;
    }

    //SETTERS
    public void setMasaMuscularOsoPolar(double masaMuscularOsoPolar) {
        this.masaMuscularOsoPolar = masaMuscularOsoPolar;
    }

    public void setMasaMuscularFoca(double masaMuscularFoca) {
        this.masaMuscularFoca = masaMuscularFoca;
    }

    public void setMasaMuscularPez(double masaMuscularPez) {
        this.masaMuscularPez = masaMuscularPez;
    }

    public void setFoca(SerVivo foca) {
        this.foca = foca;
    }

    public void setOsoPolar(SerVivo osoPolar) {
        this.osoPolar = osoPolar;
    }

    public void setPez(SerVivo pez) {
        this.pez = pez;
    }
    
    //GETTERS
    public double getMasaMuscularOsoPolar() {
        return masaMuscularOsoPolar;
    }

    public double getMasaMuscularFoca() {
        return masaMuscularFoca;
    }

    public double getMasaMuscularPez() {
        return masaMuscularPez;
    }

    public SerVivo getFoca() {
        return foca;
    }

    public SerVivo getOsoPolar() {
        return osoPolar;
    }

    public SerVivo getPez() {
        return pez;
    }
    
    public static MenorMasaMuscular obtenerMenorMasaMuscularOsoPolar(ArrayList<OsoPolar> ososPolares) {
        MenorMasaMuscular mmm = new MenorMasaMuscular();
        for (OsoPolar osoPolar : ososPolares) {
            if (osoPolar.getMasaMuscular() < mmm.getMasaMuscularOsoPolar()) {
                mmm.setMasaMuscularOsoPolar(osoPolar.getMasaMuscular());
                mmm.setOsoPolar(osoPolar);
            }
        }
        return mmm;
    }
    public static MenorMasaMuscular obtenerMenorMasaMuscularFoca(ArrayList<Foca> focas) {
        MenorMasaMuscular mmm = new MenorMasaMuscular();
        for (Foca foca : focas) {
            if (foca.getMasaMuscular() < mmm.getMasaMuscularFoca()) {
                mmm.setMasaMuscularFoca(foca.getMasaMuscular());
                mmm.setFoca(foca);
            }
        }
        return mmm;
    }
    public static MenorMasaMuscular obtenerMenorMasaMuscularPez(ArrayList<Pez> peces) {
        MenorMasaMuscular mmm = new MenorMasaMuscular();
        for (Pez pez : peces) {
            if (pez.getMasaMuscular() < mmm.getMasaMuscularFoca()) {
                mmm.setMasaMuscularPez(pez.getMasaMuscular());
                mmm.setPez(pez);
            }
        }
        return mmm;
    }
}

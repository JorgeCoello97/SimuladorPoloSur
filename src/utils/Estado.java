package utils;

import java.io.Serializable;
import java.util.ArrayList;
import modelo.SerVivo;

/**
 *
 * @author JORCH
 */
public class Estado implements Serializable{
    private ArrayList<SerVivo> animales;
    private int diaActual = 0;
    private double temperaturaAgua;
    private int numKrillPlancton = 0;
    private boolean cazaFurtiva;
    private boolean tornado;
    private boolean volcan;
    private boolean tsunami;
    private boolean calentamiento;

    public Estado() {
        animales = new ArrayList<SerVivo>();
        
        this.diaActual = 0;
        this.numKrillPlancton = 0;
        this.temperaturaAgua = 0.0;
        
        this.cazaFurtiva  = false;
        this.tornado = false;
        this.volcan = false;
        this.tsunami = false;
        this.calentamiento = false;
    }
    
    //SETTERS

    public ArrayList<SerVivo> getAnimales() {
        return animales;
    }

    public void setAnimales(ArrayList<SerVivo> animales) {
        this.animales = animales;
    }

    public int getDiaActual() {
        return diaActual;
    }

    public void setDiaActual(int diaActual) {
        this.diaActual = diaActual;
    }

    public double getTemperaturaAgua() {
        return temperaturaAgua;
    }

    public void setTemperaturaAgua(double temperaturaAgua) {
        this.temperaturaAgua = temperaturaAgua;
    }

    public int getNumKrillPlancton() {
        return numKrillPlancton;
    }

    public void setNumKrillPlancton(int numKrillPlancton) {
        this.numKrillPlancton = numKrillPlancton;
    }

    public boolean isCazaFurtiva() {
        return cazaFurtiva;
    }

    public void setCazaFurtiva(boolean cazaFurtiva) {
        this.cazaFurtiva = cazaFurtiva;
    }

    public boolean isTornado() {
        return tornado;
    }

    public void setTornado(boolean tornado) {
        this.tornado = tornado;
    }

    public boolean isVolcan() {
        return volcan;
    }

    public void setVolcan(boolean volcan) {
        this.volcan = volcan;
    }

    public boolean isTsunami() {
        return tsunami;
    }

    public void setTsunami(boolean tsunami) {
        this.tsunami = tsunami;
    }

    public boolean isCalentamiento() {
        return calentamiento;
    }

    public void setCalentamiento(boolean calentamiento) {
        this.calentamiento = calentamiento;
    }
    
    
}


package utils;

import modelo.Esquimal;
import modelo.Foca;
import modelo.Morsa;
import modelo.OsoPolar;
import modelo.Pez;

/**
 *
 * @author JORCH
 */
public class Comida {
    private Esquimal esquimal;
    private OsoPolar osoPolar;
    private Morsa morsa;
    private Foca foca;
    private Pez pez;
    private int numeroOsosPolares = 0;
    private int numeroFocas = 0;
    private int numeroPeces = 0;
    private int numeroKrillPlancton = 0;

    public Comida() {
        this.numeroOsosPolares = 0;
        this.numeroFocas = 0;
        this.numeroPeces = 0;
        this.numeroKrillPlancton = 0;
    }

    public Comida(Esquimal esquimal, int numeroPeces, int numeroFocas) {
        this.esquimal = esquimal;
        this.numeroPeces = numeroPeces;
        this.numeroFocas = numeroFocas;
        
        this.numeroOsosPolares = 0;
        this.numeroKrillPlancton = 0;
    }
    
    public Comida(OsoPolar osoPolar, int numeroPeces, int numeroFocas) {
        this.osoPolar = osoPolar;
        this.numeroPeces = numeroPeces;
        this.numeroFocas = numeroFocas;
        
        this.numeroOsosPolares = 0;
        this.numeroKrillPlancton = 0;
    }
    
    public Comida(Morsa morsa, int numeroFocas, int numeroOsosPolares) {
        this.morsa = morsa;
        this.numeroFocas = numeroFocas;
        this.numeroOsosPolares = numeroOsosPolares;
        
        this.numeroPeces = 0;
        this.numeroKrillPlancton = 0;
    }
    
    public Comida(Foca foca, int numeroPeces) {
        this.foca = foca;
        this.numeroPeces = numeroPeces;
        
        this.numeroOsosPolares = 0;
        this.numeroFocas = 0;
        this.numeroKrillPlancton = 0;
    }
    
    public Comida(Pez pez, int numeroKrillPlancton) {
        this.pez = pez;
        this.numeroKrillPlancton = numeroKrillPlancton;
        
        this.numeroOsosPolares = 0;
        this.numeroFocas = 0;
        this.numeroPeces = 0;
    }
    
    //SETTERS

    public void setNumeroFocas(int numeroFocas) {
        this.numeroFocas = numeroFocas;
    }

    public void setNumeroPeces(int numeroPeces) {
        this.numeroPeces = numeroPeces;
    }

    public void setNumeroKrillPlancton(int numeroKrillPlancton) {
        this.numeroKrillPlancton = numeroKrillPlancton;
    }
    
    
    //GETTERS

    public int getNumeroOsosPolares() {
        return numeroOsosPolares;
    }


    public int getNumeroFocas() {
        return numeroFocas;
    }

    public int getNumeroPeces() {
        return numeroPeces;
    }

    public int getNumeroKrillPlancton() {
        return numeroKrillPlancton;
    }
    //REDUCIR UNIDADES
    public void reducirNumeroFocas() {
        if(numeroFocas>0){
            numeroFocas = numeroFocas - 1;
            
        }
    }

    public void reducirNumeroOsosPolares() {
        if(numeroOsosPolares>0){
            numeroOsosPolares = numeroOsosPolares - 1;
            
        }
    }

    public void reducirNumeroPeces() {
        if(numeroPeces>0){
            numeroPeces = numeroPeces - 1;
            
        }
    }
    public void reducirNumeroKrills() {
        if(numeroKrillPlancton>0){
            numeroKrillPlancton = numeroKrillPlancton - 1;
            
        }
    }
    public boolean todoVacio(){
        return (numeroFocas == 0 )&&(numeroKrillPlancton == 0 ) && (numeroOsosPolares == 0 )&& (numeroPeces == 0 );
    }
}

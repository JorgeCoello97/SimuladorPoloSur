package modelo;

import utils.Comida;
import utils.Utilidades;

/**
 *
 * @author JORCH
 */
public class Esquimal extends SerVivo{
    
    public Esquimal(int diaNacimiento) {
        super(diaNacimiento);
        this.masaMuscular = Utilidades.generarNumeroAleatorio(35, 48);
    }
    
    @Override
    public Comida comer() {
        int numPeces = 0;
        int numFocas = 0;
        int posibilidadPeces = Utilidades.generarNumeroAleatorioEntero(1, 3);
        switch (posibilidadPeces){
            case 1:
                numPeces = 2;
                break;
            case 2:
                numPeces = 3;
                break;
            case 3:
                numPeces = 4;
                break;
        }
        int posibilidadFocas = Utilidades.generarNumeroAleatorioEntero(1, 2);
        switch(posibilidadFocas){
            case 1:
                numFocas = 0;
                break;
            case 2:
                numFocas = 1;
                break;
        }
        
        
        return new Comida(this, numPeces, numFocas);
    }

    @Override
    public boolean reproducir() {
        float posibilidadReproducir = Utilidades.obtenerPorcentaje(32, 1000);
        double valorAleatorio = Utilidades.generarNumeroAleatorio(0, 100);
        
        return valorAleatorio <= posibilidadReproducir ;
    }

    @Override
    public boolean morir() {
       
        float posibilidadMorir = Utilidades.obtenerPorcentaje(24, 1000);
        double valorAleatorio = Utilidades.generarNumeroAleatorio(0, 100);
        return valorAleatorio <= posibilidadMorir;
    }

    @Override
    public String toString() {
        String esquimal = "";
        esquimal += "ESQUIMAL ->"+ super.toString()+"\n";
        return esquimal;
    }
    
}

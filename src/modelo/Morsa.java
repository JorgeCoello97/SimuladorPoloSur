package modelo;

import utils.Comida;
import utils.Utilidades;

/**
 *
 * @author JORCH
 */
public class Morsa extends SerVivo{
    
    
    public Morsa(int diaNacimiento) {
        super(diaNacimiento);
        this.masaMuscular = Utilidades.generarNumeroAleatorio(30, 42);
    }

    @Override
    public Comida comer() {
        int numFocas = Utilidades.generarNumeroAleatorioEntero(1, 2);
        int numCriaOsoPolar = Utilidades.generarNumeroAleatorioEntero(0, 1);
        
        return new Comida(this, numFocas, numCriaOsoPolar);
    }

    @Override
    public boolean reproducir() {
        float posibilidadReproducir = Utilidades.obtenerPorcentaje(98, 1000);
        double valorAleatorio = Utilidades.generarNumeroAleatorio(0, 100);
        
        return valorAleatorio <= posibilidadReproducir ;
    }

    @Override
    public boolean morir() {
       
        float posibilidadMorir = Utilidades.obtenerPorcentaje(95, 1000);
        double valorAleatorio = Utilidades.generarNumeroAleatorio(0, 100);
        return valorAleatorio <= posibilidadMorir;
    }
    
    @Override
    public String toString() {
        String morsa = "";
        morsa += "MORSA ->"+ super.toString()+"\n";
        return morsa;
    }
}

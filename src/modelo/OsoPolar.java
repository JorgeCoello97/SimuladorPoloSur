package modelo;

import utils.Comida;
import utils.Utilidades;

/**
 *
 * @author JORCH
 */
public class OsoPolar extends SerVivo{
    
    
    public OsoPolar(int diaNacimiento) {
        super(diaNacimiento);
        this.masaMuscular = Utilidades.generarNumeroAleatorio(40, 55);
    }

    @Override
    public Comida comer() {
        int numPeces = Utilidades.generarNumeroAleatorioEntero(10, 15);
        int numFocas = Utilidades.generarNumeroAleatorioEntero(1, 2);
        
        return new Comida(this, numPeces, numFocas);
    }

    @Override
    public boolean reproducir() {
        float posibilidadReproducir = Utilidades.obtenerPorcentaje(200, 1000);
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
        String osoPolar = "";
        osoPolar += "OSO POLAR ->"+ super.toString()+"\n";
        return osoPolar;
    }
}

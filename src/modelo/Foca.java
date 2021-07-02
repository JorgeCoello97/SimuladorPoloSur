
package modelo;

import utils.Comida;
import utils.Utilidades;

/**
 *
 * @author JORCH
 */
public class Foca extends SerVivo{
    
    
    public Foca(int diaNacimiento) {
        super(diaNacimiento);
        this.masaMuscular = Utilidades.generarNumeroAleatorio(25, 32);
    }

    @Override
    public Comida comer() {
        int numPeces = Utilidades.generarNumeroAleatorioEntero(15, 25);
        return new Comida(this, numPeces);
    }

    @Override
    public boolean reproducir() {
        float posibilidadReproducir = Utilidades.obtenerPorcentaje(200, 1000);
        double valorAleatorio = Utilidades.generarNumeroAleatorio(0, 100);
        
        return valorAleatorio <= posibilidadReproducir ;
    }

    @Override
    public boolean morir() {
       
        float posibilidadMorir = Utilidades.obtenerPorcentaje(90, 1000);
        double valorAleatorio = Utilidades.generarNumeroAleatorio(0, 100);
        return valorAleatorio <= posibilidadMorir;
    }
    @Override
    public String toString() {
        String foca = "";
        foca += "FOCA ->"+ super.toString()+"\n";
        return foca;
    }
}

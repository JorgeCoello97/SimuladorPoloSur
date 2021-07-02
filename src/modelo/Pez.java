package modelo;

import utils.Comida;
import utils.Utilidades;

/**
 *
 * @author JORCH
 */
public class Pez extends SerVivo{
    
    
    public Pez(int diaNacimiento) {
        super(diaNacimiento);
        this.masaMuscular = Utilidades.generarNumeroAleatorio(55, 70);
    }

    @Override
    public Comida comer() {
        int numKrillPlancton = 0;
        int posibilidadComer = Utilidades.generarNumeroAleatorioEntero(1, 2);
        switch (posibilidadComer){
            case 1:
                numKrillPlancton = 1000;
                break;
            case 2:
                numKrillPlancton = 2000;
                break;
        }
        return new Comida(this, numKrillPlancton);
    }

    @Override
    public boolean reproducir() {
        float posibilidadReproducir = Utilidades.obtenerPorcentaje(250, 1000);
        double valorAleatorio = Utilidades.generarNumeroAleatorio(0, 100);
        
        return valorAleatorio <= posibilidadReproducir ;
    }

    @Override
    public boolean morir() {
       
        float posibilidadMorir = Utilidades.obtenerPorcentaje(150, 1000);
        double valorAleatorio = Utilidades.generarNumeroAleatorio(0, 100);
        return valorAleatorio <= posibilidadMorir;
    }
}

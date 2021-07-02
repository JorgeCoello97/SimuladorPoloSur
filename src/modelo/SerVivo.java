package modelo;

import java.io.Serializable;
import java.text.DecimalFormat;
import utils.Comida;

/**
 *
 * @author JORCH
 */
public abstract class SerVivo implements Serializable{
    protected double masaMuscular;
    protected int diaNacimiento;

    public SerVivo(int diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }
    
    //METODOS ABSTRACTOS
    public abstract Comida comer();
    public abstract boolean reproducir();
    public abstract boolean morir();
    
    //SETTERS
    public void setMasaMuscular(double masaMuscular) {
        this.masaMuscular = masaMuscular;
    }

    public void setDiaNacimiento(int diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }
    
    
    //GETTERS
    public double getMasaMuscular() {
        return masaMuscular;
    }

    public double getDiaNacimiento() {
        return diaNacimiento;
    }

    @Override
    public String toString() {
        String animal = "";
        
        DecimalFormat formatoDecimal = new DecimalFormat("#.00");
        animal += "\tPorcentaje de masa muscular: "+formatoDecimal.format(this.masaMuscular);
        animal += "\tDia nacimiento: "+this.diaNacimiento;
        return animal;
    }
    
}


package modelo;

/**
 *
 * @author JORCH
 */
public class Modelo {
    private Polo polo;

    public Modelo() {
        this.polo = new Polo();
    }

    public void nuevoPolo(Polo polo) {
        this.polo = polo;
    }

    public Polo getPolo() {
        return polo;
    }
    
    //METODOS
    public int getDiaActual(){
        return polo.getDiaActual();
    }
    public double getTemperaturaActual(){
        return polo.getTemperaturaAgua();
    }
    
    //to string
    public String toStringEsquimales(){
        return polo.toStringEsquimales();
    }
    
    public String toStringOsosPolares(){
        return polo.toStringOsosPolares();
    }
    
    public String toStringMorsas(){
        return polo.toStringMorsas();
    }
    
    public String toStringFocas(){
        return polo.toStringFocas();
    }
    
    public String toStringPeces(){
        return polo.toStringPeces();
    }
}

package modelo;

/**
 *
 * @author JORCH
 */
public class Raya extends Pez{
    
    public Raya(int diaNacimiento) {
        super(diaNacimiento);
    }
    @Override
    public String toString() {
        String raya = "";
        raya += "RAYA ->"+ super.toString()+"\n";
        return raya;
    }
}

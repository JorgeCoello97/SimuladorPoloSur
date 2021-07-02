package modelo;

/**
 *
 * @author JORCH
 */
public class MerluzaNegra extends Pez{

    public MerluzaNegra(int diaNacimiento) {
        super(diaNacimiento);
    }

    @Override
    public String toString() {
        String merluza = "";
        merluza += "MERLUZA ->"+ super.toString()+"\n";
        return merluza;
    }
    
}

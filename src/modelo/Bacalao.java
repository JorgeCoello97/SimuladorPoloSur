package modelo;

/**
 *
 * @author JORCH
 */
public class Bacalao extends Pez{

    public Bacalao(int diaNacimiento) {
        super(diaNacimiento);
    }
    @Override
    public String toString() {
        String bacalao = "";
        bacalao += "BACALAO ->"+ super.toString()+"\n";
        return bacalao;
    }
}

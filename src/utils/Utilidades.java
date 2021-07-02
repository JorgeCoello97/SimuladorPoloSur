package utils;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JORCH
 */
public class Utilidades {

    public static double generarNumeroAleatorio(int rangoInicial, int rangoFinal) {
        double resultado = 0;

        rangoFinal = rangoFinal - rangoInicial;
        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");

            byte[] randomBytes = new byte[128];
            sr.nextBytes(randomBytes);
            resultado = sr.nextDouble() * rangoFinal + rangoInicial;

            resultado = Math.round(resultado * 10.0) / 10.0;

        } catch (NoSuchAlgorithmException | NoSuchProviderException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);

        }
        return resultado;
    }

    public static int generarNumeroAleatorioEntero(int rangoInicial, int rangoFinal) {
        int resultado = 0;

        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");

            byte[] randomBytes = new byte[128];
            sr.nextBytes(randomBytes);
            resultado = sr.nextInt(rangoFinal) + rangoInicial;

        } catch (NoSuchAlgorithmException | NoSuchProviderException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);

        }
        return resultado;
    }

   

    public static float obtenerPorcentaje(int cantidad, int cantidadTotal) {
        float resultado = 0;
        resultado = (cantidad * 100);
        resultado = resultado / cantidadTotal;
        return resultado;
    }

    
}

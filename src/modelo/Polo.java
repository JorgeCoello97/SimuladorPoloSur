package modelo;

import utils.Comida;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import utils.Estado;
import utils.MenorMasaMuscular;
import utils.Utilidades;

/**
 *
 * @author JORCH
 */
public class Polo {
    private  ArrayList<SerVivo> animales = new ArrayList<SerVivo>();
    private  ArrayList<Esquimal> esquimales = new ArrayList<Esquimal>();
    private  ArrayList<OsoPolar> ososPolares = new ArrayList<OsoPolar>();
    private  ArrayList<Morsa> morsas = new ArrayList<Morsa>();
    private  ArrayList<Foca> focas = new ArrayList<Foca>();
    private  ArrayList<Pez> peces = new ArrayList<Pez>();
    private int diaActual = 0;
    private double temperaturaAgua;
    private int numKrillPlancton = 0;
    private boolean cazaFurtiva;
    private boolean tornado;
    private boolean volcan;
    private boolean tsunami;
    private boolean calentamiento;
    public Polo() {
        diaActual = 1;
        temperaturaAgua = 4;
        cazaFurtiva = false;
        tornado = false;
        tsunami = false;
        volcan = false;
        calentamiento = false;
        int numEsquimales = Utilidades.generarNumeroAleatorioEntero(12, 14);
        int numOsos = Utilidades.generarNumeroAleatorioEntero(40, 55);
        int numMorsas = Utilidades.generarNumeroAleatorioEntero(22, 30);
        int numFocas = Utilidades.generarNumeroAleatorioEntero(350, 500);
        int numPeces = Utilidades.generarNumeroAleatorioEntero(7000, 8000);
        
        this.numKrillPlancton = Utilidades.generarNumeroAleatorioEntero(650000000,750000000); 
        
        for (int i = 0; i < numEsquimales; i++) {
            esquimales.add( new Esquimal(diaActual) );
        }
        for (int i = 0; i < numOsos; i++) {
            ososPolares.add( new OsoPolar(diaActual) );
        }
        for (int i = 0; i < numMorsas; i++) {
            morsas.add( new Morsa(diaActual) );
        }
        for (int i = 0; i < numFocas; i++) {
            focas.add( new Foca(diaActual) );
        }
        
        for (int i = 0; i < numPeces; i++) {
            int posibilidadTipoPez = Utilidades.generarNumeroAleatorioEntero(1, 3);
            switch(posibilidadTipoPez){
                case 1:
                    peces.add(new MerluzaNegra(diaActual));
                    break;
                case 2:
                    peces.add(new Raya(diaActual));
                    break;
                case 3:
                    peces.add(new Bacalao(diaActual));
                    break;
            }
        }
        
    }
    //CONTROLES DEL ECOSISTEMA
    public boolean avanzarDia(){
        boolean extincionEcosistema = false;
        int numAnimalesEcosistema = esquimales.size()+ososPolares.size();
        numAnimalesEcosistema += morsas.size()+focas.size()+peces.size();
        
        if (numAnimalesEcosistema>0) {
            diaActual++;
            cambiarTemperaturaAguaDiaria();
            
            /********************COMER***************************************/
            Iterator iterator;
            int i = 0;
            while(i<5){
                iterator = seleccionarIterator(i);
                while (iterator.hasNext()) {
                    SerVivo serVivo =(SerVivo) iterator.next();
                    boolean haComido = procesarComida(serVivo);
                    if (haComido == false) {
                        iterator.remove();
                    }
                }
                i++;
            }
                        
            
            /********************REPRODUCIR***************************************/
            ArrayList<SerVivo> animalesNuevos  = new ArrayList<SerVivo>();
            i = 0;
            while(i<5){
                iterator = seleccionarIterator(i);
                while (iterator.hasNext()) {
                    SerVivo serVivo = (SerVivo) iterator.next();
                    reproduccion(serVivo,animalesNuevos);
                }
                i++;
            }
            anyadirNuevoAnimales( animalesNuevos);
            
            crecimientoKrillPlancton();
            

            /********************MORIR***************************************/
            i = 0;
            while(i<5){
                iterator = seleccionarIterator(i);
                while (iterator.hasNext()) {
                    SerVivo serVivo = (SerVivo) iterator.next();
                    if (serVivo.morir()) {
                        iterator.remove();
                    }
                }
                i++;
            }
            
            
            /********************SUCESOS EN EL ECOSISTEMA***************************************/
            if(cazaFurtiva){
                realizarSucesoCazaFurtiva();
            }
            if(tornado){
                realizarSucesoTornado();
            }
            if(tsunami){
                realizarSucesoTsunami();
            }
            if(volcan){
                realizarSucesoVolcan();
            }
            numAnimalesEcosistema = esquimales.size()+ososPolares.size();
            numAnimalesEcosistema += morsas.size()+focas.size()+peces.size();
            extincionEcosistema = (numAnimalesEcosistema>0) ? false:true;
        }
        return extincionEcosistema;
    }
    
    //AUXILIARES
    private boolean procesarComida(SerVivo animal){
        boolean haComido = false;
        Comida comida;
        MenorMasaMuscular mmm;
        
        comida = animal.comer();
        
        ArrayList<SerVivo> animalesYaComidos = new ArrayList<>();
        int  i = 0;
        int numeroAuxiliar;
        numeroAuxiliar = comida.getNumeroPeces();
        while( i < numeroAuxiliar && !peces.isEmpty()){
            mmm = MenorMasaMuscular.obtenerMenorMasaMuscularPez(peces);
            if (mmm.getPez() != null) {
                animalesYaComidos.add(mmm.getPez());
                comida.reducirNumeroPeces();
            }
            i++;
        }
        
        i=0;
        numeroAuxiliar = comida.getNumeroFocas();
        while( i < numeroAuxiliar && !focas.isEmpty()){
            mmm = MenorMasaMuscular.obtenerMenorMasaMuscularFoca(focas);
            if(mmm.getFoca()!=null){
                animalesYaComidos.add(mmm.getFoca());
                comida.reducirNumeroFocas();
            }
            i++;
        }
        i=0;
        numeroAuxiliar = comida.getNumeroOsosPolares();
        while( i < numeroAuxiliar&& !ososPolares.isEmpty()){
            mmm = MenorMasaMuscular.obtenerMenorMasaMuscularOsoPolar(ososPolares);
            if (mmm.getOsoPolar() != null) {
                animalesYaComidos.add(mmm.getOsoPolar());
                comida.reducirNumeroOsosPolares();
            }
            i++;
        }
        
        i = 0;
        numeroAuxiliar = comida.getNumeroKrillPlancton();
        while( i < numeroAuxiliar && numKrillPlancton > 0){
            comida.reducirNumeroKrills();
            numKrillPlancton--;
            i++;
        }
        
        //ELIMINAR DE LOS  CONJUNTOS LOS ANIMALES YA COMIDOS
        for (SerVivo animalComido : animalesYaComidos) {
            if (animalComido instanceof Pez){
                Pez pez = (Pez) animalComido;
                peces.remove(pez);
            }
            else if(animalComido instanceof Foca){
                Foca foca = (Foca) animalComido;
                focas.remove(foca);
            }
            else if(animalComido instanceof OsoPolar){
                OsoPolar osoPolar = (OsoPolar) animalComido;
                ososPolares.remove(osoPolar);
            }
        }
        
        if(comida.todoVacio()){
            haComido = true;
        }
        
        return haComido;
    }
    private void reproduccion(SerVivo animal, ArrayList<SerVivo> animalesNuevos){

        if(animal.reproducir()){
            if (animal instanceof Esquimal){
                Esquimal nuevoEsquimal = new Esquimal(diaActual);
                nuevoEsquimal.setMasaMuscular( animal.getMasaMuscular() );
                animalesNuevos.add(nuevoEsquimal);
            }
            else if(animal instanceof OsoPolar){
                OsoPolar nuevoOsoPolar = new OsoPolar(diaActual);
                nuevoOsoPolar.setMasaMuscular( animal.getMasaMuscular() );
                animalesNuevos.add( nuevoOsoPolar );
            }
            else if(animal instanceof Morsa){
                Morsa nuevaMorsa = new Morsa(diaActual);
                nuevaMorsa.setMasaMuscular( animal.getMasaMuscular() );
                animalesNuevos.add( nuevaMorsa );
            }
            else if(animal instanceof Foca){
                Foca nuevaFoca = new Foca(diaActual);
                nuevaFoca.setMasaMuscular( animal.getMasaMuscular() );
                animalesNuevos.add( nuevaFoca );
            }
            else if(animal instanceof MerluzaNegra){
                MerluzaNegra nuevaMerluzaNegra = new MerluzaNegra(diaActual);
                nuevaMerluzaNegra.setMasaMuscular( animal.getMasaMuscular() );
                animalesNuevos.add( nuevaMerluzaNegra );
            }
            else if(animal instanceof Bacalao){
                Bacalao nuevoBacalao = new Bacalao(diaActual);
                nuevoBacalao.setMasaMuscular( animal.getMasaMuscular() );
                animalesNuevos.add( nuevoBacalao );
            }
            else if(animal instanceof Raya){
                Raya nuevaRaya = new Raya(diaActual);
                nuevaRaya.setMasaMuscular( animal.getMasaMuscular() );
                animalesNuevos.add( nuevaRaya );
            }
        }
    }
    private void cambiarTemperaturaAguaDiaria(){
        int probabilidad = Utilidades.generarNumeroAleatorioEntero(1, 100);
            
        if(temperaturaAgua>=5){ //5 O MAS GRADOS
            if ( probabilidad <= 45) {
                temperaturaAgua += 0.2;
            }
            else {
                temperaturaAgua -= 0.2;
            }
        }
        else if(temperaturaAgua < 5 && temperaturaAgua > 3){ // 4 GRADOS
            if ( probabilidad<=30) {
                temperaturaAgua -= 0.2;
            }
            else if(probabilidad > 30 && probabilidad < 95){
                temperaturaAgua += 0.2;
            }
        }else{ // 3 O MENOS GRADOS
            if ( probabilidad <= 45) {
                temperaturaAgua -= 0.2;
            }
            else {
                temperaturaAgua += 0.2;
            }
        }
    }
    private void crecimientoKrillPlancton() {
        if( temperaturaAgua < 5.5 && temperaturaAgua>=5 ){
            numKrillPlancton += 12000;
        }else if( temperaturaAgua < 5 && temperaturaAgua >= 4 ){
            numKrillPlancton += 22000;
        }else if( temperaturaAgua < 4 && temperaturaAgua >= 3 ){
            numKrillPlancton += 18000;
        }
    }
    
    //METODOS
    public void calentamientoGlobal(){
        calentamiento = true;
        temperaturaAgua += 2.0;
    }
    
    //SETTERS
    
    public void provocarCazaFurtiva(boolean cazaFurtiva) {
        this.cazaFurtiva = cazaFurtiva;
    }

    public void provocarVolcan(boolean volcan) {
        this.volcan = volcan;
    }

    public void provocarTornado(boolean tornado) {
        this.tornado = tornado;
    }

    public void provocarTsunami(boolean tsunami) {
        this.tsunami = tsunami;
    }
    
    public void desactivarSucesos(){
        this.cazaFurtiva = false;
        this.volcan = false;
        this.tornado = false;
        this.tsunami = false;
    }
    
    public void setNumKrillPlancton(int numKrillPlancton) {
        this.numKrillPlancton = numKrillPlancton;
    }
    public void setDiaActual(int diaActual) {
        this.diaActual = diaActual;
    }
    
    //GETTERS
    public double getTemperaturaAgua() {
        return temperaturaAgua;
    }
    
    public int getDiaActual() {
        return diaActual;
    }

    public int getNumEsquimales() {
        return esquimales.size();
    }

    public int getNumOsosPolares() {
        return ososPolares.size();
    }

    public int getNumMorsas() {
        return morsas.size();
    }

    public int getNumFocas() {
        return focas.size();
    }

    public int getNumPeces() {
        return peces.size();
    }
    
    
    public int getNumKrillPlancton() {
        return numKrillPlancton;
    }
    
    public ArrayList<SerVivo> getAnimalesEcosistema(){
        animales = new ArrayList<>();
        animales.addAll(esquimales);
        animales.addAll(ososPolares);
        animales.addAll(morsas);
        animales.addAll(focas);
        animales.addAll(peces);
        return animales;
    }
    public Estado obtenerEstadoActual(){
        Estado estado = new Estado();
        estado.setAnimales( this.getAnimalesEcosistema() );
        estado.setCalentamiento(calentamiento);
        estado.setCazaFurtiva(cazaFurtiva);
        estado.setDiaActual(diaActual);
        estado.setNumKrillPlancton(numKrillPlancton);
        estado.setTemperaturaAgua(temperaturaAgua);
        estado.setTornado(tornado);
        estado.setTsunami(tsunami);
        estado.setVolcan(volcan);
        return estado;
    }
    public void cargarEstado(Estado estado){
        ArrayList<SerVivo> animalesEcosistema = estado.getAnimales();
        ListIterator<SerVivo> iterator = animalesEcosistema.listIterator();
        
        esquimales.clear();
        ososPolares.clear();
        morsas.clear();
        focas.clear();
        peces.clear();
        
        while (iterator.hasNext()) {
            SerVivo animal = iterator.next();
            if (animal instanceof Esquimal){
                Esquimal esquimal = (Esquimal) animal;
                esquimales.add(esquimal);
            }
            else if(animal instanceof OsoPolar){
                OsoPolar osoPolar = (OsoPolar) animal;
                ososPolares.add(osoPolar);
            }
            else if(animal instanceof Morsa){
                Morsa morsa = (Morsa) animal;
                morsas.add(morsa);
            }
            else if(animal instanceof Foca){
                Foca foca = (Foca) animal;
                focas.add(foca);
            }
            else if(animal instanceof Pez){
                Pez pez = (Pez) animal;
                peces.add(pez);
            }
        }
        this.diaActual = estado.getDiaActual();
        this.temperaturaAgua = estado.getTemperaturaAgua();
        this.numKrillPlancton = estado.getNumKrillPlancton();
        this.calentamiento = estado.isCalentamiento();
        this.cazaFurtiva = estado.isCazaFurtiva();
        this.tornado = estado.isTornado();
        this.tsunami = estado.isTsunami();
        this.volcan = estado.isVolcan();
    }
    public boolean isCazaFurtiva() {
        return cazaFurtiva;
    }

    public boolean isTornado() {
        return tornado;
    }

    public boolean isVolcan() {
        return volcan;
    }

    public boolean isTsunami() {
        return tsunami;
    }

    public boolean isCalentamiento() {
        return calentamiento;
    }
    
    
    
    public String toStringEsquimales(){
        String salida = "";
        
        for (Esquimal esquimal : esquimales) {
            salida += esquimal.toString();
        }
        
        return salida;
    }
    public String toStringOsosPolares(){
        String salida = "";
        
        for (OsoPolar osoPolar : ososPolares) {
            salida += osoPolar.toString();
        }
        
        return salida;
    }
    public String toStringMorsas(){
        String salida = "";
        
        for (Morsa morsa : morsas) {
            salida += morsa.toString();
        }
        
        return salida;
    }
    public String toStringFocas(){
        String salida = "";
        
        for (Foca foca : focas) {
            salida += foca.toString();
        }
        
        return salida;
    }
    
    public String toStringPeces(){
        String salida = "";
        
        for (Pez pez : peces) {
            salida += pez.toString();
        }
        
        return salida;
    }
    
    //AUXILIARES
    private Iterator seleccionarIterator(int indice){
        Iterator iterator;
        
        iterator = esquimales.iterator();
        switch(indice){
            case 0: //ESQUIMALES
                iterator = esquimales.iterator();
                break;
            case 1: //OSOS POLARES
                iterator = ososPolares.iterator();
                break;
            case 2: //MORSAS
                iterator = morsas.iterator();
                break;
            case 3: //FOCAS
                iterator = focas.iterator();
                break;
            case 4: //PECES
                iterator = peces.iterator();
                break;
        }
        return iterator;
    }
    private void anyadirNuevoAnimales(ArrayList<SerVivo> animalesNuevos) {
        for (SerVivo animalNuevo : animalesNuevos) {
            if (animalNuevo instanceof Esquimal){
                Esquimal esquimalNuevo = (Esquimal) animalNuevo;
                esquimales.add(esquimalNuevo);
            }
            else if(animalNuevo instanceof OsoPolar){
                OsoPolar osoPolarNuevo = (OsoPolar) animalNuevo;
                ososPolares.add(osoPolarNuevo);
            }
            else if(animalNuevo instanceof Morsa){
                Morsa morsaNueva = (Morsa) animalNuevo;
                morsas.add(morsaNueva);
            }
            else if(animalNuevo instanceof Foca){
                Foca focaNueva = (Foca) animalNuevo;
                focas.add(focaNueva);
            }
            else if(animalNuevo instanceof Pez){
                Pez pezNuevo = (Pez) animalNuevo;
                peces.add(pezNuevo);
            }
        }
    }

    private void realizarSucesoCazaFurtiva() {
        
        Iterator iterator = ososPolares.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            int probabilidad = Utilidades.generarNumeroAleatorioEntero(1, 100);    
            if (probabilidad <=15) {
                iterator.remove();
            }
        }
        iterator = morsas.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            int probabilidad = Utilidades.generarNumeroAleatorioEntero(1, 100);    
            if (probabilidad <=20) {
                iterator.remove();
            }
        }
    }

    private void realizarSucesoTornado() {
        Iterator iterator = focas.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            int probabilidad = Utilidades.generarNumeroAleatorioEntero(1, 100);    
            if (probabilidad <=5) {
                iterator.remove();
            }
        }
    }

    private void realizarSucesoTsunami() {
        Iterator iterator = peces.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            int probabilidad = Utilidades.generarNumeroAleatorioEntero(1, 100);    
            if (probabilidad <=7) {
                iterator.remove();
            }
        }
    }

    private void realizarSucesoVolcan() {
        Iterator iterator = esquimales.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            int probabilidad = Utilidades.generarNumeroAleatorioEntero(1, 100);    
            if (probabilidad <=15) {
                iterator.remove();
            }
        }
    }
}
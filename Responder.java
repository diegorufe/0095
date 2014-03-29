import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael KÃ¶lling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    Random aleatorio;
    private ArrayList<String> respuestas;
    private HashMap<HashSet, String>respuestas2;
    private  ArrayList<String> copiaRespuestas;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio = new Random();
        respuestas = new ArrayList<String>();
        respuestas2= new HashMap<HashSet,String>();
        HashSet cpu = new HashSet();
        copiaRespuestas = new ArrayList<String>();
        cpu.add("CPU");
        cpu.add("INTEL");
        HashSet ram = new HashSet();
        ram.add("RAM");
        ram.add("KINGSTOM");
        HashSet bios = new HashSet();
        bios.add("BIOS");
        bios.add("ASUS");
        bios.add("POWER");
        HashSet hdd = new HashSet();
        hdd.add("HDD");
        hdd.add("SAMSUNG");
        //respuestas2 añadir key y values
        respuestas2.put(cpu,"¿Cual es su tipo de CPU?");
        respuestas2.put(ram,"¿Que velocidad tiene su memoria RAM?");
        respuestas2.put(bios,"¿Ha reiniciado a los valores de fabrica de la BIOS?");
        respuestas2.put(hdd,"¿De cuanto espacio consta su HDD?");
        String[] respuestasDescritas = new String[5];
        respuestasDescritas[0] = "Describa su problema"; 
        respuestasDescritas[1] = "¿Esta seguro/a de que ese es su problema?";
        respuestasDescritas[2] = "Describame el problema de nuevo, por favor";
        respuestasDescritas[3]= "Interesante, describa mas detalles de su problema";
        respuestasDescritas[4] = "¿Esta seguro/a de que de verdad tiene un problema?";
        for(int i =0;i <respuestasDescritas.length;i++){
            respuestas.add(respuestasDescritas[i]);
        }
        copiaRespuestas = (ArrayList) respuestas.clone();
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> palabras)
    {   
        String respuesta = null;
        if(respuestas2.containsKey(palabras)){
                respuesta= respuestas2.get(palabras);
        }
        else if(copiaRespuestas.size() >= 1){
            int numeroAleatorio= aleatorio.nextInt(copiaRespuestas.size());
            respuesta= copiaRespuestas.get(numeroAleatorio);
            copiaRespuestas.remove(numeroAleatorio);
        }else{
            respuesta = "no he entendido la frase";
        }
        return respuesta;
    }
}
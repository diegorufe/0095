import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    Random aleatorio;
    private ArrayList<String> respuestas;
    private HashMap<String, String>respuestas2;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio = new Random();
        respuestas = new ArrayList<String>();
        respuestas2= new HashMap<String,String>();
        respuestas2.put("CPU","�Cual es su tipo de CPU?");
        respuestas2.put("RAM","�Que velocidad tiene su memoria RAM?");
        respuestas2.put("BIOS","�Ha reiniciado a los valores de fabrica de la BIOS?");
        respuestas2.put("HDD","�De cuanto espacio consta su HDD?");
        String[] respuestasDescritas = new String[5];
        respuestasDescritas[0] = "Describa su problema"; 
        respuestasDescritas[1] = "�Esta seguro/a de que ese es su problema?";
        respuestasDescritas[2] = "Describame el problema de nuevo, por favor";
        respuestasDescritas[3]= "Interesante, describa mas detalles de su problema";
        respuestasDescritas[4] = "�Esta seguro/a de que de verdad tiene un problema?";
        for(int i =0;i <respuestasDescritas.length;i++){
            respuestas.add(respuestasDescritas[i]);
        }
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(String palabra)
    {   
        String respuesta = null;
        /*if(palabra.contains("CPU")){
            respuesta ="�Cual es su tipo de CPU?";
        }else if(palabra.contains("RAM")){ 
            respuesta = "�Que velocidad tiene su memoria RAM?";
        }else if(palabra.contains("BIOS")){
            respuesta = "�Ha reiniciado a los valores de fabrica de la BIOS?";
        }else if(palabra.contains("HDD")){
            respuesta = "�De cuanto espacio consta su HDD?";
        }else{
            respuesta= respuestas.get(aleatorio.nextInt(respuestas.size()));
        }*/
        if(respuestas2.containsKey(palabra.toUpperCase())){
             respuesta= respuestas2.get(palabra.toUpperCase());
        }else{
             respuesta= respuestas.get(aleatorio.nextInt(respuestas.size()));
        }
        return respuesta;
    }
}

package Init;

//<editor-fold defaultstate="collapsed" desc="LIBRERIAS Y DEPENDENCIAS IMPORTADAS">
import Objetos.Dato;
import Hilos.*;
//</editor-fold>

public class AppHilo {

    public static void main(String[] args) {
    
       Dato d = new Dato(); // CREACION DE UN NUEVO OBJETO DE TIPO DATO(NUEVA ESTANCIA DE CLASE) PARA SINCRONISAR LA CLASE CON DOS HILOS
       // CREACION DE DOS ESTANCIAS DE LA CLASE 'HILORUNNABLE' QUE IMPLEMENTAN LA INTERFAZ RUNNABLE(HILOS/DEMONS)  
       HiloRunnable hr=new HiloRunnable(d,1,0,25); // RECIBE 4 PARAMETROS Y ES INICIALISADA POR EL CONSTRUCTOR PRINCIPAL     
       HiloRunnable hr2=new HiloRunnable(d,2,0,25);  // RECIBE SOLO 2 PARAMETROS Y ES INICIALISADA POR EL CONSTRUCTOR SECUNDARIO
       
       //CREACION DE DOS ESTANCIAS DE LA CLASE 'HILOTHREAD' QUE HEREDA LA CLASE THREAD PARA REALISAR TAREAS DE UN HILO
       Thread hilo3 = new HiloThread(d,3,0,25); // NUEVO HILO CREADO CON POLIMORFISMO RECIBE 4 PARAMETROS INICIALISADO CON CONSTRUCTOR PRIMARIO
       Thread hilo4= new HiloThread(d,4,0,25); // NUEVO HILO CREADO CON POLIMORFISMO RECIBE 2 PARAMETROS INICIALISADO CON CONSTRUCTOR SECUNDARIO
       
       // PARAMETROS {
       // d : CLASE DATO MONITORA
       // 1 : NUMERO DE HILO 
       // 0 : POCICION INICIAL DE ARREGLO ,SI ES OMITIDO SE ASIGNA COMO LA POCICION 0                                  
       // 25 : POCICION FINAL DE ARREGLO ,SI ES OMITIDO SE ASIGNA COMO LA POCICION FINAL 100
       Thread hilo1= new Thread(hr); // ESTANCIA DE UN NUEVO HILO PARA DESPLEGAR UN SUBPROCESO 1            
       Thread hilo2= new Thread(hr2); // ESTANCIA DE UN NUEVO HILO PARA DESPLEGAR EL SUBPROCESO 2
       
       System.out.println("ARREGLO ORIGINAL :");
       for(int i=0;i<100;i++){
        System.out.println("--->INDICE ["+i+"] :"+d.getArreglo()[i]);
       }
       
       hilo2.start(); // DESPLIEGE DE PROCESO 2 (DECREMENTO)
       hilo4.start(); // DESPLIEGE DE PROCESO 4  (DIVISION)
       hilo1.start(); // DESPLIEGE DE PROCESO 1 (INCREMENTO)      
       hilo3.start(); // DESPLIEGE DE PROCESO 3 (MULTIPLICACION) 
       
           
                                                           
    }
}
//package pcalc;

import java.util.*;
import java.util.List;
import java.util.Arrays;

public class Pcalc{

  public static Polinomio r = new Polinomio();
  public static Polinomio p1 = new Polinomio();
  public static Polinomio p2 = new Polinomio();

  public static void main(String[] args){

    p1.setCoefExpo(args[1]);
    if(args.length>=3){
      p2.setCoefExpo(args[2]);
    }
    comprobarOperaciones(args[0]);
  }

  //Comprueba que sean operacoinea validas
  public static void comprobarOperaciones(String operaciones){

    char caracter = Character.toLowerCase(operaciones.charAt(1));

    switch (caracter) {
      case 's':
        System.out.println("Voy a sumar");
        sumarRestar(p1, p2,'s');
        System.out.println(r.escribirPolinomio());
        break;
      case 'r':
        System.out.println("Voy a restar");
        sumarRestar(p1, p2,'r');
        System.out.println(r.escribirPolinomio());
        break;
      case 'm':
        System.out.println("Multiplicar\nFuncion sin programar");
        break;
      case 'd':
        System.out.println("Derivar");
        derivar(p1);
        System.out.println(r.escribirPolinomio());
        break;
      case 'i':
        System.out.println("Integrar\nFuncion sin programar");
        break;
      case 'h':
        System.out.println("Ayuda\nOpciones aceptadas\n\t-s\tsuma\n\t-r\tresta\n\t-m\tmultiplicacion\n\t-d\tderivada\n\t-i\tintegral\n\t-h --help\tmuestra este mensaje de nuevo");
        System.exit(0);
        break;
      case '-':
        System.out.println("Ayuda\nOpciones aceptadas\n\t-s\tsuma\n\t-r\tresta\n\t-m\tmultiplicacion\n\t-d\tderivada\n\t-i\tintegral\n\t-h --help\tmuestra este mensaje de nuevo");
        System.exit(0);
        break;
      default :
        mensajeError();
        System.out.println("Opciones aceptadas\n\t-s\tsuma\n\t-r\tresta\n\t-m\tmultiplicacion\n\t-d\tderivada\n\t-i\tintegral\n\t-h --help\tmuestra este mensaje de nuevo");
        System.exit(0);
        break;
    }
  }

  public static void sumarRestar(Polinomio poli1, Polinomio poli2, char operacion){

    List<Integer> coeficientes =  new ArrayList<Integer>();
    List<Integer> exponentes =  new ArrayList<Integer>();

    int i=0;
    while(poli1.getExponentes().size()!=0){
      System.out.println("Entre al while");
      for(int j=0;j<poli2.getExponentes().size();j++){
        if (poli1.getExponentes().get(1)==poli2.getExponentes().get(j)){
          exponentes.add(poli1.getExponentes().get(1));
          coeficientes.add(poli1.getCoeficientes().get(1)+poli2.getCoeficientes().get(j));
        }
      }
      poli1.delExponentes(1);
      poli1.delCoeficientes(1);
    }
    r.setExponentes(exponentes);
    r.setCoeficientes(coeficientes);

  }

  public static void derivar(Polinomio poli){

    List<Integer> coeficientes =  new ArrayList<Integer>();
    List<Integer> exponentes =  new ArrayList<Integer>();

    coeficientes.addAll(poli.getCoeficientes());
    exponentes.addAll(poli.getExponentes());

    for(int i=0; i<coeficientes.size();i++){
      if(exponentes.get(i) != 0){
        coeficientes.set(i,(coeficientes.get(i)*exponentes.get(i)));
        exponentes.set(i,(exponentes.get(i)-1));
      }else{
        coeficientes.set(i,0);
        exponentes.set(i,0);
      }
    }
    //Genera un "java.lang.IndexOutOfBoundsException" que no supe decifrar por que
    r.setCoeficientes(coeficientes);
    r.setExponentes(exponentes);

  }

  public static void mostrarListaCoeficientes(List<Integer> lista){
    System.out.println(lista);
  }

  //Imprime mensaje de error
  public static void mensajeError(){
    System.out.println("Error");
  }
}

class Polinomio{

   private List <Integer> exponentes = new ArrayList<Integer>();
   private List <Integer> coeficientes = new ArrayList<Integer>();

   public void Polinomio(){
   }

   //Esta funcion leera el polinomi y separará los exponentes y coeficiente
   public void setCoefExpo(String polinomio){

      String coeficiente = "";
      int intAux;
      List <Integer> listaAux = new ArrayList<Integer>();

      //Recorrer el polinomio agrupando en la lista en fomrato [coef, exp, coef, exp, ...]
      for(int i=0;i<polinomio.length();i++){
      //si el caracter es un numero lo agrega a una cadena hasta que no sea numero
         if(Character.isDigit(polinomio.charAt(i))){
           coeficiente += polinomio.charAt(i);
         }else{
           //convierte la cadena en un entero y la guarda en la lista
           if(coeficiente!=""){
             intAux = Integer.parseInt(coeficiente);
             listaAux.add(intAux);
             //Vacia la cadena para volver a empezar
             coeficiente = "";
           }
         }
      }
      //Lo mismo que el if anterior pero necesario para el ultimo exponente
      intAux = Integer.parseInt(coeficiente);
      listaAux.add(intAux);

      for(int i=0;i<listaAux.size();i+=2){
        coeficientes.add(listaAux.get(i));
        exponentes.add(listaAux.get(i+1));
      }
   }

   public List<Integer> getCoeficientes(){
      return coeficientes;
   }

   public List<Integer> getExponentes(){
      return exponentes;
   }

   public void setExponentes(List<Integer> exps){
      exponentes.addAll(exps);
   }

   public void setCoeficientes(List<Integer> coefs){
      coeficientes.addAll(coefs);
   }

   public void delExponentes(int i){
     exponentes.remove(i);
   }

   public void delCoeficientes(int i){
     coeficientes.remove(i);
   }

   public String escribirPolinomio(){
     String poli = "";

     for(int i=0;i<coeficientes.size();i++){
       poli += coeficientes.get(i);
       poli += "x^";
       poli += exponentes.get(i);
       poli += "+";
     }
     poli = poli.substring(0,poli.length()-1);
     return poli;
   }
}



/*To-Do
 *coeficientes y exponentes negativos
 *integrar y  Multiplicar los Polinomios
 */

//Objeto Polinomio

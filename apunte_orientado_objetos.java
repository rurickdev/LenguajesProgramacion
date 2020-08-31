/*
*Programa del tema de Orientacion a objetos
*Maqueo Poisot Rurick
*para la materia de Lenguajes de programacion
*/

public class OO{
  public static void main(String[] args) {

    String cadenaAux = "objeto construdo con el ";

    SuperClase superC =  new SuperClase();
    SuperClase superC2 =  new SuperClase("Contructor de la SuperClase es un objeto de super clase");
    SubClase subC2 = new SubClase();
    SubClase subC = new SubClase("Contructor de la SuperClase es un objeto de Sub clase");

    //Ejemplo encadeamiento de constructores
    System.out.println(cadenaAux+subC.getAtributoCadena());
    System.out.println(cadenaAux+superC.getAtributoCadena());
    System.out.println(cadenaAux+subC2.getAtributoCadena());
    System.out.println(cadenaAux+superC2.getAtributoCadena());

    //Ejemplo busqueda de metodos
    System.out.println(subC.metodoSuper());
    System.out.println(subC.metodoSuper("padre"));

    //Ejemplo de los
    System.out.println("Atributo "+subC.atributoPublico+" del objeto de la SubClase");
    System.out.println("Atributo "+subC.getPrivado()+" del objeto de la SubClase");
    System.out.println("Atributo "+subC.atributoProtegido+" del objeto de la SubClase");
  }
}

class SuperClase{
  public String atributoPublico="Publico";
  private String atributoPrivado="Privado";
  protected String atributoProtegido="Protegido";
  String atributoCadena;

  public SuperClase(String s){
    this.atributoCadena = s;
  }

  public SuperClase(){
    this.atributoCadena = "constructor de super sin argumentos";
  }

  public String getAtributoCadena(){
    return atributoCadena;
  }

  public String metodoSuper(String a){
    return "Metodo ejecutado desde la clase "+a+"Por un objeto de la SubClase";
  }

  //Para obtener atributos privados hay que usar un metodo get()
  public String getPrivado(){
    return this.atributoPrivado;
  }

}

class SubClase extends SuperClase{

  //Constructor que usa el encadenamiento de Contructores
  public SubClase(String c){
    //Se hace la llamada al constructor de la clase padre para encadenar
    //los constructores
    super(c);
  }

  public SubClase(){
    this.atributoCadena = "constructor de Sub sin argumentos";
  }

  public String metodoSuper(){
    return "Metodo ejecutado desde la clase hija Por un objeto de la SubClase";
  }

}

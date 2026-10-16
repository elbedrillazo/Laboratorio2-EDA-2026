/**
Clase de pruebas para verificar las implementaciones de Pila y Fila
Valida el comportamiento de estructuras vacias y el funcionamiento Lifo y Fifo 
*/
public class EstructurasTest {
  public static void main(String[] args) {
    //Prueba de estructura vacia, metodos FIFO y LIFO
    System.out.println("Iniciando pruebas");
    pruebaPilaEnlazadaVacia();
    pruebaPilaArregloVacia();
    pruebaFilaEnlazadaVacia();
    pruebaFilaArregloVacia();
    pruebaPilaEnlazadaLIFO();
    pruebaPilaArregloLIFO();
    pruebaFilaEnlazadaFIFO();
    pruebaFilaArreglo();
  }
  public static void pruebaPilaEnlazadaVacia(){
    Pila<Integer> pila= new PilaEnlazada<>();
    boolean vacia = pila.isEmpty();

  if (vacia){
    System.out.println("La pila enlazada esta vacia correctamente");
  }else{
    System.out.println("La pila enlazada no esta vacia");
  }
  }
  public static void pruebaPilaArregloVacia(){
    Pila<Integer> pila = new PilaArreglo<>();
    boolean vacia = pila.isEmpty();
     if (vacia){
    System.out.println("La pila arreglo esta vacia correctamente");
  }else{
    System.out.println("La pila arreglo no esta vacia");
  }
  }
  public static void pruebaFilaEnlazadaVacia(){
    Fila<Integer> fila= new FilaEnlazada<>();
    boolean vacia = fila.isEmpty();

  if (vacia){
    System.out.println("La fila enlazada esta vacia correctamente");
  }else{
    System.out.println("La fila enlazada no esta vacia");
  }
  }
   public static void pruebaFilaArregloVacia(){
    Fila<Integer> fila = new FilaArreglo<>();
    boolean vacia = fila.isEmpty();
     if (vacia){
    System.out.println("La fila arreglo esta vacia correctamente");
  }else{
    System.out.println("La fila arreglo no esta vacia");
  }
  }
// pruebas para lifo y fifo
  public static void pruebaPilaEnlazadaLIFO(){
    Pila<Integer> pila= new PilaEnlazada<>();
    pila.push(1);
    pila.push(2);
    Integer resultado = pila.pop();
    if(resultado != null && resultado==2){
      System.out.println("La pila enlazada sigue el orden LIFO");
    }else{
      System.out.println("La pila enlazada no siguio el orden LIFO");
    }
  }
  public static void pruebaPilaArregloLIFO(){
    Pila<Integer> pila= new PilaArreglo<>();
    pila.push(1);
    pila.push(2);
    Integer resultado = pila.pop();
    if(resultado != null && resultado==2){
      System.out.println("La pila con arreglo sigue el orden LIFO");
    }else{
      System.out.println("La pila con arreglo no siguio el orden LIFO");
    }
  }
  public static void pruebaFilaEnlazadaFIFO(){
    Fila<Integer> fila = new FilaEnlazada<>();
    fila.enqueue(1);
    fila.enqueue(2);
    Integer resultado = fila.dequeue();
    if(resultado != null && resultado==1){
      System.out.println("La fila enlazada siguio el orden FIFO");
    }else{
      System.out.println("La fila enlazada no siguio el orden FIFO");
    }
  }
  public static void pruebaFilaArregloFIFO(){
    Fila<Integer> fila = new FilaArreglo<>();
    fila.enqueue(1);
    fila.enqueue(2);
    Integer resultado = fila.dequeue();
    if(resultado != null && resultado==1){
      System.out.println("La fila con arreglo siguio el orden FIFO");
    }else{
      System.out.println("La fila con arreglo no siguio el orden FIFO");
    }
  }
}

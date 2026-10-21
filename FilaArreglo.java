public class FilaArreglo implements Queue {
    private T[] arreglo;
    private int cantidad;
    private int inicio;
    private int fin;
    private int cantidadRedimensionamientos;
    private int capacidadMaximaObservada;
    public FilaArreglo() {
        arreglo = (T[]) new Object[2];
        cantidad = 0;
        inicio = 0;
        fin = 0;
        cantidadRedimensionamientos = 0;
        capacidadMaximaObservada = 2; //maxima capacidad 2
    }
    private void redimensionar(int nuevaCapacidad) {
        cantidadRedimensionamientos++; //registra el redimensionamiento
        if (nuevaCapacidad > capacidadMaximaObservada) { //si es nuevo se guarda
            capacidadMaximaObservada = nuevaCapacidad;
        }
        T[] nuevoArreglo = (T[]) new Object[nuevaCapacidad]; //areglo mnuevo
        for (int i = 0; i < cantidad; i++) {
            nuevoArreglo[i] = arreglo[(inicio + i) % arreglo.length]; 
        }
        arreglo = nuevoArreglo; //reemplazamo
        inicio = 0;
        fin = cantidad;
    }
    public void enqueue(T item) {
        if (cantidad == arreglo.length) {
            redimensionar(2 * arreglo.length); //duplicar su tamaño
        }
        arreglo[fin] = item;
        fin++;
        if (fin == arreglo.length) {
            fin = 0; //si llega al final 
        }
        cantidad++;
    }
    public T dequeue() {
        if (isEmpty()) { //esta vacio
            System.out.println("La fila esta vacia");
        }
        T item = arreglo[inicio];
        cantidad--;
        inicio++;
        if (inicio == arreglo.length) { //si llega al final se reinicia valor
            inicio = 0;
        }
        return item;
    }
    public T peek() {
        if (isEmpty()) {
            System.out.println("La fila esta vacia");
        }
        return arreglo[inicio];
    }
    public boolean isEmpty() {
        return cantidad == 0;
    }
    public int size() {
        return cantidad;
    }
    public int getCantidadRedimensionamientos() {
        return cantidadRedimensionamientos;
    }
    public int getCapacidadMaximaObservada() {
        return capacidadMaximaObservada;
    }
}

public class PilaArreglo<T> implements Pila<T> {
    private T[] arreglo;
    private int cantidad;
    private int cantidadRedimensionamientos;
    private int capacidadMaximaObservada;
    public PilaArreglo() {
        arreglo = (T[]) new Object[2]; //arreglo de tamaño 2
        cantidad = 0;
        cantidadRedimensionamientos = 0;
        capacidadMaximaObservada = 2;
    }
    private void redimensionar(int nuevaCapacidad) {
        cantidadRedimensionamientos++;
        if (nuevaCapacidad > capacidadMaximaObservada) { //se guarda
            capacidadMaximaObservada = nuevaCapacidad;
        }
        T[] nuevoArreglo = (T[]) new Object[nuevaCapacidad]; //arrgelo nuevo
        for (int i = 0; i < cantidad; i++) {
            nuevoArreglo[i] = arreglo[i];
        }
        arreglo = nuevoArreglo; //reemplazamo
    }
    public void push(T item) {
        if (cantidad == arreglo.length) { //si arreglo lleno se agranda al doble del tamaño
            redimensionar(2 * arreglo.length);
        }
        arreglo[cantidad] = item;
        cantidad++;
    }
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        cantidad--;
        T item = arreglo[cantidad]; //se saca el elemento
        arreglo[cantidad] = null; // esto es para evitar el loitering
        return item;
    }
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return arreglo[cantidad - 1];
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

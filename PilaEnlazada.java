public class PilaEnlazada implements Stack {
    private class Nodo {
        T dato;
        Nodo siguiente;
    }
    private Nodo tope;
    private int cantidad;
    public PilaEnlazada() {
        tope = null;
        cantidad = 0;
    }
    public void push(T item) {
        Nodo viejoFinal = tope; 
        tope = new Nodo();
        tope.dato = item;
        tope.siguiente = viejoTope; //nodo nuevo encima del nodo viejo
        cantidad++;
    }
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T item = tope.dato;
        tope = tope.siguiente;
        cantidad--;
        return item;
    }
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return tope.dato;
    }
    public boolean isEmpty() {
        return tope == null;
    }
    public int size() {
        return cantidad;
    }
}

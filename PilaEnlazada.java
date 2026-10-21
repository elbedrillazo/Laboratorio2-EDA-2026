public class PilaEnlazada implements Stack {
    private class Nodo {
        T dato;
        Nodo siguiente;
    }
    private Nodo final;
    private int cantidad;
    public PilaEnlazada() {
        final = null;
        cantidad = 0;
    }
    public void push(T item) {
        Nodo viejoFinal = final; 
        final = new Nodo();
        final.dato = item;
        final.siguiente = viejoFinal; //nodo nuevo encima del nodo viejo
        cantidad++;
    }
    public T pop() {
        if (isEmpty()) {
            System.out.println("La pila esta vacia");
        }
        T item = final.dato;
        final = final.siguiente;
        cantidad--;
        return item;
    }
    public T peek() {
        if (isEmpty()) {
            System.out.println("La pila esta vacia");
        }
        return final.dato;
    }
    public boolean isEmpty() {
        return final == null;
    }
    public int size() {
        return cantidad;
    }
}

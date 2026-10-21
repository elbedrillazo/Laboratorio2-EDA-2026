public class FilaEnlazada<T> implements Fila<T> {
    private class Nodo{
        T dato;
        Nodo siguiente;
    }
    private Nodo frente;
    private Nodo finalFila;
    private int cantidad;
    public FilaEnlazada(){
        frente = null;
        finalFila = null;
        cantidad = 0;
    }
    public void enqueue(T item){
        Nodo viejoFinal = finalFila; //se guarda el ultimo nodo
        finalFila = new Nodo();
        finalFila.dato = item;
        finalFila.siguiente = null;
        if (isEmpty()){
            frente = finalFila;
        } 
        else{
            viejoFinal.siguiente = finalFila;
        }
        cantidad++;
    }
    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        T item = frente.dato;
        frente = frente.siguiente; 
        cantidad--;
        if (isEmpty()){
            finalFila = null; //tiene que si o si quedar null
        }
        return item;
    }
    public T peek() { //solo se mira el frente
        if (isEmpty()){
            return null;
        }
        return frente.dato;
    }
    public boolean isEmpty(){
        return frente == null; //si frente null esta vacia
    }
    public int size(){
        return cantidad;
    }
}

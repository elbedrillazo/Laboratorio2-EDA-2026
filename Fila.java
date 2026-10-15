public class Fila {
  private Fila() {}
  public interface Fila<T> {
  void enqueue(T item);
  T dequeue();
  T peek();
  boolean isEmpty();
  int size();
  }

}

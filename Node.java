public class Node<T> {
    public T data;
    public Node<T> next;
  // nodo con datos y un putero al siguiente nudo
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    
    @Override
    public String toString() {
        return data.toString();
    }
}

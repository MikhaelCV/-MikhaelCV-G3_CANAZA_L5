public class ListaUtils {
    // Ejercicio 1:busca un elemento genérico en una lista
    public static <T> boolean buscarElemento(Node<T> head, T valor) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(valor)) {
                return true;
            }
            current = current.next;
            
        }
        return false;
    }

    
    // Ejercicio 2: invertir una lista genérica
    public static <T> Node<T> invertirLista(Node<T> head) {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    // Ejercicio 3: insertar un nodo al final
    public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
        Node<T> newNode = new Node<>(valor);
        
        if (head == null) {
            return newNode;
        }
        
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        
        return head;
    }
    
    // Ejercicio 4:contar los nodos
    public static <T> int contarNodos(Node<T> head) {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // Ejercicio 5:ccomparar dos listas
    public static <T> boolean sonIguales(Node<T> lista1, Node<T> lista2) {
        Node<T> current1 = lista1;
        Node<T> current2 = lista2;
        
        while (current1 != null && current2 != null) {
            if (!current1.data.equals(current2.data)) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        
        return current1 == null && current2 == null;
    }
    
    // Ejercicio 6:concatenar dos listas
    public static <T> Node<T> concatenarListas(Node<T> lista1, Node<T> lista2) {
        if (lista1 == null) return lista2;
        if (lista2 == null) return lista1;
        
        Node<T> current = lista1;
        while (current.next != null) {
            current = current.next;
        }
        current.next = lista2;
        
        return lista1;
    }
}

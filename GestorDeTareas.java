import java.util.ArrayList;
import java.util.List;


public class GestorDeTareas<T> {
    private Node<T> head;
    private List<T> tareasCompletadas;
    
    public GestorDeTareas() {
        this.head = null;
        this.tareasCompletadas = new ArrayList<>();
    }
    
    // Agrega una tarea al final de la lista
    public void agregarTarea(T tarea) {
        Node<T> newNode = new Node<>(tarea);
        
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    // Elimina una tarea si existe
    public boolean eliminarTarea(T tarea) {
        if (head == null) return false;
        
        if (head.data.equals(tarea)) {
            head = head.next;
            return true;
        }
        
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(tarea)) {
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }
        
        return false;
    }
    
    // Busca una tarea
    public boolean contieneTarea(T tarea) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(tarea)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Imprime todas las tareas
    public void imprimirTareas() {
        Node<T> current = head;
        System.out.println("=== Lista de Tareas Pendientes ===");
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("===============================");
    }
    
    // Cuenta el total de tareas
    public int contarTareas() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // Obtiene la tarea más prioritaria (solo para objetos Tarea)
    public T obtenerTareaMasPrioritaria() {
        if (head == null) return null;
        
        if (!(head.data instanceof Tarea)) {
            throw new UnsupportedOperationException("Este método solo funciona con objetos de tipo Tarea");
        }
        
        Node<T> current = head;
        Tarea maxPrioridad = (Tarea) current.data;
        
        while (current != null) {
            Tarea tarea = (Tarea) current.data;
            if (tarea.getPrioridad() > maxPrioridad.getPrioridad()) {
                maxPrioridad = tarea;
            }
            current = current.next;
        }
        
        return (T) maxPrioridad;
    }
    
    // Invierte la lista enlazada
    public void invertirTareas() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        head = prev;
    }
    
    // Transfiere una tarea a la lista de completadas
    public boolean marcarComoCompletada(T tarea) {
        if (eliminarTarea(tarea)) {
            tareasCompletadas.add(tarea);
            return true;
        }
        return false;
    }
    
    // Muestra las tareas completadas
    public void imprimirTareasCompletadas() {
        System.out.println("=== Lista de Tareas Completadas ===");
        for (T tarea : tareasCompletadas) {
            System.out.println(tarea);
        }
        System.out.println("===============================");
    }
}

public class Main {
    public static void main(String[] args) {
        // crear gestor de tareas con objetos Tarea
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
        
        // agregar tareas
        gestor.agregarTarea(new Tarea("Hacer informe", 2));
        gestor.agregarTarea(new Tarea("Revisar código", 3));
        gestor.agregarTarea(new Tarea("Preparar presentación", 1));
        
        // imprimir tareas
        gestor.imprimirTareas();
        
        // eeliminar una tarea
        Tarea tareaAEliminar = new Tarea("Revisar código", 3);
        if (gestor.eliminarTarea(tareaAEliminar)) {
            System.out.println("Tarea eliminada con éxito");
        }
        
        // verificar si existe una tarea
        Tarea tareaABuscar = new Tarea("Preparar presentación", 1);
        System.out.println("¿Existe la tarea? " + gestor.contieneTarea(tareaABuscar));
        
        // contar tareas
        System.out.println("Total de tareas: " + gestor.contarTareas());
        
        //obtener tarea más prioritaria
        System.out.println("Tarea más prioritaria: " + gestor.obtenerTareaMasPrioritaria());
        
        //invertir la lista
        gestor.invertirTareas();
        System.out.println("Lista invertida:");
        gestor.imprimirTareas();
        
        // Marcar tarea como completada
        Tarea tareaCompletada = new Tarea("Hacer informe", 2);
        gestor.marcarComoCompletada(tareaCompletada);
        
        //mostrar ambas listas
        gestor.imprimirTareas();
        gestor.imprimirTareasCompletadas();
        
        // demostración de los ejercicios adicionales
        System.out.println("\n=== Demostración de ejercicios adicionales ===");
        
        // crear lista de ejemplo
        Node<String> lista = new Node<>("Primero");
        lista.next = new Node<>("Segundo");
        lista.next.next = new Node<>("Tercero");
        
        // ejercicio 1: Buscar elemento
        System.out.println("¿Contiene 'Segundo'? " + ListaUtils.buscarElemento(lista, "Segundo"));
        
        // Ejercicio 2: Invertir lista
        Node<String> listaInvertida = ListaUtils.invertirLista(lista);
        System.out.println("Lista invertida:");
        imprimirLista(listaInvertida);
        
        // Ejercicio 3: insertar al final
        listaInvertida = ListaUtils.insertarAlFinal(listaInvertida, "Cuarto");
        System.out.println("Después de insertar al final:");
        imprimirLista(listaInvertida);
        
        // Ejercicio 4: Contar nodos
        System.out.println("Número de nodos: " + ListaUtils.contarNodos(listaInvertida));
        
        // Ejercicio 5: Comparar listas
        Node<String> lista2 = new Node<>("Tercero");
        lista2.next = new Node<>("Segundo");
        lista2.next.next = new Node<>("Primero");
        lista2.next.next.next = new Node<>("Cuarto");
        System.out.println("¿Las listas son iguales? " + ListaUtils.sonIguales(listaInvertida, lista2));
        
        // Ejercicio 6: Concatenar listas
        Node<String> lista3 = new Node<>("A");
        lista3.next = new Node<>("B");
        Node<String> listaConcatenada = ListaUtils.concatenarListas(listaInvertida, lista3);
        System.out.println("Listas concatenadas:");
        imprimirLista(listaConcatenada);
    }
    
    private static <T> void imprimirLista(Node<T> head) {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

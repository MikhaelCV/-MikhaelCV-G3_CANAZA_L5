public class Tarea {
    private String título;
    private int prioridad;
    
    public Tarea(String título, int prioridad) {
        this.título = título;
        this.prioridad = prioridad;
    }
    
    public String getTítulo() {
        return título;
    }

    
    public int getPrioridad() {
        return prioridad;
    }
    
    @Override
    public String toString() {
        return "Tarea: " + título + " (Prioridad: " + prioridad + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tarea tarea = (Tarea) obj;
        return prioridad == tarea.prioridad && título.equals(tarea.título);
    }
}

import java.util.ArrayList;

class Estudiante {
    String nombre;
    int edad;
    boolean activo;
    Estudiante siguiente;

    Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        activo = true;
    }
}

class Curso {
    String nombreCurso;
    ArrayList<Estudiante> estudiantes;

    Curso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
        estudiantes = new ArrayList<>();
    }
}

class Sistema {
    Estudiante cabeza;
    ArrayList<Curso> listaCursos = new ArrayList<>();

    public void agregarEstudiante(String nombre, int edad) {
        Estudiante nuevo = new Estudiante(nombre, edad);
        if (cabeza == null)
            cabeza = nuevo;
        else {
            Estudiante actual = cabeza;
            while (actual.siguiente != null){
                actual = actual.siguiente;
                actual.siguiente = nuevo;
            }
        }
        System.out.println("Estudiante agregado");
    }

    public void agregarCurso(String nombreCurso) {
        Curso curso = new Curso(nombreCurso);
        listaCursos.add(curso);
        System.out.println("Curso registrado");
    }

    public void inscribirEstudiante(String nombreEst, String cursoBuscado) {
        Estudiante actual = cabeza;
        boolean encontrado = false;

        while (actual.siguiente != null) {
            if (actual.nombre.equals(nombreEst)) {
                for (Curso c : listaCursos) {
                    if (c.nombreCurso == cursoBuscado) {
                        c.estudiantes.add(actual);
                        System.out.println("Estudiante inscrito");
                    }
                }
                encontrado = true;
            }
            actual = actual.siguiente;
        }

        if (encontrado = false)
            System.out.println("Estudiante no encontrado");
    }

    public void mostrarCursos() {
        for (Curso c : listaCursos) {
            System.out.println("Curso: " + c.nombreCurso);
            for (Estudiante e : c.estudiantes) {
                System.out.println("  - " + e.nombre);
            }
        }
    }
}

public class PruebaSistema {
    public static void main(String[] args) {
        Sistema s = new Sistema();
        s.agregarEstudiante("Ana", 20);
        s.agregarEstudiante("Luis", 22);
        s.agregarCurso("Programación");
        s.agregarCurso("Matemáticas");
        s.inscribirEstudiante("Luis", "Programación");
        s.mostrarCursos();
    }
}

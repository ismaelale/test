
import java.util.ArrayList;
import java.util.List;

class Talleres{

    String nombre_taller;
    String profesor;
    int capacidad_max;
    int cupos_disponible;
    int cupos_ocupados;

    Talleres(){

    }

    Talleres(String nombre_taller, String profesor, int capacidad_max){
        this.nombre_taller = nombre_taller;
        this.profesor = profesor;
        this.capacidad_max = capacidad_max;
        this.cupos_ocupados = 0;
    }

    

    public String getNombre_taller() {
        return nombre_taller;
    }

    public void setNombre_taller(String nombre_taller) {
        this.nombre_taller = nombre_taller;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getCapacidad_max() {
        return capacidad_max;
    }

    public void setCapacidad_max(int capacidad_max) {
        this.capacidad_max = capacidad_max;
    }

    public void inscribir() {
        if (cupos_ocupados < capacidad_max) {
            cupos_ocupados++;
        } else {
            System.out.println("No hay cupos disponibles en " + nombre_taller);
        }
    }

    public void cancelar(){
        cupos_ocupados--;
    }

    public int cupos(){
        return capacidad_max - cupos_ocupados;
    }

}

class Estudiante{

    String estudiante;
    ArrayList<Talleres> lista_talleres;
    Estudiante siguiente;

    Estudiante(String estudiante){
        this.estudiante = estudiante;
        lista_talleres = new ArrayList<>();
        this.siguiente = null;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public ArrayList<Talleres> getLista_talleres() {
        return lista_talleres;
    }

    public void setLista_talleres(ArrayList<Talleres> lista_talleres) {
        this.lista_talleres = lista_talleres;
    }

    

}

class TallerSistema{

    Estudiante cabeza;
    List<Talleres> lista_taller = new ArrayList<>();
    private ArrayList<Estudiante> stu = new ArrayList<>();

    public void AgregarTaller(String nombre, String profesor, int cap_max){

        Talleres nuevo = new Talleres(nombre, profesor, cap_max);
        lista_taller.add(nuevo);
        
    }

    public void VerTalleres(){
        for(Talleres t : lista_taller){
            System.out.println();
            System.out.println("Nombre de la Clase " + "{" + t.nombre_taller + "}");
            System.out.println("PROFESOR " + "{" +  t.profesor + "}");
            System.out.println("CAPACIDAD MAX DE ESTA CLASE " + "{" +  t.capacidad_max + "}");
            System.out.println();
            System.out.println("CUPOS DISPONIBLES EN ESTA CLASE " + "{" +  t.cupos() + "}");
        }
        
    }

    public void InscribirEstudiante(String nombre_taller, String estudiante){

        if(lista_taller.isEmpty()){
            System.out.println("NO TALLERES DISPONIBLES");
            return;
        }

        boolean taller_encontrado = false;

        for(Talleres t : lista_taller){
            
            if(t.getNombre_taller().equals(nombre_taller)){
                taller_encontrado = true;
                
                Estudiante studiante = new Estudiante(estudiante);

                studiante.getLista_talleres().add(t);
                stu.add(studiante);

                t.inscribir();

                if(cabeza == null){
                    cabeza = studiante;
                }
                else{
                    Estudiante actual = cabeza;
                    while(actual.siguiente != null){
                        actual = actual.siguiente;
                    }
                    actual.siguiente = studiante;
                }
                System.out.println("AGREGADO");
            }

        }

        if(!taller_encontrado){
            System.out.println("TALLER NO EN LA");
        }


    }

    public void ListaEstudiantes(){

        

        for(Estudiante e : stu){
            System.out.println();
            System.out.println(e.getEstudiante());
            for(Talleres t : e.lista_talleres){
                System.out.println(t.nombre_taller);
            }
        }

    }

    public void CancelarSuscripcion(String nombre_estudiante, String nombre_clase){

        Estudiante actual = cabeza;

        while(actual != null){
            if(actual.getEstudiante().equals(nombre_estudiante)){

                Talleres taller_eliminar = null;

                for(Talleres t : actual.lista_talleres){
                    if(t.getNombre_taller().equals(nombre_clase)){
                        taller_eliminar = t;
                        break;
                    }
                }

                if(taller_eliminar != null){
                    actual.lista_talleres.remove(taller_eliminar);
                    taller_eliminar.cancelar();
                    return;
                }else{

                }

            }

            actual = actual.siguiente;
        }

        System.out.println("NO ENCONTRADO");

    }

    

}

public class LinkedListPractica2{
    public static void main(String[] args){

        TallerSistema taller = new TallerSistema();
        taller.AgregarTaller("Hola", "Ismael", 10);
        taller.AgregarTaller("Salud", "Julian", 10);
        taller.AgregarTaller("Compresion", "Ale", 10);

        taller.InscribirEstudiante("Hola", "Ale");
        taller.InscribirEstudiante("Compresion", "Alejandro");

        System.out.println("\n=== Lista de Talleres ===");
        taller.VerTalleres();

        System.out.println("\n=== Lista de Estudiantes ===");
        taller.ListaEstudiantes();

        System.out.println("\n--- Cancelando suscripción ---");
        taller.CancelarSuscripcion("Ale", "Hola");

        System.out.println("\n=== Lista Actualizada ===");
        taller.VerTalleres();
        taller.ListaEstudiantes();
    }
}
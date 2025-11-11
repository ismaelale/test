import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Clase{
    String nombre_clase;
    String instructor;
    int capacidad_max; 

    Clase(String nombre_clase, String instructor, int capacidad_max){
        this.nombre_clase = nombre_clase;
        this.instructor = instructor;
        this.capacidad_max = capacidad_max;
    }

    public String getNombre_clase() {
        return nombre_clase;
    }

    public void setNombre_clase(String nombre_clase) {
        this.nombre_clase = nombre_clase;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getCapacidad_max() {
        return capacidad_max;
    }

    public void setCapacidad_max(int capacidad_max) {
        this.capacidad_max = capacidad_max;
    }

    public String toString(){
        return "Nombre Clase" + getNombre_clase() + " - Instructor: " + getInstructor() + " - Capacidad maxima: " + getCapacidad_max();
    }



}

class Cliente{

    String nombre;
    ArrayList<Clase> lista_clase;
    boolean estado;
    Cliente siguiente;

    Cliente(String nombre){
        this.nombre = nombre;
        this.lista_clase = new ArrayList<>();
        this.estado = true;
        this.siguiente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Clase> getLista_clase() {
        return lista_clase;
    }

    public void setLista_clase(ArrayList<Clase> lista_clase) {
        this.lista_clase = lista_clase;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    

}

class Reservacion{

    List<Clase> clase = new ArrayList<>();
    Cliente cabeza;
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void AgregarClases(String nombre_clase, String instructor, int capacidad_max){
        clase.add(new Clase(nombre_clase, instructor, capacidad_max));
        System.out.println("Clase Agregada");
    }

    public void VerClases(){
        for(Clase c : clase){
            System.out.println("\nNombre de la Clase: " + c.getNombre_clase());
            System.out.println("Instructor: " + c.getInstructor());
            System.out.println("Capacidad Maxima de cliente: " + c.getCapacidad_max());
        }
    }

    public void AsignarCliente(String cliente, String nombre_clase){

        if(clase.isEmpty()){
            System.out.println("NO HAY CLASES");
            return;
        }

        boolean clase_encontrada = false;

        for(Clase c : clase){
            if(c.getNombre_clase().equals(nombre_clase)){

                clase_encontrada = true;

                Cliente clientenuevo = new Cliente(cliente);

                clientenuevo.getLista_clase().add(c);
                clientes.add(clientenuevo);

                if(cabeza == null){
                    cabeza = clientenuevo;
                }
                else{
                    Cliente actual = cabeza;
                    while(actual.siguiente != null){
                        actual = actual.siguiente;
                    }
                    actual.siguiente = clientenuevo;
                    
                }
                System.out.println("Cliente: " + cliente + " Inscrito en la clase de: " + nombre_clase);
            }
            
        }

        


        if(!clase_encontrada){
            System.out.println("NO ENCONTRADO");
        }

    }

    public void VerClientes() {
    if (clientes.isEmpty()) {
        System.out.println("No hay clientes registrados.");
        return;
    }

    for (Cliente c : clientes) {
        System.out.println("Cliente: " + c.getNombre());

        if (c.getLista_clase().isEmpty()) {
            System.out.println("  No tiene clases asignadas.");
        } else {
            System.out.println("  Clases asignadas:");
            for (Clase clase : c.getLista_clase()) {
                System.out.println("    - " + clase.getNombre_clase());
            }
        }

        System.out.println(); // espacio entre clientes
    }
}


}


public class PruebaDefinitiva {
    
    public static void main(String[] args){

        int opc;
        Reservacion resv = new Reservacion();
        try(Scanner scan = new Scanner(System.in)){
            do{
                System.out.println("1. AGREGAR CLASE");
                System.out.println("2. VER CLASES");
                System.out.println("3. Cliente asigna clase");
                System.out.println("4. Clientes y sus clases");
                opc = scan.nextInt();
                scan.nextLine();

                switch (opc) {
                    case 1 -> {
                        System.out.println("\t\nNombre de la clase");
                        String nombre = scan.nextLine();
                        System.out.println("Instructor");
                        String instructor = scan.nextLine();
                        System.out.println("Capacidad maxima");
                        int cap = scan.nextInt();
                        scan.nextLine();

                        resv.AgregarClases(nombre, instructor, cap);
                        break;
                    }
                    case 2 ->{
                        System.out.println("\t\nCLASES");
                        resv.VerClases();
                        break;
                    }
                    case 3 ->{
                        System.out.println("\t\nASIGNACION DE CLASE");
                        resv.VerClases();
                        System.out.println("NOMBRE DE CLASE ");
                        String clase_nombre = scan.nextLine();
                        System.out.println("Nombre Cliente");
                        String nombre_cliente = scan.nextLine();
                        resv.AsignarCliente(nombre_cliente, clase_nombre);
                        break;
                    }
                    case 4 ->{
                        System.out.println("\n\t");
                        resv.VerClientes();
                        break;
                    }
                }

            }while(opc != 8);
        }

    }    

}

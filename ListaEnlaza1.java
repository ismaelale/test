import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ListaEnlaza1{
    public static void main(String[] args){

        int opc;
        Scanner scan = new Scanner(System.in);
        TareaDao dao = new TareaDao();

        do{
            System.out.println("\nSISTEMA");
            System.out.println("1. AGREGAR TAREA");
            System.out.println("2. MOSTRAR TAREAS");
            System.out.println("3. ACTUALIZAR ESTADO DE TAREA");
            System.out.println("4. ELIMINAR TAREA YA COMPLETADA");
            System.out.println("5. NUEVO ELEMENTO EN PRIMERRA FILA");
            opc = scan.nextInt();
            scan.nextLine();


            switch (opc) {
                case 1 ->{

                    System.out.println("AGREGUE EL NOMBRE DE LA TAREA");
                    String nombre = scan.nextLine();
                    System.out.println("AGREGUE EL ESTADO EN EL QUE SE ENCUENTRA LA TAREA");
                    String estado = scan.nextLine();
                    dao.agregar(nombre, estado);
                    break;

                }
                case 2 ->{
                    System.out.println("\nMOSTRANDO LAS TAREAS PENDIENTES \n");
                    dao.Mostrar();
                    break;
                }
                case 3 ->{
                    System.out.println("ACTUALIZACION DE ESTADO");
                    System.out.println("TAREA PARA ACTUALIZAR ESTADO");
                    String tarea = scan.nextLine();
                    System.out.println("ESCRIBA EL ESTADO NUEVO");
                    String estado_nuevo = scan.nextLine();

                    dao.actualizacion(tarea, estado_nuevo);

                    break;
                }
                case 4 ->{
                    System.out.println("ELIMINACION DE TAREAS");
                    System.out.println("ESCRIBA EL NOMBRE DE LA TAREA A ELIMINAR");
                    String nombre = scan.nextLine();

                    dao.Eliminar(nombre);

                    break;
                }
                case 5 ->{
                    System.out.println("NOMBRE");
                    String nombre = scan.nextLine();
                    System.out.println("ESTADO");
                    String estado = scan.nextLine();
                    dao.AgrearNuevoElemento(nombre, estado);
                }
                default ->
                    System.out.println("NUMERO INVALIDO");
                
            }

        }while(opc != 8);

        

    }
}

class Tarea{

    String estudiante;
    String estado;

    public Tarea(String estudiante, String estado){
        this.estudiante = estudiante;
        this.estado = estado;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

}

class TareaDao{

    LinkedList<Tarea> lista = new LinkedList<>();

    public void agregar(String nombre, String estado){
        lista.add(new Tarea(nombre, estado));
        System.out.println("AGREGADO");
    }

    public void Mostrar(){
        for(Tarea t : lista){
            System.out.println("NOMBRE: " + t.getEstudiante());
            System.out.println("ESTADO : " + t.getEstado());
        }
    }

    public void actualizacion(String tarea, String estado_nuevo){

        if(lista.isEmpty()){
            System.out.println("LISTA VACIA");
            return;
        }

        for(Tarea tareaa : lista){
            if(tareaa.getEstudiante().equalsIgnoreCase(tarea)){
                tareaa.setEstado(estado_nuevo);
                System.out.println("ACTUALIZADO");
            }
            else{
                System.out.println("TAREA NO ENCONTRADA");
            }
        }

    }

    public void Eliminar(String nombre){
        if(lista.isEmpty()){
            System.out.println("LISTA VACIA");
            return;
        }

        Iterator<Tarea> tarea_eliminar = lista.iterator();
        boolean eliminado = false;
        while(tarea_eliminar.hasNext()){
            Tarea tarea = tarea_eliminar.next();
            if(tarea.getEstudiante().equalsIgnoreCase(nombre)){
                eliminado = true;
                tarea_eliminar.remove();
            }
            
        }

        if(eliminado){
            System.out.println("ELIMINADO");
        }
        else{
            System.out.println("NO SE PUDO ELIMINAR");
        }

    }

    public void AgrearNuevoElemento(String nombre, String estado){
        lista.addFirst(new Tarea(nombre, estado));
        System.out.println("AGREGADO EN PRIMERA FILA");
    }

}
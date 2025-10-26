import java.util.Scanner;

public class Nodo3Ejercicio{
    public static void main(String[] args){

        ListaTarea lista = new ListaTarea(); //INICIO DE LA LISTA
        Scanner scan = new Scanner(System.in);
        int opc;


        do{

            System.out.println("\nSISTEMA DE NODOS");
            System.out.println("1. INGRESAR TAREA");
            System.out.println("2. VER NODOS");
            System.out.println("3. MARCAR TAREA COMO COMPLETADA");
            System.out.println("4. ELIMINAR TAREA");
            opc = scan.nextInt(); 
            scan.nextLine();

            switch (opc) {
                case 1->{
                    System.out.println("\nTAREA");
                    String tarea = scan.nextLine();
                    System.out.println("ESTADO");
                    String estado = scan.nextLine();

                    lista.Agregar(tarea, estado);
                    break;
                    
                }
                case 2 ->{
                    lista.Ver();
                    break;
                }
                case 3 ->{
                    System.out.println("ELIMINAR, ESCRIBA EL NOMBRE");
                    lista.Ver();
                    String nombre = scan.nextLine();
                    lista.Eliminar(nombre);
                    break;
                }
            }

        }while(opc != 5);

    }
}

class NodoTarea{

    String nombre;
    String estado;
    NodoTarea siguiente;

    NodoTarea(String nombre, String estado){

        this.nombre = nombre;
        this.estado = estado;
        this.siguiente = null;

    }
}

class ListaTarea{
    NodoTarea cabeza;

    public void Agregar(String nombre, String estado){
        NodoTarea nuevo = new NodoTarea(nombre, estado);
        if(cabeza == null){
            cabeza = nuevo;
        }else{
            NodoTarea actual = cabeza;
            while(actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        System.out.println("AGREGADO");
    }

    public void Ver(){
        if(cabeza == null){
            System.out.println("NO HAY NODOS");
            return;
        }

        NodoTarea actual = cabeza;
        while(actual != null){
            System.out.println("TAREA : " + "{" + actual.nombre + "}" + " ESTADO: " + "{" + actual.estado + "}" );
            actual = actual.siguiente;
        }
    }

    public void Eliminar(String nombre){
        
        //VERIFICAMOS SI LA LISTA NO ESTA VACÍA 
        if(cabeza == null){
            System.out.println("LISTA VACÍA");
            return;
        }

        //VEREMOS SI EL PUNTERO A ELIMINAR ESTA DE PRIMERO
        if(cabeza.nombre.equals(nombre)){
            cabeza = cabeza.siguiente;
            System.out.println("ELIMINADO");
            return;
        }

        //VAMOS A RECORRER LA LISTA HASTA ENCONTRAR
        NodoTarea actual = cabeza;
        while(actual.siguiente != null && !actual.siguiente.nombre.equals(nombre)){
            actual = actual.siguiente;
        }

        if(actual.siguiente == null){
            System.out.println("NO ENCONTRADO");
        }
        else{
            actual.siguiente = actual.siguiente.siguiente;
            System.out.println("eliminado");
        }
        
    }

}
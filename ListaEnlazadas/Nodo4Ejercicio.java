import java.util.Scanner;

class NodoPaciente{

    String nombre;
    int edad;
    boolean estado;
    NodoPaciente siguiente;

    NodoPaciente(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
        this.estado = false;
        this.siguiente = null;
    }

}

class Lista{

    NodoPaciente nodo;

    public void Agregar(String nombre, int edad){
        
        NodoPaciente nuevo = new NodoPaciente(nombre, edad);

        //SI NO HAY NADA EN LA LISTA, SERÁ EL PRIMERO
        if(nodo == null){
            nodo = nuevo;
        }//SI NO ES EL PRIMERO, RECORRERA HASTA UN PUNTERO ANTES DEL NULO
        else{
            NodoPaciente actual = nodo;
            while(actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        System.out.println("AGREGADO");
    }

    public void ver(){
        if(nodo == null){
            System.out.println("LISTA VACÍA");
            return;
        }

        NodoPaciente actual = nodo;
        while(actual != null){
            if(actual.estado == true){
                System.out.println("PACIENTE: {" + actual.nombre + "}  EDAD : {" + actual.edad + "}" + "  ESTADO : ATENDIDO");
            }else{
                System.out.println("PACIENTE: {" + actual.nombre + "}  EDAD : {" + actual.edad + "}" + "  ESTADO : NO ATENDIDO");
            }
            actual = actual.siguiente;
        }



    }

    public void Buscar(String nombre){
        if(nodo == null){
            System.out.println("LISTA VACÍA");
            return;
        }

        boolean encontrado = false;
        while(nodo != null){
            if(nodo.nombre.equals(nombre)){
                encontrado = true;
                System.out.println(nodo.nombre + " " + nodo.edad);
                return;
            }
            nodo = nodo.siguiente;
        }
        

        if(encontrado){
            System.out.println("no encontrado");
        }

    }

    public void eliminar(String nombre){
        if(nodo == null){
            System.out.println("LISTA VACIA");
            return;
        }

        //SI ESTA EN EL PRIMER PUNTERO
        if(nodo.nombre.equalsIgnoreCase(nombre)){
            System.out.println("ELIMINADO");
            nodo = nodo.siguiente;
            return;
        }


        //SI NO ESTA EL EL PUNTERO, ENTONCES HAY QUE RECORRERER

        NodoPaciente actual = nodo;
        while(actual.siguiente != null && !actual.siguiente.nombre.equalsIgnoreCase(nombre)){
            actual = actual.siguiente;
        }

        if(actual.siguiente == null){
            System.out.println("PACIENTE NO ENCONTRADO");
        }
        else{
            actual.siguiente = actual.siguiente.siguiente;
            System.out.println("eliminado");
        }
        
    }

    public void Esatado(String nombretarea){

        if(nodo == null){
            System.out.println("LISTA VACÍA");
            return;
        }

        NodoPaciente actual = nodo;
        boolean encontrado = false;
        while(actual != null){
            if(actual.nombre.equals(nombretarea)){
                System.out.println("PACIENTE ENCONTRADO");
                actual.estado = true;
                System.out.println("PACIENTE CON ESTADO ACTUALIZADO");
                encontrado = true;
                break;
            }
            actual = actual.siguiente;
        }

        if(!encontrado){
            System.out.println("NO ENCONTRADO");
        }

    }

}

public class Nodo4Ejercicio{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Lista lista = new Lista();
        int opc;

        do{
            System.out.println("1. AGREGAR");
            System.out.println("2. VER PACIENTES");
            System.out.println("3. BUSCAR PACIENTE");
            System.out.println("4. ELIMINAR PACIENTE");
            System.out.println("5. ACTUALIZACION");
            opc = scan.nextInt();
            scan.nextLine();

            switch(opc){
                case 1 -> {
                    System.out.println("INGRESE EL NOMBRE");
                    String nombre = scan.nextLine();
                    System.out.println("EDAD");
                    int edad = scan.nextInt();
                    scan.nextLine();

                    lista.Agregar(nombre, edad);
                    break;
                }
                case 2 -> {
                    lista.ver();
                    break;
                }
                case 3 -> {
                    System.out.println("ENCUENTRE EL PACIENTE POR SU NOMBRE");
                    lista.ver();
                    String nombre = scan.nextLine();
                    lista.Buscar(nombre);
                    break;
                }
                case 4 ->{
                    System.out.println("ELIMINAR PACIENTE");
                    String nombre = scan.nextLine();
                    lista.eliminar(nombre);
                    break;
                }
                case 5 -> {
                    System.out.println("NOMBRE DEL PACIENTE");
                    lista.ver();
                    String nombre = scan.nextLine();
                    lista.Esatado(nombre);
                    break;
                }
            }

        }while(opc != 6);

    }
}
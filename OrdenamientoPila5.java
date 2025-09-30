import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class OrdenamientoPila5{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Stack<Estudiante> pila = new Stack<>();
        ArrayList<Estudiante> lista = new ArrayList<>();

        System.out.println("INGRESE LOS NOMBRES Y NOTAS DE LOS ESTUDIANTES, (FIN PARA SALIR)");

        while(true){
            
            System.out.println("INGRESE EL NOMBRE DEL ESTUDIANTE");
            String nombre = scan.nextLine();

            if(nombre.equalsIgnoreCase("FIN")){
                break;
            }

            System.out.println("INGRESE LA NOTA DEL ESTUDAINTE " + nombre);
            double nota = scan.nextDouble();
            scan.nextLine();
            
            pila.push(new Estudiante(nombre, nota));

        }


        //PASAMOS DE LA PILA A LA LISTA
        while(!pila.isEmpty()){
            lista.add(pila.pop());
        }

        //FORMA DESCENDENTE
        for(int i = 0; i < lista.size() - 1; i++){
            for(int j = 0; j < lista.size() - 1 - i; j++){
                if(lista.get(j).getcalificaciones() > lista.get(j + 1).getcalificaciones()){
                    Estudiante tem = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, tem);
                }
            }
        }

        System.out.println("\nESTUDIANTES ORDENADOS DE MAYOR A MENOR");
        for(Estudiante e: lista){
            System.out.println(e.getNombre() + "   --    " + e.getcalificaciones());
        }

    }
}

class Estudiante{

    private String nombre;
    private double calificaciones;

    public Estudiante(String nombre, double calificaciones){
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    public String getNombre(){
        return nombre;
    }

    public double getcalificaciones(){
        return calificaciones;
    }

}


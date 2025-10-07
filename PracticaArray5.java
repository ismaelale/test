import java.util.Scanner;
import java.util.ArrayList;

public class PracticaArray5{
    public static void main(String[] args){


        
        ArrayList<Integer> izquierda = new ArrayList<>();
        ArrayList<Integer> derecha = new ArrayList<>();
        try(Scanner scan = new Scanner(System.in)){

            System.out.println("LA CANTIDAD DE ELEMENTOS SERÁN 4");
        
            for(int i = 0; i < 4; i++){
                int elementos = scan.nextInt();
                scan.nextLine();

                izquierda.add(elementos);
                derecha.add(elementos);
            }
        
            System.out.println("\nELEMENTOS");
            System.out.println(izquierda);

            //POSICION QUE DESEA MOVER
            System.out.println("\nCANTIDAD DE POSICIONES QUE DESEA MOVER");
            int pos = scan.nextInt();
            scan.nextLine();
            
        //Izquierda
            for(int i = 0; i < pos; i++){
                int cambio = izquierda.get(0);
                for(int j = 0; j < izquierda.size() - 1; j++){
                    izquierda.set(j, izquierda.get(j + 1));
                }
                izquierda.set(izquierda.size() - 1, cambio);
            }
        

        //Derecha
            for(int i = 0; i < pos; i++){
                int cambio = derecha.get(derecha.size() - 1);
                for(int j = derecha.size() - 1; j > 0; j--){
                    derecha.set(j, derecha.get(j - 1));
                }
                derecha.set(0, cambio);
            }


        //Lista Izquierda
            System.out.println("\nIzquierda");
            System.out.println(izquierda);


        //Lista Derecha
            System.out.println("\nDerecha");
            System.out.println(derecha);




        }
    }
}
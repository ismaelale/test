import java.util.Scanner;
import java.util.ArrayList;

public class Practica2Array5{
    public static void main(String[] args){

        ArrayList<Integer> izquierda = new ArrayList<>();
        ArrayList<Integer> derecha = new ArrayList<>();

        try(Scanner scan = new Scanner(System.in)){

            System.out.println("5 elementos");

            for(int i = 0; i < 5; i++){
                int elementos = scan.nextInt();
                scan.nextLine();

                izquierda.add(elementos);
                derecha.add(elementos);
            }

            System.out.println("\nElementos");
            System.out.println(izquierda);
            
            
            System.out.println("\nPosicion que quiera recorrer");
            int posicion = scan.nextInt();
            scan.nextLine();
            //Izquierda
            for(int i = 0; i < posicion; i++){
                int cambio = izquierda.get(0);
                for(int j = 0; j < izquierda.size() - 1; j++){
                    izquierda.set(j, izquierda.get(j + 1));
                }
                izquierda.set(izquierda.size() - 1, cambio);
            }


            //Derecha
            for(int i = 0; i < posicion; i++){
                int cambio = derecha.get(derecha.size() - 1);
                for(int j = derecha.size() - 1; j > 0; j--){
                    derecha.set(j, derecha.get(j - 1));
                }
                derecha.set(0, cambio);
            }


            System.out.println("\nIzquierda");
            System.out.println(izquierda);

            System.out.println("\nDerecha");
            System.out.println(derecha);





        }

    }
}
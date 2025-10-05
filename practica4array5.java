import java.util.Scanner;
import java.util.ArrayList;

public class practica4array5{
    public static void main(String[] args){
        ArrayList<Integer> derecha = new ArrayList<>();
        ArrayList<Integer> izquierda = new ArrayList<>();

        try(Scanner scan = new Scanner(System.in)){

            for(int i = 0; i < 4; i++){
                int elementos = scan.nextInt();
                scan.nextLine();

                derecha.add(elementos);
                izquierda.add(elementos);
                
            }

            System.out.println("\nElementos");
            System.out.println(izquierda);

            System.out.println("\n posiciones que quiera recorrer");
            int pos = scan.nextInt();
            scan.nextLine();

            //izquierda
            for(int i = 0; i < pos; i++){
                int cambio = izquierda.get(0);
                for(int j = 0; j < izquierda.size() - 1; j++){
                    izquierda.set(j, izquierda.get(j + 1));
                }
                izquierda.set(izquierda.size() - 1, cambio);
            }

            //derecha
            for(int i = 0; i < pos; i++){
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
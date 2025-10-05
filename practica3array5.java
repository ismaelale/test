import java.util.Scanner;
import java.util.ArrayList;

public class practica3array5{
    public static void main(String[] args){

        ArrayList<Integer> izquierda = new ArrayList<>();
        ArrayList<Integer> derecha = new ArrayList<>();

        try(Scanner scan = new Scanner(System.in)){

            for(int i = 0; i < 4; i++){

                int elementos = scan.nextInt();
                scan.nextLine();

                izquierda.add(elementos);
                derecha.add(elementos);
            }

            System.out.println("\nELEMENTOS");
            System.out.println(izquierda);

            System.out.println("\nposiciones que quiera mover");
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

            //Derecha
            for(int i = 0; i < pos; i++){
                int cambio = derecha.get(derecha.size() - 1);
                for(int j = derecha.size() - 1; j > 0; j--){
                    derecha.set(j, derecha.get(j - 1));
                }
                derecha.set(0, cambio);
            }


            System.out.println("\nderecha");
            System.out.println(derecha);

            System.out.println("\nizquierda");
            System.out.println(izquierda);

        }

    }
}
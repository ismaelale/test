import java.util.Scanner;
import java.util.ArrayList;

public class array5{
    public static void main(String[] args){

        /*
        Array original: `[1, 2, 3, 4, 5]` 
	    Rotar 2 posiciones a la derecha → `[4, 5, 1, 2, 3]`
	    Rotar 2 posiciones a la izquierda → `[3, 4, 5, 1, 2]`
        */

        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();
        try(Scanner scan = new Scanner(System.in)){

            System.out.println("CUANTOS ELEMENTOS DESEA AGREGAR ");
            int elementos = scan.nextInt();
            scan.nextLine();

            for(int i = 0; i < elementos; i++){
                int numeros = scan.nextInt();
                scan.nextLine();

                lista.add(numeros);
                lista2.add(numeros);
                
            }

            System.out.println("\nNUMEROS");
            System.out.println(lista);

            System.out.println("\nPOSICIONES QUE QUIERE ROTAR");
            int pos = scan.nextInt();
            scan.nextLine();

            //Derecha
            for(int i = 0; i < pos; i++){ //Repetimos la posición que se le indico mover
                int cambio = lista.get(lista.size() - 1); //Guardamos el ultimo elemento
                for(int j = lista.size() - 1; j > 0; j--){
                    lista.set(j, lista.get(j - 1)); //cada elemento se mueve una posición a la derecha
                }
                lista.set(0, cambio); //El utltimo guardado se coloca al inicio
            }

            //Izquierda
            for(int i = 0; i < pos; i++){
                int cambio2 = lista2.get(0);
                for(int j = 0; j < lista2.size() - 1; j++){
                    lista2.set(j, lista2.get(j + 1));
                }
                lista2.set(lista2.size() - 1, cambio2);
            }


            System.out.println("\nDerecha");
            for(int n : lista){
                System.out.println(n);
            }


            System.out.println("\nIzquierda");
            for(int x : lista2){
                System.out.println(x);
            }



        }




    }
}
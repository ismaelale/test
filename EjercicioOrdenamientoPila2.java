//Permita al usuario ingresar números enteros.

//Ordene los números de menor a mayor utilizando un algoritmo de ordenamiento (ejemplo: burbuja o selección).

//Guarde los números ordenados en una pila.

//Muestre los números en el orden inverso (de mayor a menor) al sacarlos de la pila.


import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class EjercicioOrdenamientoPila2{
    public static void main(String[] args){
        
        try (Scanner scan = new Scanner(System.in)) {
            Stack<Integer> numeros = new Stack<>();
            ArrayList<Integer> enteros = new ArrayList<>();

            System.out.println("INGRESA NUMEROS ENTEROS (-1 PARA TERMINAR)");
            while(true){
                
                int n = scan.nextInt();
                scan.nextLine();
                if(n == -1){
                    break;
                }
                enteros.add(n);

            }
            
            System.out.println("Numeros ingresados : " + enteros);

            //ORDENAMOS LOS NUMEROS
            for(int i = 0; i < enteros.size() - 1; i++){
                for(int x = 0; x < enteros.size() - 1 - i; x++){
                    if(enteros.get(x) > enteros.get(x + 1)){
                        int intercambio = enteros.get(x);
                        enteros.set(x, enteros.get(x + 1));
                        enteros.set(x+1, intercambio);
                    }
                }
            }
            
            System.out.println("Ordenamientos " + enteros);
            
            for(int g : enteros){
                numeros.push(g);
            }
            
            System.out.println("Guardados en la pila: " + numeros);

            String ordeninverso = "";
            while(!numeros.isEmpty()){
                ordeninverso += numeros.pop() + " ";
            }

            System.out.println("Orden Inverso : " + ordeninverso);
        }

    }
}

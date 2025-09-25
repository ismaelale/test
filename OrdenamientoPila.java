import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class OrdenamientoPila {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<String> palabras = new ArrayList<>();
        Stack<String> pila = new Stack<>();

        System.out.println("Ingrese palabras (escriba 'FIN' para terminar):");

        // Paso 1: Leer palabras y guardarlas en la lista
        while (true) {
            String entrada = scan.nextLine();
            if (entrada.equalsIgnoreCase("FIN")) {
                break;
            }
            palabras.add(entrada);
        }

        // Paso 2: Ordenar con Bubble Sort
        for (int i = 0; i < palabras.size() - 1; i++) {
            for (int j = 0; j < palabras.size() - 1 - i; j++) {
                if (palabras.get(j).compareTo(palabras.get(j + 1)) > 0) {
                    // Intercambio
                    String temp = palabras.get(j);
                    palabras.set(j, palabras.get(j + 1));
                    palabras.set(j + 1, temp);
                }
            }
        }

        System.out.println("\nLista ordenada alfabéticamente:");
        System.out.println(palabras);

        // Paso 3: Pasar a la pila
        for (String palabra : palabras) {
            pila.push(palabra);
        }

        // Paso 4: Imprimir desde la pila (descendente)
        System.out.println("\nPalabras en orden descendente:");
        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
    }
}


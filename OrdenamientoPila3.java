import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class OrdenamientoPila3{
    public static void main(String[] args){

        //PEDIR AL USUARIO INGRESAR VARIAS PALABRAS
        Scanner scan = new Scanner(System.in);
        Stack<String> palabras = new Stack<>();



        System.out.println("INGRESE VARIAS PALABRAS (ESCRIBA FIN PARA FINALIZAR)");
        while(true){
            String pal = scan.nextLine();
            if(pal.equalsIgnoreCase("FIN")){
                break;
            }
                palabras.push(pal);

        }

        System.out.println("\nPALABRAS INGRESADAS " + palabras);

        for(int i = 0; i < palabras.size() - 1; i++){
            for(int j = 0; j < palabras.size() - 1 - i; j++){
                if(palabras.get(j).compareTo(palabras.get(j + 1)) > 0){
                    String intercambio = palabras.get(j);
                    palabras.set(j, palabras.get(j + 1));
                    palabras.set(j + 1, intercambio);
                }
            }
        }

        System.out.println("\nPALABRAS ORDENADAS " + palabras);

        String inversa = "";

        while(!palabras.isEmpty()){
            inversa += palabras.pop() + " ";
        }
        
        System.out.println("\nPALABRAS A LA INVERSA " + inversa);
    }
}
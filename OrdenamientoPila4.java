import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class OrdenamientoPila4{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Stack<String> pila = new Stack<>();
        ArrayList<String> nombre = new ArrayList<>();

        System.out.println("INGRESE NOMBRES QUE USTED DESEA (FIN PARA FINALIZAR)");

        while(true){
            String nombres = scan.nextLine();

            if(nombres.equalsIgnoreCase("FIN")){
                break;
            }
            //LOS GUARDAMOS EN LA PILA
            pila.push(nombres);
        }

        System.out.println("\nNOMBRES EN LA PILA: " + pila);

        System.out.println("\nULTIMO NOMBRE QUE SE INGRESO " + pila.peek());

        
        String nombres_guardados = "";
        while(!pila.isEmpty()){
            nombre.add(pila.pop());
            
        }
        

        
        System.out.println("\nNOMBRES EN LA LISTA" + nombre);

        //ORDENAR DE MANARA ALFABETICAMENTE
        for(int i = 0; i < nombre.size() - 1; i++){
            for(int j = 0; j < nombre.size() - 1 - i; j++){
                if(nombre.get(j).compareTo(nombre.get(j + 1)) > 0){
                    String intercambio = nombre.get(j);
                    nombre.set(j, nombre.get(j + 1));
                    nombre.set(j + 1, intercambio);
                }
            }
        }


        System.out.println("\nLISTA ORDENADA ALFABETICAMENTE " + nombre);
        


    }
}
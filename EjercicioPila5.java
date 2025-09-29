import java.util.Scanner;
import java.util.Stack;

public class EjercicioPila5{
    public static void main(String[] args){
        
        System.out.println("ESCRIBA LAS PALABARAS QUE DESEA, SI DESEA FINALIZAR, ESCRIBA 'FIN' SIN QUIERE ELIMINAR LA UTILIMA PALABRA QUE ESCRIBIO ESCRIBA 'UNDO' ");
        String palabra = "";
        Scanner scan = new Scanner(System.in);
        Stack<String> pila = new Stack<>();
        do{

            palabra = scan.nextLine();

            if(palabra.equals("UNDO")){
                if(!pila.isEmpty()){
                    System.out.println("SE ELIMINO: " + pila.pop());
                }else{
                    System.out.println("NO HAY NADA QUE ELIMINAR");
                }

            }else if(!palabra.equals("FIN")){
                pila.push(palabra);
            }

            

        }while(!palabra.equals("FIN"));

        System.out.println(pila);
        System.out.println("HOLA");
        
    }
}
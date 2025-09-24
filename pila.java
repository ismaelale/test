import java.util.Stack;

public class pila{


    public static void main(String[] args){

        Stack<Integer> pila = new Stack<>();
        
        pila.push(10); 
        pila.push(20);
        pila.push(30);

        System.out.println("LA PILA ESTA VACIA? " + pila.isEmpty());

        System.out.println("LOS NUMERO DE LA PILA SON: " + pila);

        System.out.println("EL UTLIMO NÚMERO DE LA PILA ES: " + pila.peek());

        System.out.println("SACAREMOS EL ULTIMO NUMERO DE LA PILA " + pila.pop());

        System.out.println("EL CONTENIDO DE LA PILA ES: " + pila);
    }
}

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class arrayList2 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);

        ArrayList<Integer> numero = new ArrayList<>();
        Stack<Integer> pila = new Stack<>();

        System.out.println("INGRESE LOS NUMEROS QUE QUIERA INGRESAR");
        int cantidad = sca.nextInt();
        sca.nextLine();
        
        System.out.println("\nINGRESE LOS NUMEROS");
        for(int i = 0; i < cantidad; i++){
            
            int num = sca.nextInt();
            sca.nextLine();
            numero.add(num);
            
        }

        for(int j = 0; j < numero.size() - 1; j++){
            for(int x = 0; x < numero.size() - 1 - j; x++){
                if(numero.get(x) > numero.get(x + 1)){
                    int intercambio = numero.get(x);
                    numero.set(x, numero.get(x + 1));
                    numero.set(x + 1, intercambio); 
                }
            }
        }

        System.out.println("\n");
        
        for(int n : numero){
            System.out.println(n);
            pila.push(n);
        }
        

        System.out.println("\n" + pila);
        String invertido = "";

        while(!pila.isEmpty()){
            invertido += pila.pop() + " ";
        }
        
        System.out.println(invertido);
    
    
    }
}
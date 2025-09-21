import java.util.Scanner;
import java.util.Stack;

public class pila4{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        Stack<Character> pila = new Stack<>();

        System.out.println("INGRESE UNA PALABRA");
        String palabra = scan.nextLine();

        for(char c: palabra.toCharArray()){
            pila.push(c);
        }

        String invertido = "";

        while(!pila.isEmpty()){
            invertido += pila.pop();
        }

        if(palabra.equals(invertido)){
            System.out.println("POLINDROMO");
        }else{
            System.out.println("NO ES POLINDROMO");
        }

    }
}

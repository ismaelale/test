import java.util.Stack;
import java.util.Scanner;

public class pila3{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        Stack<Character> caracter = new Stack<>();

        System.out.println("INGRESE UNA PALABRA");
        String palabra = scan.nextLine();

        for(Character c : palabra.toCharArray()){
            caracter.push(c);
        }

        String invertida = "";
        
        while(!caracter.isEmpty()){
            invertida += caracter.pop();
        }

        System.out.println(palabra);
        System.out.println(invertida);

    }
}

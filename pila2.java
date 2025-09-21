import java.util.Scanner;
import java.util.Stack;


public class pila2{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        Stack<Character> caracter = new Stack<>();

        

        //(5 + 3) * (2 + (4 - 1)) correct
        //((3 + 2) * (4 - 1) incorrecto

        System.out.println("INGRESE UNA EXPRESION");
        String expresion = scan.nextLine();

        boolean baleanceado = true;

        for(Character c : expresion.toCharArray()){
            if(c == '('){
                caracter.push(c);
            }else if(c == ')'){
                if(caracter.isEmpty()){
                    baleanceado = false;
                    break;
                }else{
                    caracter.pop();
                }
            }
        }
        
        if(!caracter.isEmpty()){
            baleanceado = false;
        }


        if(baleanceado){
            System.out.println("ESTA CORRECTO");
        }else{
            System.out.println("ESTA INCORRECTO");
        }

    }
}

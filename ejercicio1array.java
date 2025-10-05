import java.util.Scanner;

public class ejercicio1array{
    public static void main(String[] arg){
        try (Scanner sca = new Scanner(System.in)) {
            int[] num = new int[5];
            
            System.out.println("INGRESE LOS NUMEROS\n");
            
            for(int i = 0; i < num.length; i++){
                
                num[i] = sca.nextInt();
            }
            
            System.out.println("ARRAYS ORIGINAL");
            for(int n:num){
                System.out.println(n + " ");
            }
            
            System.out.println("ORDENAMIENTO");
            
            for(int j = 0; j < num.length - 1; j++){
                for(int x = 0; x < num.length - 1 - j; x++){
                    if(num[x] > num[x + 1]){
                        int intercambio = num[x];
                        num[x] = num[x + 1];
                        num[x + 1] = intercambio;
                    }
                }
            }
            
            System.out.println("ARRAY ORDENADO");
            
            for(int r:num){
                System.out.println(r + " ");
            }
        }
    }
}


public class array{

    public static void main(String[] args){
        //Arrays
        
        //ALGORITMO DE ORDENAMIENTO
        int[] numero = {30,10,1,20,3,5,2,8};
        
        for(int i = 0; i < numero.length - 1; i++){
            for(int j = 0; j < numero.length - 1 - i; j++){
                if(numero[j] > numero[j + 1]){
                    int intercambio = numero[j];
                    numero[j] = numero[j + 1];
                    numero[j + 1] = intercambio;
                            
                }
            }
        }
        
        for(int n: numero){
            System.out.println(n + " ");
        }
        
    }

}

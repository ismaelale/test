import java.util.Scanner;
import java.util.ArrayList;

public class array4{
    public static void main(String[] args){

        //Ingresar 5 calificaciones 
        //Promedio de todas las calificaciones
        //Calificacion mas baja y mas alta
        ArrayList<Double> calificaciones = new ArrayList<>();


        try(Scanner scan = new Scanner(System.in)){

            for(int i = 1; i <= 5; i++){
                System.out.println("ESCRIBA LA CALIFICACION #" + i);
                double cal = scan.nextDouble();
                scan.nextLine();

                calificaciones.add(cal);

            }


            System.out.println("\nCalificaciones: " );
            for(Double n : calificaciones){
                System.out.println(n);
            }

            double mayor = calificaciones.get(0);
            double menor = calificaciones.get(0);            

            for(Double i : calificaciones){
                if(i > mayor){
                    mayor = i;
                }else if(i < menor){
                    menor = i;
                }
            }     
            System.out.println("\nNota alta " + mayor);
            System.out.println("Nota baja: " + menor);




        }
    }
}
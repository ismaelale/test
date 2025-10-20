import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicio4ArraPrueba{
    public static void main(String[] args){

        int opc;
        
        try(Scanner scan = new Scanner(System.in)){

            do{
                System.out.println("\nSISTEMA DE PRODUCTOS");
                System.out.println("1. Agregar productos");
                opc = scan.nextInt();
                scan.nextLine();

                switch(opc){
                    case 1 ->{

                        System.out.println("INGRESE EL NOMBRE DEL PRODUCTO");
                        String nombreproducto = scan.nextLine();
                        System.out.println("INGRESE EL PRECIO");
                        double precio = scan.nextDouble();
                        scan.nextLine();

                        ProductosDAo dao = new ProductosDAo();
                        dao.agregar(nombreproducto, precio);
                        break;
                    }
                }

            }while(opc != 8);
        }

        



    }
}

class Productos{
    private String nombreproducto;
    private double precio;

    public Productos(String nombreproducto, double precio){
        this.nombreproducto = nombreproducto;
        this.precio = precio;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}

class ProductosDAo{
    ArrayList<Productos> listaproductos = new ArrayList<>();

    public void agregar(String nombreproducto, double precio){
        listaproductos.add(new Productos(nombreproducto, precio));
        System.out.println("PRODUCTO INGRESADO");
    }

}
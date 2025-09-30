import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class OrdenamientoPila6{
    public static void main(String[] arg){

        Scanner scan = new Scanner(System.in);
        Stack<Producto> pila = new Stack<>();
        ArrayList<Producto> lista = new ArrayList<>();

        System.out.println("FIN PARA FINALIZAR");

        while(true){
            System.out.println("INGRESE EL NOMBRE DEL PRODUCTO");
            String nombre_producto = scan.nextLine();

            if(nombre_producto.equalsIgnoreCase("FIN")){
                break;
            }

            System.out.println("INGRESE EL PRECIO DEL " + nombre_producto);
            double precio = scan.nextDouble();
            scan.nextLine();

            pila.push(new Producto(nombre_producto, precio));
            
        }

        System.out.println("\nMOSTRANDO LA PILA DE LOS PRODUCTOS CON SUS RESPECTIVOS PRECIOS\n");
        for(Producto n : pila){
            System.out.println(n.getProducto() + " - " + n.getPrecio());
        }


        //PASAMOS LOS DATOS DE LA PILA A UN ARRAY
        while(!pila.isEmpty()){
            lista.add(pila.pop());
        }

        System.out.println("\nMOSTRAMOS LOS DATOS DE LA LISTA");
        for(Producto n : lista){
            System.out.println(n.getProducto() + " - " + n.getPrecio());
        }


        //ORDENAMIENTO DE BURBUJA

        for(int i = 0; i < lista.size() - 1; i++){
            for(int j = 0; j < lista.size() - 1 - i; j++){
                if(lista.get(j).getPrecio() > lista.get(j + 1).getPrecio()){
                    Producto tem = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, tem);
                }
            }
        }


        System.out.println("\nMIRAMOS LOS PRODUCTO DE MENOR A MAYOR DE LA LISTA: ");
        for(Producto n : lista){
            System.out.println(n.getProducto() + " - " + n.getPrecio());
        }

    }
}

class Producto{
    private String producto;
    private double precio;

    public Producto(String producto, double precio){
        this.producto = producto;
        this.precio = precio;
    }

    public String getProducto(){
        return producto;
    }

    public double getPrecio(){
        return precio;
    }

}
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio4ArraPrueba{
    public static void main(String[] args){

        int opc;
        ProductosDAo dao = new ProductosDAo();
        
        try(Scanner scan = new Scanner(System.in)){

            do{
                System.out.println("\nSISTEMA DE PRODUCTOS");
                System.out.println("1. Agregar productos");
                System.out.println("2. MOSTRAR PRODUCTOS");
                System.out.println("3. ACTUALIZAR PRECIOS");
                System.out.println("4. ELIMINAR PRODUCTO");
                opc = scan.nextInt();
                scan.nextLine();

                switch(opc){
                    case 1 ->{

                        System.out.println("INGRESE EL NOMBRE DEL PRODUCTO");
                        String nombreproducto = scan.nextLine();
                        System.out.println("INGRESE EL PRECIO");
                        double precio = scan.nextDouble();
                        scan.nextLine();

                        
                        dao.agregar(nombreproducto, precio);
                        break;
                    }
                    case 2 ->{
                        System.out.println("MOSTRANDO PRODUCTOS");
                        dao.MostrarProductos();
                        break;
                    }
                    case 3 ->{
                        System.out.println("ACTUALIZACION DE PRODUCTOS");
                        System.out.println("INGRESE EL NOMBRE DEL PRODUCTO");
                        dao.MostrarProductos();
                        System.out.println("\n");
                        String nombre = scan.nextLine();
                        System.out.println("Ingrese el precio nuevo");
                        double precionuevo = scan.nextDouble();
                        scan.nextLine();
                        dao.Actualizar(nombre, precionuevo); 
                        break;
                    }
                    case 4 ->{
                        System.out.println("ELIMINAR PRODUCTO");
                        System.out.println("ESCRIBA EL NOMBRE A ELIMINAR");
                        dao.MostrarProductos();
                        String nombre = scan.nextLine();
                        dao.Eliminar(nombre);
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

    public void MostrarProductos(){
        
        if(listaproductos.isEmpty()){
            System.out.println("LISTA VACÍA");
            return;
        }
        
        for(Productos p : listaproductos){
            System.out.println("Nombre: " + p.getNombreproducto());
            System.out.println("Precio: " + p.getPrecio());
        }
    }

    public void Actualizar(String nombre, double precionuevo){

        if(listaproductos.isEmpty()){
            System.out.println("LISTA VACIA");
            return;
        }

        for(Productos p : listaproductos){
            if(p.getNombreproducto().equalsIgnoreCase(nombre)){
                p.setPrecio(precionuevo);
                System.out.println("CAMBIO REALIZADO");
                break;
            }else{
                System.out.println("CAMBIO NO REALIZADO");
            }
        }

    }

    public void Eliminar(String nombre){

        Iterator<Productos> eliminar = listaproductos.iterator();
        boolean productoeliminado = false;

        while(eliminar.hasNext()){
            Productos producto = eliminar.next();
            if(producto.getNombreproducto().equalsIgnoreCase(nombre)){
                productoeliminado = true;
                eliminar.remove();
                System.out.println("PRODUCTO ELIMINADO");
            }
        }

    }

}
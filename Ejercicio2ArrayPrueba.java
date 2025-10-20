import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio2ArrayPrueba{
    public static void main(String [] args){

        int opc;
        int codigo_producto, cantidad_producto;
        String nombre_producto;
        double precio_producto;
        CRUD crud = new CRUD();

        try(Scanner scan = new Scanner(System.in)){
            do{
            
                System.out.println("\nSISTEMA DE INVENTARIO");
                System.out.println("1. AGREGAR PRODUCTO");
                System.out.println("2. MOSTRAR TODOS LOS PRODUCTOS");
                System.out.println("3. BUSCAR PRODUCTO POR CODIGO");
                System.out.println("4. ACTUALIZAR PRECIO O STOCK");
                System.out.println("5. ELIMINAR PRODUCTO POR CODIGO/NOMBRE");
                System.out.println("6. CALCULAR EL VALOR TOTAL DEL INVENTARIO");
                System.out.println("7. MOSTRAR PRODUCTOS MÁS CAROS Y MÁS BARATOS");
                opc = scan.nextInt();
                scan.nextLine();
                
                switch(opc){
                    case 1 ->{
                        System.out.println("Ingrese el código del producto");
                        codigo_producto = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Ingrese el Nombre del Producto");
                        nombre_producto = scan.nextLine();
                        System.out.println("Ingrese la cantidad de producto que hay");
                        cantidad_producto = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Ingrese el precio del producto");
                        precio_producto = scan.nextDouble();
                        scan.nextLine();

                        crud.AgragarProducto(codigo_producto, nombre_producto, cantidad_producto, precio_producto);
                        break;


                    }
                    case 2 ->{
                        crud.Mostrar();
                        break;
                    }
                    case 3 ->{
                        System.out.println("BUSQUEDA PRODUCTOS");
                        int codigo_product = scan.nextInt();
                        scan.nextLine();

                        Productos productos = crud.BusquedaProducto(codigo_product);

                        if(productos != null){
                            System.out.println("Producto encontrado:");
                            System.out.println("Código: " + productos.getCodigo_producto());
                            System.out.println("Nombre: " + productos.getNombre_producto());
                            System.out.println("Cantidad: " + productos.getCantidad_producto());
                            System.out.println("Precio: $" + productos.getPrecio_producto());
                        }
                        else{
                            System.out.println("NO ENCONTRADO");
                        }
                        
                        break;
                    }
                    case 4 ->{

                        int codigo_product, cantidad_product = 0;
                        double precio_product = 0.0;
                        

                        System.out.println("\nACTUALIZACION DE DATOS");
                        System.out.println("Desea actualizar Precio o Stock");
                        String decision = scan.nextLine();
                        if(decision.equalsIgnoreCase("Precio")){
                            System.out.println("Codigo del producto");
                            codigo_product = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Nuevo precio");
                            precio_product = scan.nextDouble();
                            scan.nextLine();
                            crud.ActualizarProducto(codigo_product, cantidad_product, precio_product, decision);
                        }else if(decision.equalsIgnoreCase("Stock")){
                            System.out.println("Codigo del producto");
                            codigo_product = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Nueva cantidad");
                            cantidad_product = scan.nextInt();
                            scan.nextLine();
                            crud.ActualizarProducto(codigo_product, cantidad_product, precio_product, decision);
                        }
                        break;
                    }
                    case 5 ->{
                        System.out.println("\nELIMINAR PRODUCTO POR CODIGO");
                        System.out.println("ESCRIBA EL CODIGO PARA ELIMINAR PRODUCTO");
                        crud.Mostrar();
                        int codigo_productos = scan.nextInt();
                        scan.nextLine();
                        crud.EliminarProducto(codigo_productos);
                        break;
                    }
                    case 6 ->{
                        crud.InventarioTotal();
                        break;
                    }
                    case 7 ->{
                        crud.ProductosCarosBaratos();
                        break;
                    }
                    case 8 ->{
                        break;
                    }
                }
            }while(opc != 8);
        }//fin del try
        
    }
}

class Productos{

    private int cantidad_producto;
    private int codigo_producto;
    private String nombre_producto;
    private double precio_producto;

    public Productos(int cantidad_producto, int codigo_producto, String nombre_producto, double precio_producto){
        this.cantidad_producto = cantidad_producto;
        this.codigo_producto = codigo_producto;
        this.nombre_producto = nombre_producto;
        this.precio_producto = precio_producto;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public double getPrecio_producto() {
        return precio_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }

}

class CRUD{

    ArrayList<Productos> lista_productos = new ArrayList<>();

    public void AgragarProducto(int codigo_producto, String nombre_producto, int cantidad_producto, double precio_producto ){
        lista_productos.add(new Productos(cantidad_producto, codigo_producto, nombre_producto, precio_producto));
        System.out.println("Producto Agregado");

    }

    public void Mostrar(){
        if(lista_productos.isEmpty()){
            System.out.println("Lista vacía");
            return;
        }
        for(Productos producto : lista_productos){
            System.out.println("Codigo del Producto: " + producto.getCodigo_producto());
            System.out.println("Nombre del Producto: " + producto.getNombre_producto());
            System.out.println("Cantidad del Producto: " + producto.getCantidad_producto());
            System.out.println("Precio del producto: " + producto.getPrecio_producto());
            System.out.println("\n");
        }
    }

    public Productos BusquedaProducto(int codigo_product){
        for(Productos p : lista_productos){
            if(p.getCodigo_producto() == codigo_product){
                return p;
            }
        }
        return null;
    }

    public void ActualizarProducto(int codigo_producto, int nueva_cantidad, double precio_nuevo, String decision){

        for(Productos productos : lista_productos){
            if(productos.getCodigo_producto() == codigo_producto){
                if(decision.equalsIgnoreCase("Precio")){
                    productos.setPrecio_producto(precio_nuevo);
                    System.out.println("Precio Actualizado");
                }
                else if(decision.equalsIgnoreCase("Stock")){
                    productos.setCantidad_producto(nueva_cantidad);
                    System.out.println("Stock Actualizado");
                }
            }
        }

    }

    public void EliminarProducto(int codigo_producto){
        Iterator<Productos> eliminar_producto = lista_productos.iterator();
        boolean productos_eliminado = false;

        while(eliminar_producto.hasNext()){
            Productos productos = eliminar_producto.next();
            if(productos.getCodigo_producto() == codigo_producto){
                eliminar_producto.remove();
                productos_eliminado = true;
                
            }
        }

        if(productos_eliminado){
            System.out.println("Producto Eliminado");
        }
        else if(!productos_eliminado){
            System.out.println("Producto no eliminado");
        }

    }

    public void InventarioTotal(){

        double suma = 0.0;
        for(Productos producto : lista_productos){
            suma += producto.getPrecio_producto() * producto.getCantidad_producto();
        }

        System.out.println("Total de inventario: " + suma);

    }

    public void ProductosCarosBaratos(){

        double producto_caro = lista_productos.get(0).getPrecio_producto();
        double producto_barato = lista_productos.get(0).getPrecio_producto();
        String nombre_producto_caro = lista_productos.get(0).getNombre_producto();
        String nombre_producto_barato = lista_productos.get(0).getNombre_producto();

        for(Productos productos : lista_productos){
            if(productos.getPrecio_producto() > producto_caro){
                producto_caro = productos.getPrecio_producto();
                nombre_producto_caro = productos.getNombre_producto();
            }
            else if(productos.getPrecio_producto() < producto_barato){
                producto_barato = productos.getPrecio_producto();
                nombre_producto_barato = productos.getNombre_producto();
            }
        }

        System.out.println("Producto Caro: ");
        System.out.println(nombre_producto_caro + " === " + "$" +producto_caro);
        System.out.println("Producto Barato: ");
        System.out.println(nombre_producto_barato + " === " + "$" + producto_barato);

    }

}
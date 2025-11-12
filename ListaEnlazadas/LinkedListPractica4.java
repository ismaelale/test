import java.util.ArrayList;

class Cliente{

    ArrayList<Pedido> lista_pedido;
    String nombre_cliente;
    Cliente siguiente;

    Cliente(String nombre_cliente){
        this.nombre_cliente = nombre_cliente;
        this.lista_pedido = new ArrayList<>();
        this.siguiente = null;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public ArrayList<Pedido> getLista_pedido() {
        return lista_pedido;
    } 

    

}


class Pedido{

    String nombre_platillo;
    double precio_platillo;

    Pedido(String nombre_platillo, double precio_platillo){
        this.nombre_platillo = nombre_platillo;
        this.precio_platillo = precio_platillo;
    }

    public String getNombre_platillo() {
        return nombre_platillo;
    }

    public double getPrecio_platillo() {
        return precio_platillo;
    }

    

}

class ListaPedidos{

    Cliente primero;
    private ArrayList<Cliente> lista_cliente = new ArrayList<>();
    ArrayList<Pedido> lista_pedido = new ArrayList<>();

    public void AgregarPlatillos(String nombre_platillo, double precio_platillo){
        
        Pedido nuevo_pedido = new Pedido(nombre_platillo, precio_platillo);
        lista_pedido.add(nuevo_pedido);

    }

    public void VerPlatillo(){
        for(Pedido p : lista_pedido){
            System.out.println();
            System.out.println(p.nombre_platillo);
            System.out.println(p.precio_platillo);
            System.out.println();
        }
    }

    public void RegistrarPedidos(String nombre_platillo, String nombre_cliente){

        if(lista_pedido.isEmpty()){
            System.out.println("NO HAY PLATILLOS DISPONIBLES");
            return;
        }

        boolean platillo_encontrado = false;

        for(Pedido p : lista_pedido){
            if(p.nombre_platillo.equalsIgnoreCase(nombre_platillo)){

                platillo_encontrado = true;

                Cliente cliente_cliente = new Cliente(nombre_cliente);
                cliente_cliente.lista_pedido.add(p);
                lista_cliente.add(cliente_cliente);

                if(primero == null){
                    primero = cliente_cliente;
                }
                else{
                    Cliente actual = primero;
                    while(actual.siguiente != null){
                        actual = actual.siguiente;
                    }
                    actual.siguiente = cliente_cliente;
                }
            }
        }

        if(!platillo_encontrado){
            System.out.println("NO ENCONTRADO");
        }


    }


    public void MostrarPedidos(){

        
        for(Cliente c : lista_cliente){
            System.out.println();
            System.out.println(c.nombre_cliente);
            for(Pedido p : c.lista_pedido){
                System.out.println(p.nombre_platillo);
                System.out.println(p.precio_platillo);
            }
        }

    }

    public void EliminarPedidos(String nombre_cliente, String pedido_nombre){

        

    }

    public void CalcularTotal(){

    }

    public void ClientesPedidos(){

    }

}

public class LinkedListPractica4{
    public static void main(String[] args){

        ListaPedidos listapedidos = new ListaPedidos();
        listapedidos.AgregarPlatillos("CHULETA", 200);
        listapedidos.AgregarPlatillos("CARNE", 150);
        listapedidos.AgregarPlatillos("PESCADO", 180);

        System.out.println();
        System.out.println("LISTA PLATILLOS");
        listapedidos.VerPlatillo();
        System.out.println();

        System.out.println("LISTA PEDIDOS");
        System.out.println();
        listapedidos.RegistrarPedidos("CHULETA", "ISMAEL");
        listapedidos.RegistrarPedidos("CARNE", "ALEJANDRO");
        listapedidos.MostrarPedidos();

        System.out.println();
        System.out.println("ELIMINAR");
        listapedidos.EliminarPedidos("ALEJANDRO", "CARNE");
        System.out.println();
        listapedidos.MostrarPedidos();
    }
}
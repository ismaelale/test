import java.util.ArrayList;
import java.util.Scanner;

class Pedidos{
    String client;
    String description;
    boolean completd;
    Pedidos siguiente;

    Pedidos(String client, String description){
        this.client = client;
        this.description = description;
        this.completd = false;
        this.siguiente = null;
    }

}

class ListaPedidos{

    Pedidos nodo;
    ArrayList<Pedidos> pedidoslista = new ArrayList<>();

    public void Add(String client, String description){
        
        Pedidos nuevo = new Pedidos(client, description);

        if(nodo == null){
            nodo = nuevo;
        }
        else{
            Pedidos actual = nodo;
            while(actual.siguiente != null){    
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        System.out.println("AGREGADOO");

    }

    public void ViewsPending(){

        if(nodo == null){
            System.out.println("ESTA VACÍA");
            return;
        }

        Pedidos actual = nodo;
        while(actual != null){
            if(actual.completd == true){
                System.out.println("Client : " + actual.client + " ---Description:  " + actual.description + " --- Estatus: COMPLETED");
                
            }
            else{
                System.out.println("Client : " + actual.client + " ---Description:  " + actual.description + " --- Estatus: PENDIENT");
            }
            actual = actual.siguiente;
        }
    }

    public void MarkOrder(String client){

        if(nodo == null){
            System.out.println("IS EMPTY");
            return;
        }

        Pedidos actual = nodo;
        Pedidos anterior = null;
        boolean encontrado = false;
        while(actual != null){
            if(actual.client.equals(client)){
                encontrado = true;
                actual.completd = true;
                pedidoslista.add(actual);

                if(anterior == null){
                    nodo = actual.siguiente;
                }
                else{
                    anterior.siguiente = actual.siguiente;
                }
            }
            anterior = actual;
            actual = actual.siguiente;
        }

        if(encontrado){
            System.out.println("Change Realice");
        }
        else{
            System.out.println("Not realice change");
        }

    }

    public void ViewOrdersPending(){

        if(nodo == null){
            System.out.println("IS EMPTY");
            return;
        }

        Pedidos actual = nodo;
        while(actual != null){
            if(actual.completd == false){
                System.out.println("Client: " + actual.client + " -- Description: " + actual.description + " -- Status: Pendient");
            }
            actual = actual.siguiente;
        }

    }

    public void ViewOrderConfirmed(){

        for(Pedidos e : pedidoslista){
            System.out.println(e.client + " ==== " + e.description);
        }

    }

}

public class Nodo5Ejercicio{

    

    public static void main(String[] args){
        ListaPedidos listapedidos = new ListaPedidos();
        try(Scanner scan = new Scanner(System.in)){
        
            int opc;

            do{
                System.out.println("\n\tRESTAURANT SYSTEM");
                System.out.println("1. PEDIDS ADD");
                System.out.println("2. VIEW PENDING ORDERS");
                System.out.println("3. MARK PENDING AS COMPLETED");
                System.out.println("4. VIEW ORDERS PENDING HISTORY");
                System.out.println("5. VIEW ORDERS CONFIRMED");
                System.out.println("6. ORDER CANCEL");
                opc = scan.nextInt();

                scan.nextLine();

                switch(opc){
                    case 1 -> {
                        System.out.println("\n\tADD PEDIDS");
                        System.out.println("CLIENT");
                        String client = scan.nextLine();
                        System.out.println("Description");
                        String description = scan.nextLine();
                        listapedidos.Add(client, description);
                        break;
                    }
                    case 2 ->{
                        System.out.println("\n\tVIEW");
                        listapedidos.ViewsPending();
                        break;
                    }
                    case 3 ->{
                        System.out.println("\n\tMARK PENDING AS COMPLETED");
                        System.out.println("Ingrese he client");
                        String client = scan.nextLine();
                        listapedidos.MarkOrder(client);
                        break;
                    }
                    case 4 ->{
                        System.out.println("\n\tViews Pending Orders");
                        listapedidos.ViewOrdersPending();
                        break;
                    }
                    case 5 ->{
                        System.out.println("\n\tViews Confirmed Orders");
                        listapedidos.ViewOrderConfirmed();
                        break;
                    }
                }
                    



            }while(opc != 7);


        }

    }
}
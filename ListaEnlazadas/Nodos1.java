public class Nodos1{
    public static void main(String[] args){
        Nodo n1 = new Nodo(10);
        Nodo n2 = new Nodo(20);
        Nodo n3 = new Nodo(30);

        n1.siguiente = n2;
        n2.siguiente = n3;

        Nodo actual = n1;
        while(actual != null){
            System.out.println(actual.valor);
            actual = actual.siguiente;
        }
    }
}

class Nodo{
    int valor;
    Nodo siguiente;

    Nodo(int valor){
        this.valor = valor;
        this.siguiente = null;
    }
}
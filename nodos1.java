public class nodos1{
    public static void main(String[] args){

        Object[] nodoizqu = {5, null, null};
        Object[] nododere = {15, null, null};
        Object[] raiz = {10, nodoizqu, nododere};

        System.out.println("Raiz: " + raiz[0]);
        System.out.println("Izquierda: " + ((Object[])raiz[1])[0]);
        System.out.println("Derecha: " + ((Object[])raiz[2])[0]);
        
    }
}
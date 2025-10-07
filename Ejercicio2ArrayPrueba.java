import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicio2ArrayPrueba{
    public static void main(String [] args){

    }
}

class Productos{

    private int cantidad_producto;
    private String nombre_producto;
    private int codigo_producto;
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

}
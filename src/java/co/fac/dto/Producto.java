package co.fac.dto;

/**
 *
 * @author Sebas Gordillo
 */
public class Producto {

    private String nombre;
    private String marca;
    private int items;

    public Producto() {
    }

    public Producto(String producto, String marca, int intems) {
        this.nombre = producto;
        this.marca = marca;
        this.items = intems;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Productos{" + "producto=" + nombre + ", marca=" + marca + ", intems=" + items + '}';
    }

}

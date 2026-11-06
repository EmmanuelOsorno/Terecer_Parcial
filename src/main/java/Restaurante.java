import java.util.ArrayList;

public class Restaurante {
    //atributos
    private String nombreComercial;
    private int NIT;
    private String direccion;

    //listas
    private ArrayList<Cliente> ListaClientes;

    //constructor
    public Restaurante(String nombreComercial, int NIT, String direccion) {
        this.nombreComercial = nombreComercial;
        this.NIT = NIT;
        this.direccion = direccion;

        this.ListaClientes = new ArrayList<>();
    }

    //get y set
    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public int getNIT() {
        return NIT;
    }

    public void setNIT(int NIT) {
        this.NIT = NIT;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Cliente> getListaClientes() {
        return ListaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        ListaClientes = listaClientes;
    }
}

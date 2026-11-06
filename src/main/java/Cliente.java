import java.util.ArrayList;

public class Cliente {
    //atributos
    private int numeroDocumento;
    private String nombre;
    private int telefono;
    private String corre;
    private String direccionResidencia;

    //listas
    private ArrayList<Pedido> ListaPedidios;

    //constructor
    public Cliente(int numeroDocumento, String nombre, int telefono, String corre, String direccionResidencia) {
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.corre = corre;
        this.direccionResidencia = direccionResidencia;

        this.ListaPedidios = new ArrayList<>();
    }

    //get y set
    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorre() {
        return corre;
    }

    public void setCorre(String corre) {
        this.corre = corre;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public ArrayList<Pedido> getListaPedidios() {
        return ListaPedidios;
    }

    public void setListaPedidios(ArrayList<Pedido> listaPedidios) {
        ListaPedidios = listaPedidios;
    }
}

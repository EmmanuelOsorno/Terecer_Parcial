import java.util.ArrayList;

public class Cliente {
    //atributos
    private String numeroDocumento;
    private String nombre;
    private int telefono;
    private String correo;
    private String direccionResidencia;

    //listas
    private ArrayList<Pedido> ListaPedidios;

    //constructor
    public Cliente(String numeroDocumento, String nombre, int telefono, String correo, String direccionResidencia) {
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccionResidencia = direccionResidencia;

        this.ListaPedidios = new ArrayList<>();
    }

    //get y set
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

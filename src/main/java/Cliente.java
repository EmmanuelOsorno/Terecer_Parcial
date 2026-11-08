import java.util.ArrayList;

public class Cliente {
    //atributos
    private String numeroDocumento;
    private String nombreCompleto;
    private int telefono;
    private String correo;
    private String direccionResidencia;

    //listas
    private ArrayList<Pedido> ListaPedidos;

    //constructor
    public Cliente(String numeroDocumento, String nombreCompleto, int telefono, String correo, String direccionResidencia) {
        this.numeroDocumento = numeroDocumento;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.direccionResidencia = direccionResidencia;
        this.ListaPedidos = new ArrayList<>();
    }

    //get y set
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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

    public ArrayList<Pedido> getListaPedidos() {
        return ListaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        ListaPedidos = listaPedidos;
    }

    //Verificar pedido
    public boolean verificarPedidos(String codigoPedido) {

        for (Pedido pedido : ListaPedidos) {
            if (pedido.getCodigoPedido().equals(codigoPedido)) {
                return true;
            }
        }
        return false;
    }

    //Mètodo agregar pedido
    public boolean agregarPedidoCliente(Pedido pedido) {
        boolean agregado = false;

        boolean existe = verificarPedidos(pedido.getCodigoPedido());

        if (existe == false) {
            ListaPedidos.add(pedido);
            agregado = true;
        }

        return agregado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "numeroDocumento='" + numeroDocumento + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", telefono=" + telefono +
                ", correo='" + correo + '\'' +
                ", direccionResidencia='" + direccionResidencia + '\'' +
                ", ListaPedidos=" + ListaPedidos +
                '}';
    }
}

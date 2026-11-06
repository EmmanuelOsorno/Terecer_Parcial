import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {

    //atributos
    private String codigo;
    private LocalDate fecha;
    private Cliente cliente;
    private ModalidadEntrega modalidadEnterga;
    private double distancia;

    //listas
    private ArrayList<Producto> ListaProductos;

    //constructor
    public Pedido(String codigo, LocalDate fecha, Cliente cliente, ModalidadEntrega modalidadEnterga, double distancia) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = cliente;
        this.modalidadEnterga = modalidadEnterga;
        this.distancia=distancia;

        this.ListaProductos = new ArrayList<>();
    }

    //get y set
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ModalidadEntrega getModalidadEnterga() {
        return modalidadEnterga;
    }

    public void setModalidadEnterga(ModalidadEntrega modalidadEnterga) {
        this.modalidadEnterga = modalidadEnterga;
    }

    public ArrayList<Producto> getListaProductos() {
        return ListaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        ListaProductos = listaProductos;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}

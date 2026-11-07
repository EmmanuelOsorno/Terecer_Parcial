import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {

    //atributos
    private String codigo;
    private LocalDate fecha;
    private Cliente cliente;
    private Entrega entrega;
    private double distancia;

    //listas
    private ArrayList<detallePedido> ListadetallePedidos;

    //constructor
    public Pedido(String codigo, LocalDate fecha, Cliente cliente, Entrega entrega, double distancia) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = cliente;
        //es de tipo interface Entrega porque puede guardar cualquiera de los tipos de entrega que implemetan esa interface, ademas es en la interface donde estan los metodos que necesitamos para este atributo
        this.entrega = entrega;
        this.distancia=distancia;

        this.ListadetallePedidos = new ArrayList<>();
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

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public ArrayList<detallePedido> getListadetallePedidos() {
        return ListadetallePedidos;
    }

    public void setListadetallePedidos(ArrayList<detallePedido> listadetallePedidos) {
        ListadetallePedidos = listadetallePedidos;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", cliente=" + cliente +
                ", entrega=" + entrega +
                ", distancia=" + distancia +
                ", ListadetallePedidos=" + ListadetallePedidos +
                '}';
    }
}


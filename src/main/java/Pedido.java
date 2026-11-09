import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {

    //atributos
    private String codigoPedido;
    private LocalDate fecha;
    private double distancia;
    private Cliente cliente;
    private Entrega entrega;
    private EstadoPedido estadoPedido;


    //listas
    private ArrayList<detallePedido> ListadetallePedidos;

    //constructor
    public Pedido(String codigoPedido, LocalDate fecha, double distancia, Cliente cliente, Entrega entrega, EstadoPedido estadoPedido) {
        this.codigoPedido = codigoPedido;
        this.fecha = fecha;
        this.distancia=distancia;
        this.cliente = cliente;
        //es de tipo interface Entrega porque puede guardar cualquiera de los tipos de entrega que implemetan esa interface, ademas es en la interface donde estan los metodos que necesitamos para este atributo
        this.entrega= entrega;
        this.estadoPedido= EstadoPedido.PENDIENTE; // esta en estado inicial

        this.ListadetallePedidos = new ArrayList<>();

        //para los assertThrow
        if(distancia<=0){
            throw new IllegalArgumentException("La distancia no puede ser negativa");
        }
        if(cliente==null){
            throw new IllegalArgumentException("No se puede registrar un pedido sin un cliente");
        }
        if(codigoPedido.equalsIgnoreCase("00000")){
            throw new IllegalArgumentException("Codigo invalido");
        }
    }

    //get y set

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
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

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
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

    //agregar detalles
    public boolean agregarDetalle(detallePedido detalle) {
        boolean agregado = false;

        if (detalle != null && detalle.validarCantidad()) {
            ListadetallePedidos.add(detalle);
            agregado = true;
        }

        return agregado;
    }

    //calcular valor total
    public double calcularTotalPedido(double costoEntrega) {
        double total = 0;

        for (detallePedido detalle : ListadetallePedidos) {
            total += detalle.calcularSubtotal();
        }

        total += costoEntrega;

        return total;
    }

    //toString
    @Override
    public String toString() {
        return "Pedido " + codigoPedido+
                "\nFecha del pedido: " + fecha +
                "\nDistancia del domicilio: " + distancia +
                "\nCliente: " + cliente.getNombreCompleto() +
                "\nEntrega: " + entrega +
                "\nEstado del pedido: " + estadoPedido +
                "\nDetalle del pedido: " + ListadetallePedidos+"\n";
    }
}


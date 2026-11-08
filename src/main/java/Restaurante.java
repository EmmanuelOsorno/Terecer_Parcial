import java.util.ArrayList;

public class Restaurante {
    //atributos
    private String nombreComercial;
    private int NIT;
    private String direccion;

    //listas
    private ArrayList<Cliente> ListaClientes;
    private ArrayList<Producto>ListaProductos;
    private ArrayList<Pedido>ListaPedidos;
    private ArrayList<Producto>ListaProductosRechazados;

    //constructor
    public Restaurante(String nombreComercial, int NIT, String direccion) {
        this.nombreComercial = nombreComercial;
        this.NIT = NIT;
        this.direccion = direccion;

        this.ListaClientes = new ArrayList<>();
        this.ListaProductos = new ArrayList<>();
        this.ListaPedidos = new ArrayList<>();
        this.ListaProductosRechazados= new ArrayList<>();
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

    public ArrayList<Producto> getListaProductos() {
        return ListaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        ListaProductos = listaProductos;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return ListaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        ListaPedidos = listaPedidos;
    }

    public ArrayList<Producto> getListaProductosRechazados() {
        return ListaProductosRechazados;
    }

    public void setListaProductosRechazados(ArrayList<Producto> listaProductosRechazados) {
        ListaProductosRechazados = listaProductosRechazados;
    }

    //====================METODOS=======================

    //Registrar producto

    public boolean registrarProducto(Producto producto) {
        boolean registrado = false;

        if (producto != null) {
            boolean existe = false;

            // Se mira  la lista de productos disponibles
            for (Producto necesitado : ListaProductos) {
                if (necesitado.getCodigo().equals(producto.getCodigo())) {
                    existe = true;
                    break;
                }
            }

            // Se mira la lista de productos rechazados
            for (Producto necesitado : ListaProductosRechazados) {
                if (necesitado.getCodigo().equals(producto.getCodigo())) {
                    existe = true;
                    break;
                }
            }

            // Si no se encuentra y ninguna de las listas se evalua su calidad
            if (!existe) {
                if (producto.condicionesCalidad()) {
                    ListaProductos.add(producto);
                    registrado = true;
                } else {
                    ListaProductosRechazados.add(producto);
                }
            }
        }

        return registrado;
    }

    //registrar Cliente

    public boolean registrarCliente(Cliente cliente) {
        boolean registrado = false;

        if (cliente != null) {
            boolean existe = false;

            for (Cliente c : ListaClientes) {
                if (c.getNumeroDocumento().equals(cliente.getNumeroDocumento())) {
                    existe = true;
                }
            }

            if (!existe) {
                ListaClientes.add(cliente);
                registrado = true;
            }
        }

        return registrado;
    }
    //consultar productos disponibles

    public ArrayList<Producto> consultarProductosDisponibles() {
        ArrayList<Producto> disponibles = new ArrayList<>();

        for (Producto producto : ListaProductos) {
            if (producto.condicionesCalidad()) {
                disponibles.add(producto);
            }
        }

        return disponibles;
    }

    //Consultar productos rechazados

    public ArrayList<Producto> consultarProductosRechazados() {
        ArrayList<Producto> rechazados = new ArrayList<>();

        for (Producto producto : ListaProductosRechazados) {
            if (!producto.condicionesCalidad()) {
                rechazados.add(producto);
            }
        }

        return rechazados;
    }
    //registrar Pedido

    public boolean registrarPedido(Pedido pedido) {
        boolean registrado = false;

        if (pedido != null && pedido.getCliente() != null) {
            boolean clienteRegistrado = false;
            boolean pedidoExiste = false;

            for (Cliente cliente : ListaClientes) {
                if (cliente.getNumeroDocumento().equals(
                        pedido.getCliente().getNumeroDocumento())) {
                    clienteRegistrado = true;
                }
            }

            for (Pedido x : ListaPedidos) {
                if (x.getCodigoPedido().equals(pedido.getCodigoPedido())) {
                    pedidoExiste = true;
                }
            }

            if (clienteRegistrado && !pedidoExiste) {

                if (pedido.getCliente().agregarPedidoCliente(pedido)) {
                        ListaPedidos.add(pedido);
                        registrado = true;
                }


            }
        }


        return registrado;
    }

    //Buscar pedido
    public Pedido buscarPedido(String codigoPedido) {
        Pedido pedidoEncontrado = null;

        for (Pedido pedido : ListaPedidos) {
            if (pedido.getCodigoPedido().equals(codigoPedido)) {
                pedidoEncontrado = pedido;
                break;
            }
        }

        return pedidoEncontrado;
    }
    //gestionar domicilio---Valida domicilio

    public boolean gestionarDomicilioPedido(String codigoPedido) {
        boolean gestionado = false;

        Pedido pedido = buscarPedido(codigoPedido);

        if (pedido != null && pedido.getEntrega() != null) {

            double distancia = pedido.getDistancia();

            if (pedido.getEntrega().aceptarEntrega(distancia)) {
                gestionado = true;
            }
        }

        return gestionado;
    }

    //confirmar pedido

    public boolean confirmarPedido(String codigoPedido) {
        boolean confirmado = false;

        Pedido pedido = buscarPedido(codigoPedido);

        if (pedido != null) {

            if (pedido.getEstadoPedido() == EstadoPedido.PENDIENTE &&
                    !pedido.getListadetallePedidos().isEmpty()) {

                pedido.setEstadoPedido(EstadoPedido.CONFIRMADO);
                confirmado = true;
            }
        }

        return confirmado;
    }


    //consultar pedido de los cliente
    public ArrayList<Pedido> consultarPedidosCliente(String numeroDocumento) {
        ArrayList<Pedido> pedidosCliente = new ArrayList<>();

        for (Cliente cliente : ListaClientes) {
            if (cliente.getNumeroDocumento().equals(numeroDocumento)) {
                pedidosCliente.addAll(cliente.getListaPedidos());
                break;
            }
        }

        return pedidosCliente;
    }
    //actualizar estado del pedido

    public boolean actualizarEstadoPedido(String codigoPedido, EstadoPedido nuevoEstado) {
        boolean actualizado = false;

        if (codigoPedido != null && nuevoEstado != null) {

            Pedido pedido = buscarPedido(codigoPedido);

            if (pedido != null) {
                pedido.setEstadoPedido(nuevoEstado);
                actualizado = true;
            }
        }

        return actualizado;
    }



    //===========Reportes=========
    //calcular ingresos del restaurante


    public double calcularIngresosRestaurante() {
        double ingresos = 0;

        for (Pedido pedido : ListaPedidos) {

            if (pedido.getEstadoPedido() == EstadoPedido.CONFIRMADO ||
                    pedido.getEstadoPedido() == EstadoPedido.ENTREGADO) {

                double costoEntrega = pedido.getEntrega().calcularCostoEntrega(
                        pedido.getDistancia()
                );

                ingresos += pedido.calcularTotalPedido(costoEntrega);
            }
        }

        return ingresos;
    }
    //Consultar producto màs vendido

    public Producto obtenerProductoMasVendido() {
        Producto productoMasVendido = null;
        int mayorCantidad = 0;

        for (Producto producto : ListaProductos) {
            int cantidadVendida = 0;

            for (Pedido pedido : ListaPedidos) {

                if (pedido.getEstadoPedido() == EstadoPedido.CONFIRMADO ||
                        pedido.getEstadoPedido() == EstadoPedido.ENTREGADO) {

                    for (detallePedido detalle : pedido.getListadetallePedidos()) {

                        if (detalle.getProducto().getCodigo().equals(producto.getCodigo())) {
                            cantidadVendida += detalle.getCantidad();
                        }
                    }
                }
            }

            if (cantidadVendida > mayorCantidad) {
                mayorCantidad = cantidadVendida;
                productoMasVendido = producto;
            }
        }

        return productoMasVendido;
    }

    //ingreso mayor por categoria

}

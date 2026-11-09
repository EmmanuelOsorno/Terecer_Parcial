public class detallePedido {
    private  int cantidad;
    private Producto producto;

    public detallePedido(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto= producto;

        //para los assertThrow
        if(cantidad<=0){
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        if(producto==null){
            throw new IllegalArgumentException("Se necesita minimo un prodcuto para generar el detalle del pedido");
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    //valida cantida
    public boolean validarCantidad() {
        return cantidad > 0;
    }
    //calcular sub total
    public double calcularSubtotal() {
        return producto.precioVenta() * cantidad;
    }

    @Override
    public String toString() {
        return cantidad + " unidades de: "+producto.getNombre();
    }
}

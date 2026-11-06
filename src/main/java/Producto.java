public abstract class Producto {
    //atributos
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precioBase;
    private int tiempoEstimadoPreparacion;

    //constructor
    public Producto(String codigo, String nombre, String descripcion, double precioBase, int tiempoEstimadoPreparacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.tiempoEstimadoPreparacion = tiempoEstimadoPreparacion;
    }

    //get y set
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getTiempoEstimadoPreparacion() {
        return tiempoEstimadoPreparacion;
    }

    public void setTiempoEstimadoPreparacion(int tiempoEstimadoPreparacion) {
        this.tiempoEstimadoPreparacion = tiempoEstimadoPreparacion;
    }

    //metodos abstractos
    public abstract double precioVenta();
    //es boolean porque necesitamos saber si cumple o no con las condiciones
    public abstract boolean condicionesCalidad();
}

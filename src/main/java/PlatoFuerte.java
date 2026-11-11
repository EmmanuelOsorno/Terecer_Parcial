public class PlatoFuerte extends Producto{
    //atributos
    private double pesoGramos;
    private TipoPreparacion tipoPreparacion;
    private boolean ControlCocion;

    //constructor
    public PlatoFuerte(String codigo, String nombre, String descripcion, double precioBase, int tiempoEstimadoPreparacion, double pesoGramos, TipoPreparacion tipoPreparacion, boolean controlCocion) {
        super(codigo, nombre, descripcion, precioBase, tiempoEstimadoPreparacion);
        this.pesoGramos = pesoGramos;
        this.tipoPreparacion = tipoPreparacion;
        ControlCocion = controlCocion;

        //para los assertThrow
        if(precioBase<=0){
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        if(pesoGramos<=0){
            throw new IllegalArgumentException("El peso no puede ser negativo");
        }
    }

    //get y set
    public double getPesoGramos() {
        return pesoGramos;
    }

    public void setPesoGramos(double pesoGramos) {
        this.pesoGramos = pesoGramos;
    }

    public TipoPreparacion getTipoPreparacion() {
        return tipoPreparacion;
    }

    public void setTipoPreparacion(TipoPreparacion tipoPreparacion) {
        this.tipoPreparacion = tipoPreparacion;
    }

    public boolean isControlCocion() {
        return ControlCocion;
    }

    public void setControlCocion(boolean controlCocion) {
        ControlCocion = controlCocion;
    }

    //calcular precio de plato fuerte
    @Override
    public double precioVenta() {
        double precioPlatoFuerte=(getPrecioBase()*0.20)+getPrecioBase();
        return precioPlatoFuerte;
    }

    //condiciones de calidad
    @Override
    public boolean condicionesCalidad() {
        boolean peso=(pesoGramos>=200&&pesoGramos<=900);
        boolean tiempoPreparacion=(getTiempoEstimadoPreparacion()>=10&&getTiempoEstimadoPreparacion()<=60);
        return peso && tiempoPreparacion && ControlCocion;
    }

    //toString
    @Override
    public String toString() {
        return "Plato Fuerte: " + super.toString()+
                "\nPeso (Gramos): " + pesoGramos +
                "\nPresentacion: " + tipoPreparacion +
                "\nControl de cocion: " + ControlCocion+
                "\n";
    }
}

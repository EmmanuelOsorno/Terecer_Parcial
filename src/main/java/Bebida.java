public class Bebida extends Producto{
    //atributos
    private double volumenMililitros;
    private double temperaturaServicio;
    private TipoBebida tipoBebida;
    private boolean preparacionEspecial;

    //constructor
    public Bebida(String codigo, String nombre, String descripcion, double precioBase, int tiempoEstimadoPreparacion, double volumenMililitros, double temperaturaServicio, TipoBebida tipoBebida, boolean preparacionEspecial) {
        super(codigo, nombre, descripcion, precioBase, tiempoEstimadoPreparacion);
        this.volumenMililitros = volumenMililitros;
        this.temperaturaServicio = temperaturaServicio;
        this.tipoBebida = tipoBebida;
        this.preparacionEspecial = preparacionEspecial;
    }

    //get y set
    public double getVolumenMililitros() {
        return volumenMililitros;
    }

    public void setVolumenMililitros(double volumenMililitros) {
        this.volumenMililitros = volumenMililitros;
    }

    public double getTemperaturaServicio() {
        return temperaturaServicio;
    }

    public void setTemperaturaServicio(double temperaturaServicio) {
        this.temperaturaServicio = temperaturaServicio;
    }

    public TipoBebida getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(TipoBebida tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public boolean isPreparacionEspecial() {
        return preparacionEspecial;
    }

    public void setPreparacionEspecial(boolean preparacionEspecial) {
        this.preparacionEspecial = preparacionEspecial;
    }

    //calcular precio de bebida
    @Override
    public double precioVenta() {
        double precioBebida=(getPrecioBase()*0.10)+getPrecioBase();
        //si requiere preparacion especial
        if(preparacionEspecial==true){
            precioBebida+=3000;
        }
        return precioBebida;
    }

    //condiciones de calidad
    @Override
    public boolean condicionesCalidad() {
        boolean volumen=(volumenMililitros>=150 && volumenMililitros<=1500);
        boolean temperatura;
        if(tipoBebida==TipoBebida.FRIA){
            temperatura=(temperaturaServicio>=0&&temperaturaServicio<=10);
        }else{
            temperatura=(temperaturaServicio>=55&&temperaturaServicio<=85);
        }
        return volumen&&temperatura;
    }

    //toString
    @Override
    public String toString() {
        return "Bebida: " + super.toString()+
                "\nVolumen (Mililitros): " + volumenMililitros +
                "\nTemperatura al servicio: " + temperaturaServicio +
                "\nTipo: " + tipoBebida +
                "\nPreparacion especial: " + preparacionEspecial +
                "\n";

    }
}

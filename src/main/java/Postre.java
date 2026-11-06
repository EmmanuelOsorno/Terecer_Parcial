public class Postre extends Producto{
    //atributos
    private double pesoGramos;
    private double temperaturaAlmacenamiento;
    //boolean porque solo puede ser refrigerado o no
    private boolean refrigeracion;

    //constructor
    public Postre(String codigo, String nombre, String descripcion, double precioBase, int tiempoEstimadoPreparacion, double pesoGramos, double temperaturaAlmacenamiento, boolean refrigeracion) {
        super(codigo, nombre, descripcion, precioBase, tiempoEstimadoPreparacion);
        this.pesoGramos = pesoGramos;
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
        this.refrigeracion = refrigeracion;
    }

    //get y set
    public double getPesoGramos() {
        return pesoGramos;
    }

    public void setPesoGramos(double pesoGramos) {
        this.pesoGramos = pesoGramos;
    }

    public double getTemperaturaAlmacenamiento() {
        return temperaturaAlmacenamiento;
    }

    public void setTemperaturaAlmacenamiento(double temperaturaAlmacenamiento) {
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
    }

    public boolean isRefrigeracion() {
        return refrigeracion;
    }

    public void setRefrigeracion(boolean refrigeracion) {
        this.refrigeracion = refrigeracion;
    }

    //calcular precio de postre
    @Override
    public double precioVenta() {
        double precioPostre=getPrecioBase();
        if(refrigeracion==true){
            precioPostre+=(getPrecioBase()*0.05);
        }
        return precioPostre;
    }

    //condiciones de calidad
    @Override
    public boolean condicionesCalidad() {
        boolean peso=(pesoGramos>=80&&pesoGramos<=500);
        boolean temperatura;
        if(refrigeracion==true){
            temperatura=(temperaturaAlmacenamiento>=0&&temperaturaAlmacenamiento<=6);
        }else{
            temperatura=(temperaturaAlmacenamiento>=15&&temperaturaAlmacenamiento<=30);
        }
        return peso && temperatura;
    }
}

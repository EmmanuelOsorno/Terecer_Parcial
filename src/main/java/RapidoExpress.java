public class RapidoExpress extends ModalidadEntregas implements Entrega{

    public RapidoExpress(){
        super(5000);
    }

    @Override
    public double calcularCostoEntrega(double distancia) {
        return 5000+(1500*distancia);
    }
    @Override
    public boolean aceptarEntrega(double distancia) {
        boolean acepto=false;
        if (distancia <= 12) {
            acepto= true;
        }
        return acepto;
    }
}

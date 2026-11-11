public class EntregaSegura extends ModalidadEntregas implements Entrega{
    public EntregaSegura(){
        super(7000);
    }

    @Override
    public double calcularCostoEntrega(double distancia) {
        double costo=getValorBase()+(1000*distancia);
        if(distancia>5){
            costo+=3000;
        }
        return costo;
    }

    @Override
    public boolean aceptarEntrega(double distancia) {
        boolean acepto=false;
        if(distancia<=20){
            acepto=true;
        }
        return acepto;
    }

    //toString
    @Override
    public String toString() {
        return "EntregaSegura";
    }
}

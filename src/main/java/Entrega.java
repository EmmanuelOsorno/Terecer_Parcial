public interface Entrega {
    double calcularCostoEntrega(double distancia);
    //boolean porque solo puede aceptar o no
    boolean aceptarEntrega(double distancia);
}

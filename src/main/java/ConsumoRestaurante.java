public class ConsumoRestaurante extends ModalidadEntregas implements Entrega{

    public ConsumoRestaurante(){
        super(0);
    }

    @Override
    //retorna un 0 porque esta consumiento en el restaurante, entonces no paga nada de domicilio
    public double calcularCostoEntrega(double distancia) {
        return 0;
    }

    //true por el mismo motivo
    @Override
    public boolean aceptarEntrega(double distancia) {
        return true;
    }

    //toString

    @Override
    public String toString() {
        return "Consumo en Restaurante";
    }
}

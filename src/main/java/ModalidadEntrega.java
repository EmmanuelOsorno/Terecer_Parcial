public enum ModalidadEntrega implements Entrega{
    CONSUMO_EN_RESTAURANTE(0){
        //retorna un 0 porque esta consumiento en el restaurante
        @Override
        public double calcularCostoEntrega(double distancia) {
            return 0;
        }
        //true por el mismo motivo
        @Override
        public boolean aceptarEntrega(double distancia) {
            return true;
        }
    },
    RAPIDOEXPRESS(5000){
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
    },
    ENTREGASEGURA(7000){
        @Override
        public double calcularCostoEntrega(double distancia) {
            double costo=7000+(1000*distancia);
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
    };

    private final double valorBase;
    ModalidadEntrega(double valorBase){this.valorBase=valorBase;}

    public double getValorBase() {
        return valorBase;
    }
}

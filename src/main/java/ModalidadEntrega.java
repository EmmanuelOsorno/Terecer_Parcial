public enum ModalidadEntrega {
    RAPIDOEXPRESS(5000),
    ENTREGASEGURA(7000);

    private final double valorBase;
    ModalidadEntrega(double valorBase){this.valorBase=valorBase;}

    public double getValorBase() {
        return valorBase;
    }
}

public abstract class ModalidadEntregas {
    //atributos
    private double valorBase;

    //constructor
    public ModalidadEntregas(double valorBase) {
        this.valorBase = valorBase;
    }

    //get y set

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }
}

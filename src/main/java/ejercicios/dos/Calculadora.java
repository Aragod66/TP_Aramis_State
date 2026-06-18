package ejercicios.dos;

public class Calculadora {

    public static final double VALOR_INICIAL = 0.0;
    public static final String MSG_ESTADO_ERROR =
            "La calculadora está en estado de error";

    private double valorAcumulado;
    private EstadoCalculadora estado;
    private Operacion operacionPendiente;

    public Calculadora() {
        this.valorAcumulado = VALOR_INICIAL;
        this.estado = new EstadoInicial();
    }

    public void mas() {
        estado.mas(this);
    }

    public void menos() {
        estado.menos(this);
    }

    public void por() {
        estado.por(this);
    }

    public void dividido() {
        estado.dividido(this);
    }

    public void valor(double valor) {
        estado.valor(this, valor);
    }

    public void mostrar() {
        estado.mostrar(this);
    }

    public void borrar() {
        estado.borrar(this);
    }

    public String estado() {
        return estado.nombre();
    }

    public double getValorAcumulado() {
        return valorAcumulado;
    }

    public void setValorAcumulado(double valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }

    public Operacion getOperacionPendiente() {
        return operacionPendiente;
    }

    public void setOperacionPendiente(Operacion operacionPendiente) {
        this.operacionPendiente = operacionPendiente;
    }

    void setEstado(EstadoCalculadora estado) {
        this.estado = estado;
    }
}
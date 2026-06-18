package ejercicios.dos;

public class EstadoError implements EstadoCalculadora {

    @Override
    public void mas(Calculadora calculadora) {
        System.out.println(Calculadora.MSG_ESTADO_ERROR);
    }

    @Override
    public void menos(Calculadora calculadora) {
        System.out.println(Calculadora.MSG_ESTADO_ERROR);
    }

    @Override
    public void por(Calculadora calculadora) {
        System.out.println(Calculadora.MSG_ESTADO_ERROR);
    }

    @Override
    public void dividido(Calculadora calculadora) {
        System.out.println(Calculadora.MSG_ESTADO_ERROR);
    }

    @Override
    public void valor(Calculadora calculadora, double valor) {
        System.out.println(Calculadora.MSG_ESTADO_ERROR);
    }

    @Override
    public void mostrar(Calculadora calculadora) {
        System.out.println(Calculadora.MSG_ESTADO_ERROR);
    }

    @Override
    public void borrar(Calculadora calculadora) {
        calculadora.setValorAcumulado(Calculadora.VALOR_INICIAL);
        calculadora.setOperacionPendiente(null);
        calculadora.setEstado(new EstadoInicial());
    }

    @Override
    public String nombre() {
        return "ERROR";
    }
}
package ejercicios.dos;

public class EstadoInicial implements EstadoCalculadora {

    @Override
    public void mas(Calculadora calculadora) {
        calculadora.setOperacionPendiente(Operacion.SUMA);
        calculadora.setEstado(new EstadoEsperandoOperando());
    }

    @Override
    public void menos(Calculadora calculadora) {
        calculadora.setOperacionPendiente(Operacion.RESTA);
        calculadora.setEstado(new EstadoEsperandoOperando());
    }

    @Override
    public void por(Calculadora calculadora) {
        calculadora.setOperacionPendiente(Operacion.MULTIPLICACION);
        calculadora.setEstado(new EstadoEsperandoOperando());
    }

    @Override
    public void dividido(Calculadora calculadora) {
        calculadora.setOperacionPendiente(Operacion.DIVISION);
        calculadora.setEstado(new EstadoEsperandoOperando());
    }

    @Override
    public void valor(Calculadora calculadora, double valor) {
        calculadora.setValorAcumulado(valor);
    }

    @Override
    public void mostrar(Calculadora calculadora) {
        System.out.println(calculadora.getValorAcumulado());
    }

    @Override
    public void borrar(Calculadora calculadora) {
        calculadora.setValorAcumulado(Calculadora.VALOR_INICIAL);
        calculadora.setOperacionPendiente(null);
    }

    @Override
    public String nombre() {
        return "INICIAL";
    }
}
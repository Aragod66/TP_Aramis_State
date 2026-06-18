package ejercicios.dos;

public class EstadoEsperandoOperando implements EstadoCalculadora {

    @Override
    public void mas(Calculadora calculadora) {
        calculadora.setEstado(new EstadoError());
    }

    @Override
    public void menos(Calculadora calculadora) {
        calculadora.setEstado(new EstadoError());
    }

    @Override
    public void por(Calculadora calculadora) {
        calculadora.setEstado(new EstadoError());
    }

    @Override
    public void dividido(Calculadora calculadora) {
        calculadora.setEstado(new EstadoError());
    }

    @Override
    public void valor(Calculadora calculadora, double valor) {

        switch (calculadora.getOperacionPendiente()) {

            case SUMA:
                calculadora.setValorAcumulado(
                        calculadora.getValorAcumulado() + valor);
                break;

            case RESTA:
                calculadora.setValorAcumulado(
                        calculadora.getValorAcumulado() - valor);
                break;

            case MULTIPLICACION:
                calculadora.setValorAcumulado(
                        calculadora.getValorAcumulado() * valor);
                break;

            case DIVISION:

                if (valor == 0) {
                    calculadora.setEstado(new EstadoError());
                    return;
                }

                calculadora.setValorAcumulado(
                        calculadora.getValorAcumulado() / valor);
                break;
        }

        calculadora.setOperacionPendiente(null);
        calculadora.setEstado(new EstadoInicial());
    }

    @Override
    public void mostrar(Calculadora calculadora) {
        calculadora.setEstado(new EstadoError());
    }

    @Override
    public void borrar(Calculadora calculadora) {
        calculadora.setValorAcumulado(Calculadora.VALOR_INICIAL);
        calculadora.setOperacionPendiente(null);
        calculadora.setEstado(new EstadoInicial());
    }

    @Override
    public String nombre() {
        return "ESPERANDO_OPERANDO";
    }
}
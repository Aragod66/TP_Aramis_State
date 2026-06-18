package ejercicios.dos;

public interface EstadoCalculadora {

    void mas(Calculadora calculadora);

    void menos(Calculadora calculadora);

    void por(Calculadora calculadora);

    void dividido(Calculadora calculadora);

    void valor(Calculadora calculadora, double valor);

    void mostrar(Calculadora calculadora);

    void borrar(Calculadora calculadora);

    String nombre();
}
package ejercicios.dos;

public class Main {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();

        System.out.println("Estado inicial: " + calculadora.estado());

        calculadora.valor(10);

        System.out.println("Estado después de ingresar 10: "
                + calculadora.estado());

        calculadora.mas();

        System.out.println("Estado después de presionar '+': "
                + calculadora.estado());

        calculadora.mas();

        System.out.println("Estado después de presionar '+' nuevamente: "
                + calculadora.estado());

        calculadora.borrar();

        System.out.println("Estado después de borrar: "
                + calculadora.estado());

        calculadora.valor(10);

        calculadora.mostrar();
    }
}
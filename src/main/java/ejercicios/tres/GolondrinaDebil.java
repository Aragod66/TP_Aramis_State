package ejercicios.tres;

public class GolondrinaDebil implements EstadoGolondrina {

    @Override
    public void realizarDeseo(Golondrina golondrina) {
        golondrina.comer(50);
    }
}
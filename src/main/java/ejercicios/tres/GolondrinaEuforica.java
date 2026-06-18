package ejercicios.tres;

public class GolondrinaEuforica implements EstadoGolondrina {

    @Override
    public void realizarDeseo(Golondrina golondrina) {
        // Vuela 5 km de ida y 5 km de vuelta.
        golondrina.volar(10);
    }
}
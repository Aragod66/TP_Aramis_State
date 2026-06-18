package ejercicios.tres;

public class Golondrina {

    private static final int ENERGIA_INICIAL = 45;
    private static final int UMBRAL_DEBIL = 50;
    private static final int UMBRAL_EUFORICA = 500;

    private int energia;

    public Golondrina() {
        this.energia = ENERGIA_INICIAL;
    }

    public void comer() {
        comer(50);
    }

    public void comer(int gramos) {
        this.energia += gramos * 5;
    }

    public void volar() {
        volar(1);
    }

    public void volar(int kilometros) {
        this.energia -= kilometros + 10;
    }

    public void realizarDeseo() {
        obtenerEstado().realizarDeseo(this);
    }

    private EstadoGolondrina obtenerEstado() {

        if (energia < UMBRAL_DEBIL) {
            return new GolondrinaDebil();
        }

        if (energia > UMBRAL_EUFORICA) {
            return new GolondrinaEuforica();
        }

        return new GolondrinaNormal();
    }

    public int getEnergia() {
        return energia;
    }
}
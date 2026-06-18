package ejercicios.uno;

public class PuertaCerrada implements EstadoPuerta {

    @Override
    public void abrir(Puerta puerta) {
        System.out.println("Abriendo la puerta...");
        puerta.setEstado(new PuertaAbierta());
    }

    @Override
    public void cerrar(Puerta puerta) {
        System.out.println("No se puede cerrar una puerta cerrada");
    }

    @Override
    public String estado() {
        return "CERRADA";
    }
}
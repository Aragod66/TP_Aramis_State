package ejercicios.uno;

public class PuertaAbierta implements EstadoPuerta {

    @Override
    public void abrir(Puerta puerta) {
        System.out.println("No se puede abrir una puerta abierta");
    }

    @Override
    public void cerrar(Puerta puerta) {
        System.out.println("Cerrando la puerta...");
        puerta.setEstado(new PuertaCerrada());
    }

    @Override
    public String estado() {
        return "ABIERTA";
    }
}
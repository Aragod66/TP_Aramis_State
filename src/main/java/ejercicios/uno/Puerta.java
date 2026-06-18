package ejercicios.uno;

public class Puerta {

    private EstadoPuerta estado;

    public Puerta() {
        this.estado = new PuertaCerrada();
    }

    public void abrir() {
        estado.abrir(this);
    }

    public void cerrar() {
        estado.cerrar(this);
    }

    public String estado() {
        return estado.estado();
    }

    void setEstado(EstadoPuerta estado) {
        this.estado = estado;
    }
}
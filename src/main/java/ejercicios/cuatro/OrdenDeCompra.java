package ejercicios.cuatro;

import java.util.ArrayList;
import java.util.List;

public class OrdenDeCompra {

    static final String MSG_ERROR_PREPARACION =
            "La orden solo puede pasar a preparacion desde iniciada";

    static final String MSG_ERROR_SIN_PRODUCTOS =
            "La orden debe tener al menos un producto";

    static final String MSG_ERROR_ENVIAR =
            "La orden solo puede enviarse desde en preparacion";

    static final String MSG_ERROR_CANCELAR =
            "La orden no puede cancelarse en este estado";

    static final String MSG_ERROR_AGREGAR_PRODUCTO =
            "No se pueden agregar productos en este estado";

    private EstadoOrden estado;
    private final List<Producto> productos;
    private double monto;
    private String numeroSeguimiento;

    public OrdenDeCompra() {
        this.estado = new EstadoIniciada();
        this.productos = new ArrayList<>();
        this.monto = 0;
    }

    public void agregarProducto(Producto producto) {
        estado.agregarProducto(this, producto);
    }

    public void confirmarCompra() {
        estado.confirmarCompra(this);
    }

    public void enviar() {
        estado.enviar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public Estado estado() {
        return estado.nombre();
    }

    void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    void agregarProductoInterno(Producto producto) {
        productos.add(producto);
    }

    boolean sinProductos() {
        return productos.isEmpty();
    }

    void calcularMonto() {
        monto = productos.stream()
                .mapToDouble(Producto::precio)
                .sum();
    }

    void generarSeguimiento() {
        numeroSeguimiento = "SEG-" + System.currentTimeMillis();
    }

    public double monto() {
        return monto;
    }

    public String numeroSeguimiento() {
        return numeroSeguimiento;
    }

    public List<Producto> productos() {
        return new ArrayList<>(productos);
    }

    public enum Estado {
        INICIADA,
        EN_PREPARACION,
        ENVIADA,
        CANCELADA
    }
}
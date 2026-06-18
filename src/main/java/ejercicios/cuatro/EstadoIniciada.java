package ejercicios.cuatro;

public class EstadoIniciada implements EstadoOrden {

    @Override
    public void agregarProducto(
            OrdenDeCompra orden,
            Producto producto
    ) {
        orden.agregarProductoInterno(producto);
    }

    @Override
    public void confirmarCompra(OrdenDeCompra orden) {

        if (orden.sinProductos()) {
            throw new IllegalStateException(
                    OrdenDeCompra.MSG_ERROR_SIN_PRODUCTOS
            );
        }

        orden.calcularMonto();
        orden.setEstado(new EstadoEnPreparacion());
    }

    @Override
    public void enviar(OrdenDeCompra orden) {
        throw new IllegalStateException(
                OrdenDeCompra.MSG_ERROR_ENVIAR
        );
    }

    @Override
    public void cancelar(OrdenDeCompra orden) {
        orden.setEstado(new EstadoCancelada());
    }

    @Override
    public OrdenDeCompra.Estado nombre() {
        return OrdenDeCompra.Estado.INICIADA;
    }
}
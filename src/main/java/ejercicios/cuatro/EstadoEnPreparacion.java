package ejercicios.cuatro;

public class EstadoEnPreparacion implements EstadoOrden {

    @Override
    public void agregarProducto(
            OrdenDeCompra orden,
            Producto producto
    ) {
        throw new IllegalStateException(
                OrdenDeCompra.MSG_ERROR_AGREGAR_PRODUCTO
        );
    }

    @Override
    public void confirmarCompra(OrdenDeCompra orden) {
        throw new IllegalStateException(
                OrdenDeCompra.MSG_ERROR_PREPARACION
        );
    }

    @Override
    public void enviar(OrdenDeCompra orden) {
        orden.generarSeguimiento();
        orden.setEstado(new EstadoEnviada());
    }

    @Override
    public void cancelar(OrdenDeCompra orden) {
        orden.setEstado(new EstadoCancelada());
    }

    @Override
    public OrdenDeCompra.Estado nombre() {
        return OrdenDeCompra.Estado.EN_PREPARACION;
    }
}